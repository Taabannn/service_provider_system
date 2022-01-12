package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.users.User;
import ir.maktab58.exceptions.ServiceSysException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
public class UserServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final UserServiceImpl userService = context.getBean(UserServiceImpl.class);

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
                Arguments.of("Aminn", "1259Amin", "aminAmini@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateValidEmailAndUserAndPass")
    public void validateEmailAndUserAndPassTest_whenValidateEmailAndUserAndPassCalls_withValidUsernameAndPasswordAndEmail(String username, String password, String email) {
        userService.validateEmailAndUserAndPass(username, password, email);
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
        Assertions.assertThrows(ServiceSysException.class, () -> userService.validateEmailAndUserAndPass(username, password, email), message);
    }

    static Stream<Arguments> generateUsers() {
        File file = new File("C:\\Users\\Taban\\Desktop\\maktab\\service_provider_system\\src\\main\\resources\\expert.png");
        byte[] image = new byte[(int) file.length()];
        try (InputStream inputStream = new FileInputStream(file)){
            int bytesRead = inputStream.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of(
                Arguments.of("customer", "Taabannn", "61378Tns", "tabansoleymani@yahoo.com", null),
                Arguments.of("manager", "Maryam", "Maryam123", "maryam@example.com", null),
                Arguments.of("expert", "Aminn", "1259Amin", "aminAmini@example.com", image)
        );
    }

    @ParameterizedTest
    @MethodSource("generateUsers")
    public void saveNewUserTest(String role, String username, String password, String email, byte[] image) {
        User savedUser = userService.saveNewUser(role, username, password, email, image);
        Assertions.assertNotNull(savedUser);
    }
    /*
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
        userService = context.getBean(UserServiceImpl.class);
        userService.getListOfCustomersToManager(username, password);
    }

    @ParameterizedTest
    @MethodSource("generateManager")
    public void getListOfExpertsToManagerTest_whenGetListOfExpertsToManagerCalls_withExistedManager(String username, String password) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        userService = context.getBean(UserServiceImpl.class);
        userService.getListOfExpertsToManager(username, password);
    }*/
}

