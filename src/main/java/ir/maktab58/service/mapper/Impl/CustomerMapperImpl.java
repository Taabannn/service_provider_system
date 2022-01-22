package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.service.mapper.interfaces.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Autowired
    private WalletMapperImpl walletMapper;

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withUsername(customerDto.getUsername())
                .withPassword(customerDto.getPassword())
                .withEmail(customerDto.getEmail())
                .withFirstAccess(customerDto.getFirstAccess())
                .withLastUpdate(customerDto.getLastUpdate())
                .withUserStatus(customerDto.getUserStatus())
                .withWallet(walletMapper.toWallet(customerDto.getWallet()))
                .build();
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withUsername(customer.getUsername())
                .withPassword(customer.getPassword())
                .withEmail(customer.getEmail())
                .withFirstAccess(customer.getFirstAccess())
                .withLastUpdate(customer.getLastUpdate())
                .withUserStatus(customer.getUserStatus())
                .withWallet(walletMapper.toWalletDto(customer.getWallet())).build();
    }
}
