package ir.maktab58.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Taban Soleymani
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubServiceServiceTest {
   /* ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final SubServiceServiceImpl subServiceService = context.getBean(SubServiceServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In subServiceServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In subServiceServiceTest after...");
    }

    static Stream<Arguments> generateSubService() {
        return Stream.of(
                Arguments.of("Home Appliances", "repairment", 123000),
                Arguments.of("Vehicles", "changing oil", 50000),
                Arguments.of("Health", "demanding for a doctor", 50000),
                Arguments.of("Food", "order a complete meal", 117000)
        );
    }

    @ParameterizedTest
    @MethodSource("generateSubService")
    @Order(1)
    public void saveASubServiceTest(String field, String subDescription, long basePrice) {
        SubService subService = subServiceService.saveASubService(field, subDescription, basePrice);
        Assertions.assertNotNull(subService);
    }

    static Stream<Arguments> generateExistedSubService() {
        return Stream.of(
                Arguments.of("Home Appliances", "repairment", 123000),
                Arguments.of("Vehicles", "changing oil", 50000),
                Arguments.of("Health", "demanding for a doctor", 50000),
                Arguments.of("Food", "order a complete meal", 117000)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedSubService")
    @Order(2)
    public void saveASubServiceTestWithExistedSubService(String field, String subDescription, long basePrice) {
        Assertions.assertThrows(ServiceSysException.class, () -> subServiceService.saveASubService(field, subDescription, basePrice));
    }*/
}
