package ir.maktab58.service;

import ir.maktab58.exceptions.ServiceSysException;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Taban Soleymani
 */
public class UserServiceTest {

    UserService userServiceMock = mock(UserService.class);
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
        userServiceMock.validateEmailAndUserAndPass(username, password, email);
        verify(userServiceMock).validateEmailAndUserAndPass(username, password, email);
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
        userServiceMock.validateEmailAndUserAndPass(username, password, email);
        verify(userServiceMock).validateEmailAndUserAndPass(username, password, email);
    }
}
