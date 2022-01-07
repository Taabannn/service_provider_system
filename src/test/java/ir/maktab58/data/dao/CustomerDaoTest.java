package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Customer;
import ir.maktab58.exceptions.ServiceSysException;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import java.util.Date;
import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
public class CustomerDaoTest {
    CustomerDao customerDao = new CustomerDao();//mock(CustomerDao.class);
    @Rule
    public org.junit.rules.ExpectedException exceptionRule = ExpectedException.none();

    @BeforeAll
    public static void init() {
        System.out.println("In CustomerDaoTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In CustomerDaoTest after...");
    }

    static Stream<Arguments> generateCustomer() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns", "tabansoleymani@yahoo.com")/*,
                Arguments.of("Maryam", "Maryam123", "maryam@example.com"),
                Arguments.of("Aminn", "12Amin", "aminAmini@example.com")*/
        );
    }

    @ParameterizedTest
    @MethodSource("generateCustomer")
    public void findCustomerByUserAndPassTest_whenFindCustomerByUserAndPassCalls_withExistedCustomer(String username, String password, String email) {
        Customer customer = Customer.builder()
                .withUsername(username)
                .withPassword(password)
                .withEmail(email).withFirstAccess(new Date()).build();
        customerDao.save(customer);
        customerDao.findCustomerByUserAndPass(username, password);
        //verify(managerDao).findManagerByUserAndPass(username, password);
    }

    static Stream<Arguments> generateInvalidCustomer() {
        return Stream.of(
                Arguments.of("Taaba", "61378Tns", "tabansoleymani@yahoo.com"),
                Arguments.of("Maryam", "Maryam3", "maryam@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateInvalidCustomer")
    public void findCustomerByUserAndPassTest_whenFindCustomerByUserAndPassCalls_withNotExistedCustomer(String username, String password) {
        //exceptionRule.expect(ServiceSysException.class);
        //exceptionRule.expectMessage("No manager with entered username and password was found.");
        //managerDao.findManagerByUserAndPass(username, password);
        Assertions.assertThrows(ServiceSysException.class, () -> customerDao.findCustomerByUserAndPass(username, password), "No customer with entered username and password was found.");
        //verify(managerDao).findManagerByUserAndPass(username, password);
    }
}
