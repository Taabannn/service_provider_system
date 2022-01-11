package ir.maktab58.data.dao;

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

import java.util.Date;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Taban Soleymani
 */
public class ManagerDaoTest {
    /*ManagerDao managerDao = new ManagerDao();//mock(ManagerDao.class);
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeAll
    public static void init() {
        System.out.println("In ManagerDaoTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In ManagerDaoTest after...");
    }

    static Stream<Arguments> generateManager() {
        return Stream.of(
                *//*Arguments.of("Taabannn", "61378Tns", "tabansoleymani@yahoo.com"),*//*
                Arguments.of("Maryam", "Maryam123", "maryam@example.com")*//*,
                Arguments.of("Aminn", "12Amin", "aminAmini@example.com")*//*
        );
    }

    @ParameterizedTest
    @MethodSource("generateManager")
    public void findManagerByUserAndPassTest_whenFindManagerByUserAndPassCalls_withExistedManager(String username, String password, String email) {
        Manager manager = Manager.builder()
                .withUsername(username)
                .withPassword(password)
                .withEmail(email).withFirstAccess(new Date()).build();
        managerDao.save(manager);
        managerDao.findManagerByUserAndPass(username, password);
        //verify(managerDao).findManagerByUserAndPass(username, password);
    }

    static Stream<Arguments> generateInvalidManager() {
        return Stream.of(
                Arguments.of("Taaba", "61378Tns", "tabansoleymani@yahoo.com"),
                Arguments.of("Maryam", "Maryam3", "maryam@example.com")
        );
    }

    @ParameterizedTest
    @MethodSource("generateInvalidManager")
    public void findManagerByUserAndPassTest_whenFindManagerByUserAndPassCalls_withNotExistedManager(String username, String password) {
        //exceptionRule.expect(ServiceSysException.class);
        //exceptionRule.expectMessage("No manager with entered username and password was found.");
        //managerDao.findManagerByUserAndPass(username, password);
        Assertions.assertThrows(ServiceSysException.class, () -> managerDao.findManagerByUserAndPass(username, password), "No manager with entered username and password was found.");
        //verify(managerDao).findManagerByUserAndPass(username, password);
    }*/
}
