package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final CustomerServiceImpl customerService = context.getBean(CustomerServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In CustomerServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In CustomerServiceTest after...");
    }

    static Stream<Arguments> generateExistedCustomer() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns"),
                Arguments.of("Farzad", "6Farzadi7")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedCustomer")
    @Order(1)
    public void customerLoginTestWithExistedCustomer(String username, String password) {
        Customer customer = customerService.customerLogin(username, password);
        Assertions.assertNotNull(customer);
    }

    static Stream<Arguments> generateExistedCustomersWithNewPassword() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns", "Taban1122"),
                Arguments.of("Farzad", "6Farzadi7", "LKJh12345")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedCustomersWithNewPassword")
    @Order(2)
    public void updateCustomerPasswordTest(String username, String password, String newPassword) {
        Customer customer = customerService.customerLogin(username, password);
        customerService.changeCustomerPassword(customer, newPassword);
        customer = customerService.customerLogin(username, newPassword);
        Assertions.assertNotNull(customer);
    }

    static Stream<Arguments> generateExistedUserStatus() {
        return Stream.of(
                Arguments.of(UserStatus.VERIFIED),
                Arguments.of(UserStatus.NOT_VERIFIED)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedUserStatus")
    @Order(3)
    public void getAllCustomersByUserStatus(UserStatus userStatus) {
        List<Customer> allCustomersByUserStatus = customerService.getAllCustomersByUserStatus(userStatus);
        Assertions.assertNotNull(allCustomersByUserStatus);
    }
}
