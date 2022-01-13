package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManagerServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final ManagerServiceImpl managerService = context.getBean(ManagerServiceImpl.class);
    private final ExpertServiceImpl expertService = context.getBean(ExpertServiceImpl.class);
    private final CustomerServiceImpl customerService = context.getBean(CustomerServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In ManagerServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In ManagerServiceTest after...");
    }

    static Stream<Arguments> generateExistedManager() {
        return Stream.of(
                Arguments.of("Maryam", "Maryam123")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedManager")
    @Order(1)
    public void MangerLoginTestWithExistedManager(String username, String password) {
        Manager manager = managerService.managerLogin(username, password);
        Assertions.assertNotNull(manager);
    }

    static Stream<Arguments> generateExistedExpertsWithNewUserStatus() {
        return Stream.of(
                Arguments.of("Maryam", "Maryam123", "Aminn", "1259Amin", UserStatus.VERIFIED),
                Arguments.of("Maryam", "Maryam123", "AmirA", "AmirAimiri11", UserStatus.NOT_VERIFIED),
                Arguments.of("Maryam", "Maryam123", "Mahnaz", "Mahnaz1366", UserStatus.VERIFIED)
            );
    }

    @ParameterizedTest
    @MethodSource("generateExistedExpertsWithNewUserStatus")
    @Order(2)
    public void updateExpertStatusTest(String user, String pass, String username, String password, UserStatus userStatus) {
        Manager manager = managerService.managerLogin(user, pass);
        Expert expert = expertService.expertLogin(username, password);
        managerService.updateUserStatus(manager, expert, userStatus);
        expert = expertService.expertLogin(username, password);
        Assertions.assertEquals(userStatus, expert.getUserStatus());
    }

    static Stream<Arguments> generateExistedCustomersWithNewUserStatus() {
        return Stream.of(
                Arguments.of("Maryam", "Maryam123", "Taabannn", "61378Tns", UserStatus.VERIFIED),
                Arguments.of("Maryam", "Maryam123", "Farzad", "6Farzadi7", UserStatus.NOT_VERIFIED)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedCustomersWithNewUserStatus")
    @Order(3)
    public void updateCustomerStatusTest(String user, String pass, String username, String password, UserStatus userStatus) {
        Manager manager = managerService.managerLogin(user, pass);
        Customer customer = customerService.customerLogin(username, password);
        managerService.updateUserStatus(manager, customer, userStatus);
        customer = customerService.customerLogin(username, password);
        Assertions.assertEquals(userStatus, customer.getUserStatus());
    }
}
