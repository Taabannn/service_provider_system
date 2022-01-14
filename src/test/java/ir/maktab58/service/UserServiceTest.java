package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.users.User;
import ir.maktab58.exceptions.ServiceSysException;
import org.junit.jupiter.api.*;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        try (InputStream inputStream = new FileInputStream(file)) {
            int bytesRead = inputStream.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of(
                Arguments.of("customer", "Taabannn", "61378Tns", "tabansoleymani@yahoo.com", null),
                Arguments.of("manager", "Maryam", "Maryam123", "maryam@example.com", null),
                Arguments.of("expert", "Aminn", "1259Amin", "aminAmini@example.com", image),
                Arguments.of("expert", "AmirA", "AmirAimiri11", "aamiri@example.com", image),
                Arguments.of("expert", "Mahnaz", "Ma12345678", "mahnaz@example.com", image),
                Arguments.of("customer", "Farzad", "6Farzadi7", "farzad@yahoo.com", null)
        );
    }

    @ParameterizedTest
    @MethodSource("generateUsers")
    @Order(1)
    public void saveNewUserTest(String role, String username, String password, String email, byte[] image) {
        User savedUser = userService.saveNewUser(role, username, password, email, image);
        Assertions.assertNotNull(savedUser);
    }

    static Stream<Arguments> generateExistedUsers() {
        File file = new File("C:\\Users\\Taban\\Desktop\\maktab\\service_provider_system\\src\\main\\resources\\expert.png");
        byte[] image = new byte[(int) file.length()];
        try (InputStream inputStream = new FileInputStream(file)) {
            int bytesRead = inputStream.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of(
                Arguments.of("customer", "Taabannn", "61378Tns", "taban@yahoo.com", "Sorry! username Taabannn is already taken", null),
                Arguments.of("customer", "Taban", "61378Tns", "tabansoleymani@yahoo.com", "Sorry! email tabansoleymani@yahoo.com is already taken", null),
                Arguments.of("expert", "Aminn", "1259Amin", "amin@example.com", "Sorry! username Aminn is already taken", image)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedUsers")
    @Order(2)
    public void saveNewUserTestWithExistedUser(String role, String username, String password, String email, String message, byte[] image) {
        Assertions.assertThrows(ServiceSysException.class, () -> userService.saveNewUser(role, username, password, email, image), message);
    }

    static Stream<Arguments> generateExistedUsernameAndPasswords() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns"),
                Arguments.of("Maryam", "Maryam123"),
                Arguments.of("Aminn", "1259Amin")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedUsernameAndPasswords")
    @Order(3)
    public void userLoginTestWithExistedUser(String username, String password) {
        User user = userService.login(username, password);
        Assertions.assertNotNull(user);
    }

    static Stream<Arguments> generateNotExistedUsernameAndPasswords() {
        return Stream.of(
                Arguments.of("TTTTTT", "122RTrtt"),
                Arguments.of("Maryam", "Maryam1234"),
                Arguments.of("Amin", "1259Amin")
        );
    }

    @ParameterizedTest
    @MethodSource("generateNotExistedUsernameAndPasswords")
    public void userLoginTestWithNotExistedUser(String username, String password) {
        Assertions.assertThrows(ServiceSysException.class, () -> userService.login(username, password),
                "Invalid username or pass.\n" +
                        "Please try again!");
    }
}

