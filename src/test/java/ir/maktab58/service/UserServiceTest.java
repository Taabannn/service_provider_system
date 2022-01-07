package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.dto.CustomerDTO;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.exceptions.ServiceSysException;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Taban Soleymani
 */
public class UserServiceTest {

    UserService userService = new UserService();//mock(UserService.class);
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeAll
    public static void init() {
        System.out.println("In UserServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In UserServiceTest after...");
    }

    static Stream<Arguments> generateValidEmailAndUserAndPass() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns", "tabansoleymani@yahoo.com"),
                Arguments.of("Maryam", "Maryam123", "maryam@example.com"),
                Arguments.of("Aminn", "12Amin", "aminAmini@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateValidEmailAndUserAndPass")
    public void validateEmailAndUserAndPassTest_whenValidateEmailAndUserAndPassCalls_withValidUsernameAndPasswordAndEmail(String username, String password, String email) {
        userService.validateEmailAndUserAndPass(username, password, email);
        verify(userService).validateEmailAndUserAndPass(username, password, email);
    }

    static Stream<Arguments> generateInvalidEmailAndUserAndPass() {
        return Stream.of(
                Arguments.of("TT", "61378Tns", "tabansoleymani@yahoo.com", "Entered username or password is not valid."),
                Arguments.of("Maryam", "maryam", "maryam@example.com", "Entered username or password is not valid."),
                Arguments.of("Aminn", "12Amin", "aminAmini", "Entered email is not valid.")
        );
    }

    @ParameterizedTest
    @MethodSource("generateInvalidEmailAndUserAndPass")
    public void validateEmailAndUserAndPassTest_whenValidateEmailAndUserAndPassCalls_withInvalidUsernameAndPasswordAndEmail(String username, String password, String email, String message) {
        exceptionRule.expect(ServiceSysException.class);
        exceptionRule.expectMessage(message);
        userService.validateEmailAndUserAndPass(username, password, email);
        verify(userService).validateEmailAndUserAndPass(username, password, email);
    }

    static Stream<Arguments> generateExistedCustomer() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns", "tabansoleymani@yahoo.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedCustomer")
    public void saveCustomerTest_whenSaveCustomerCalls_withExisted(String username, String password, String email) {
        Customer customer = Customer.builder()
                .withUsername(username)
                .withPassword(password)
                .withEmail(email).withFirstAccess(new Date()).build();
        Assertions.assertThrows(ServiceSysException.class, () -> userService.saveCustomer(customer), "This user might have been existed");
    }

    static Stream<Arguments> generateExistedExpert() {
        return Stream.of(
                Arguments.of("Aminn", "12Amin", "aminAmini@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedExpert")
    public void saveExpertTest_whenSaveExpertCalls_withExisted(String username, String password, String email) {
        File file = new File("expert.png");
        byte[] bFile = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(bFile);
        } catch (Exception e) {
            e.getMessage();
        }
        Expert expert = Expert.builder()
                .withUsername(username)
                .withPassword(password)
                .withEmail(email)
                .withFirstAccess(new Date())
                .withImage(bFile).build();
        Assertions.assertThrows(ServiceSysException.class, () -> userService.saveExpert(expert), "This user might have been existed");
    }

    static Stream<Arguments> generateExistedManager() {
        return Stream.of(
                Arguments.of("Maryam", "Maryam123", "maryam@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedCustomer")
    public void saveManagerTest_whenSaveManagerCalls_withExisted(String username, String password, String email) {
        Manager manager = Manager.builder()
                .withUsername(username)
                .withPassword(password)
                .withEmail(email).withFirstAccess(new Date()).build();
        Assertions.assertThrows(ServiceSysException.class, () -> userService.saveManager(manager), "This user might have been existed");
    }

    static Stream<Arguments> generateManager() {
        return Stream.of(
                Arguments.of("Maryam", "Maryam123")
        );
    }

    @ParameterizedTest
    @MethodSource("generateManager")
    public void getListOfCustomersToManagerTest_whenGetListOfCustomersToManagerCalls_withExistedManager(String username, String password) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        userService = context.getBean(UserService.class);
        userService.getListOfCustomersToManager(username, password);
    }

    @ParameterizedTest
    @MethodSource("generateManager")
    public void getListOfExpertsToManagerTest_whenGetListOfExpertsToManagerCalls_withExistedManager(String username, String password) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        userService = context.getBean(UserService.class);
        userService.getListOfExpertsToManager(username, password);
    }
}

