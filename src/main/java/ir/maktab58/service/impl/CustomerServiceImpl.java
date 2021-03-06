package ir.maktab58.service.impl;

import ir.maktab58.data.entities.Transaction;
import ir.maktab58.data.entities.Wallet;
import ir.maktab58.data.enums.TransactionStatus;
import ir.maktab58.data.enums.TransactionType;
import ir.maktab58.data.repository.CustomerAddressRepository;
import ir.maktab58.data.repository.CustomerRepository;
import ir.maktab58.data.entities.Address;
import ir.maktab58.data.entities.CustomerAddress;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.dto.TransactionDto;
import ir.maktab58.dto.WalletDto;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.exceptions.DuplicateUserException;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.interfaces.CustomerService;
import ir.maktab58.service.mapper.Impl.CustomerMapperImpl;
import ir.maktab58.service.mapper.Impl.TransactionMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Taban Soleymani
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Autowired
    CustomerMapperImpl customerMapper;

    @Autowired
    TransactionMapperImpl transactionMapper;

    @Autowired
    TransactionServiceImpl transactionService;

    @Override
    public Customer customerLogin(CustomerDto customerDto) {
        Optional<Customer> foundedCustomer = customerRepository.findCustomerByUsernameAndPassword(customerDto.getUsername(), customerDto.getPassword());
        if (!foundedCustomer.isPresent())
            throw ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        return foundedCustomer.get();
    }

    @Override
    public void changeCustomerPassword(CustomerDto customerDto, String newPassword) {
        customerRepository.updateCustomerPassword(customerDto.getUsername(), customerDto.getPassword(), newPassword);
        customerRepository.updateCustomerLastUpdate(customerDto.getUsername(), newPassword, new Date());
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomersByUserStatus(UserStatus userStatus) {
        return customerRepository.getAllByUserStatus(userStatus);
    }

    @Override
    public void updateCustomerStatus(Customer customer, UserStatus newUserStatus) {
        customerRepository.updateCustomerStatus(customer.getUsername(), customer.getPassword(), newUserStatus);
    }

    @Override
    public void addAddressToCustomerAddressList(Customer customer, Address address) {
        List<CustomerAddress> customerAddresses = customerAddressRepository.findCustomerAddressByAddress(address);
        List<Customer> customers = customerAddresses.stream().map(CustomerAddress::getCustomer).collect(Collectors.toList());
        if (!customers.contains(customer)) {
            CustomerAddress customerAddress = CustomerAddress.builder()
                    .withAddress(address)
                    .withCustomer(customer).build();
            customerAddressRepository.save(customerAddress);
        }
    }

    public Optional<Customer> findVerifiedCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsernameAndUserStatus(username, UserStatus.VERIFIED);
    }

    public Customer customerSignUp(CustomerDto customerDto) {
        Optional<Customer> customerByUsername = customerRepository.findCustomerByUsername(customerDto.getUsername());
        Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(customerDto.getEmail());

        if (customerByEmail.isPresent())
            throw new DuplicateUserException("This email has been existed.", 400);

        if (customerByUsername.isPresent())
            throw new DuplicateUserException("This username has been existed.", 400);

        Customer customer = customerMapper.toCustomer(customerDto);
        customer.setFirstAccess(new Date());
        customer.setUserStatus(UserStatus.NEW);
        return customerRepository.save(customer);
    }

    public TransactionDto depositCustomerBalance(CustomerDto customer, long amount) {
        Optional<Customer> customerByUsername = customerRepository.findCustomerByUsername(customer.getUsername());
        if (customerByUsername.isPresent()) {
            Customer foundedCustomer = customerByUsername.get();
            Wallet wallet = foundedCustomer.getWallet();
            wallet.setWallet(wallet.getWallet() + amount);
            customerRepository.updateCustomerWallet(wallet.getId(), wallet.getWallet());
            customerRepository.updateCustomerLastUpdate(foundedCustomer.getUsername(), foundedCustomer.getPassword(), new Date());
            return saveDepositTransaction(amount, wallet);
        }
        return null;
    }

    public TransactionDto saveDepositTransaction(long cost, Wallet wallet) {
        Random random = new Random();
        long trackingCode = random.nextLong();
        Transaction transaction = Transaction.builder()
                .withCost(cost)
                .withWallet(wallet)
                .withCreationDate(new Date())
                .withTransactionStatus(TransactionStatus.SUCCESSFUL)
                .withTransactionType(TransactionType.DEPOSIT)
                .withTrackingCode(Math.abs(trackingCode)).build();
        return transactionMapper.toTransactionDto(transactionService.saveNewTransaction(transaction));
    }
}
