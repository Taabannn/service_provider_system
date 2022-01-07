package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Expert;
import ir.maktab58.exceptions.ServiceSysException;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Taban Soleymani
 */
public class ExpertDaoTest {
    ExpertDao expertDao = mock(ExpertDao.class);//new ExpertDao();
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeAll
    public static void init() {
        System.out.println("In ExpertDaoTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In ExpertDaoTest after...");
    }

    static Stream<Arguments> generateExpert() {
        return Stream.of(
                Arguments.of("Taabannn", "61378Tns", "tabansoleymani@yahoo.com"),
                Arguments.of("Maryam", "Maryam123", "maryam@example.com"),
                Arguments.of("Aminn", "12Amin", "aminAmini@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExpert")
    public void findExpertByUserAndPassTest_whenFindExpertByUserAndPassCalls_withExistedExpert(String username, String password, String email) {
        File file = new File("expert.png");
        byte[] bFile = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(bFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Expert expert = Expert.builder()
                .withUsername(username)
                .withPassword(password)
                .withEmail(email)
                .withFirstAccess(new Date())
                .withImage(bFile).build();
        expertDao.save(expert);
        expertDao.findExpertByUserAndPass(username, password);
        verify(expertDao).findExpertByUserAndPass(username, password);
    }

    @ParameterizedTest
    @MethodSource("generateExpert")
    public void findExpertByUserAndPassTest_whenFindExpertByUserAndPassCalls_withNotExistedExpert(String username, String password) {
        exceptionRule.expect(ServiceSysException.class);
        exceptionRule.expectMessage("No expert with entered username and password was found.");
        expertDao.findExpertByUserAndPass(username, password);
        verify(expertDao).findExpertByUserAndPass(username, password);
    }
}
