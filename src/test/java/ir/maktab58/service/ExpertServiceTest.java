package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.exceptions.ServiceSysException;
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
public class ExpertServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final ExpertServiceImpl expertService = context.getBean(ExpertServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In ExpertServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In ExpertServiceTest after...");
    }

    static Stream<Arguments> generateExistedExpert() {
        return Stream.of(
                Arguments.of("Aminn", "1259Amin"),
                Arguments.of("AmirA", "AmirAimiri11"),
                Arguments.of("Mahnaz", "Ma12345678")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedExpert")
    @Order(1)
    public void expertLoginTestWithExistedExpert(String username, String password) {
        Expert expert = expertService.expertLogin(username, password);
        Assertions.assertNotNull(expert);
    }

    static Stream<Arguments> generateExistedExpertWithNewPassword() {
        return Stream.of(
                Arguments.of("Mahnaz", "Ma12345678", "Mahnaz1366")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedExpertWithNewPassword")
    @Order(2)
    public void expertChangePasswordTestWithExistedExpert(String username, String password, String newPassword) {
        Expert expert = expertService.expertLogin(username, password);
        expertService.changeExpertPassword(expert, newPassword);
        expert = expertService.expertLogin(username, newPassword);
        Assertions.assertEquals(newPassword, expert.getPassword());
    }

    static Stream<Arguments> generateExistedExpertWithSubService() {
        return Stream.of(
                Arguments.of("Aminn", "1259Amin", List.of("repairment")),
                Arguments.of("AmirA", "AmirAimiri11", List.of("repairment", "changing oil")),
                Arguments.of("Mahnaz", "Mahnaz1366", List.of("demanding for a doctor"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedExpertWithSubService")
    @Order(3)
    public void addNewSubServiceToExpertsSubServiceList(String username, String password, List<String> subServiceDes) {
        expertService.expertLogin(username, password);
        Expert expert = expertService.expertLogin(username, password);
        for (String subServiceDescription : subServiceDes) {
            expertService.addNewSubServiceToExpertsSubServiceList(expert, subServiceDescription);
        }
    }

    static Stream<Arguments> generateExistedExpertWithAddedSubServices() {
        return Stream.of(
                Arguments.of("Aminn", "1259Amin", List.of("repairment")),
                Arguments.of("AmirA", "AmirAimiri11", List.of("repairment", "changing oil")),
                Arguments.of("Mahnaz", "Mahnaz1366", List.of("demanding for a doctor"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedExpertWithAddedSubServices")
    @Order(4)
    public void addExistedSubServiceToExpertsSubServiceList(String username, String password, List<String> subServiceDes) {
        expertService.expertLogin(username, password);
        Expert expert = expertService.expertLogin(username, password);
        for (String subServiceDescription : subServiceDes) {
            Assertions.assertThrows(ServiceSysException.class, () -> expertService.addNewSubServiceToExpertsSubServiceList(expert, subServiceDescription), "SubService " + subServiceDescription + " has already added to your services list.");
        }
    }

    static Stream<Arguments> generateExistedUserStatus() {
        return Stream.of(
                Arguments.of(UserStatus.VERIFIED),
                Arguments.of(UserStatus.NOT_VERIFIED),
                Arguments.of(UserStatus.NEW)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedUserStatus")
    @Order(5)
    public void getAllExpertsByUserStatus(UserStatus userStatus) {
        List<Expert> allExpertByExpertStatus = expertService.getAllExpertByExpertStatus(userStatus);
        Assertions.assertNotNull(allExpertByExpertStatus);
    }

    static Stream<Arguments> generateOccupiedSubServices() {
        return Stream.of(
                Arguments.of("repairment"),
                Arguments.of("changing oil"),
                Arguments.of("demanding for a doctor")
        );
    }

    @ParameterizedTest
    @MethodSource("generateOccupiedSubServices")
    @Order(6)
    public void getExpertsBySubService(String subServiceDescription) {
        List<Expert> listOfExpertsBySubService = expertService.getListOfExpertsBySubService(subServiceDescription);
        Assertions.assertNotNull(listOfExpertsBySubService);
    }

    static Stream<Arguments> generateExpertAndOccupiedSubService() {
        return Stream.of(
                Arguments.of("repairment", "AmirA", "AmirAimiri11"),
                Arguments.of("changing oil", "AmirA", "AmirAimiri11")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExpertAndOccupiedSubService")
    @Order(7)
    public void removeExpertsBySubService(String subServiceDescription, String username, String password) {
        Expert expert = expertService.expertLogin(username, password);
        expertService.removeASubServiceFromExpertsServiceList(expert, subServiceDescription);
    }
}
