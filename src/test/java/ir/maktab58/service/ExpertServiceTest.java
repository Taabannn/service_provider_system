package ir.maktab58.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Taban Soleymani
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpertServiceTest {
    /*ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final ExpertServiceImpl expertService = context.getBean(ExpertServiceImpl.class);
    private final SubServiceServiceImpl subServiceService = context.getBean(SubServiceServiceImpl.class);

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
                Arguments.of("AmirA", "AmirAimiri11", List.of("order a complete meal")),
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
                Arguments.of("AmirA", "AmirAimiri11", List.of("demanding for a doctor")),
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
                Arguments.of("demanding for a doctor", "AmirA", "AmirAimiri11")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExpertAndOccupiedSubService")
    @Order(7)
    public void checkExpertHasSubServiceTest(String subServiceDescription, String username, String password) {
        Expert expert = expertService.expertLogin(username, password);
        try {
            SubService subService = subServiceService.findSubServiceByDescription(subServiceDescription).get();
            expertService.checkIfExpertHasSubService(subService, expert);
        } catch (NullPointerException e) {
            Assertions.fail();
        }
    }

    @ParameterizedTest
    @MethodSource("generateExpertAndOccupiedSubService")
    @Order(8)
    public void removeExpertsBySubService(String subServiceDescription, String username, String password) {
        Expert expert = expertService.expertLogin(username, password);
        expertService.removeASubServiceFromExpertsServiceList(expert, subServiceDescription);
    }*/
}
