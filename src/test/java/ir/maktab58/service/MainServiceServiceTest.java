package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.services.MainService;
import ir.maktab58.exceptions.ServiceSysException;
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
public class MainServiceServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final MainServiceServiceImpl mainServiceServiceImpl = context.getBean(MainServiceServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In subServiceServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In subServiceServiceTest after...");
    }

    static Stream<Arguments> generateMainService() {
        return Stream.of(
                Arguments.of("Decoration", "Home Appliances", "Vehicles")
        );
    }

    @ParameterizedTest
    @MethodSource("generateMainService")
    @Order(1)
    public void saveNewMainServiceTest(String firstField, String secondField, String thirdField) {
        MainService firstMainService = mainServiceServiceImpl.saveNewMainService(firstField);
        Assertions.assertNotNull(firstMainService);
        MainService secondMainService = mainServiceServiceImpl.saveNewMainService(secondField);
        Assertions.assertNotNull(secondMainService);
        MainService thirdMainService = mainServiceServiceImpl.saveNewMainService(thirdField);
        Assertions.assertNotNull(thirdMainService);
    }

    static Stream<Arguments> generateExistedMainService() {
        return Stream.of(
                Arguments.of("Decoration", "MainService in field : " + "Decoration" + " is already existed.\n" +
                        "You can add whatever subService that you want."),
                Arguments.of("Home Appliances", "MainService in field : " + "Home Appliances" + " is already existed.\n" +
                        "You can add whatever subService that you want."),
                Arguments.of("Vehicles", "MainService in field : " + "Vehicles" + " is already existed.\n" +
                        "You can add whatever subService that you want.")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedMainService")
    @Order(2)
    public void saveNewMainServiceTestWithExistedMainService(String field, String message) {
        Assertions.assertThrows(ServiceSysException.class, () -> mainServiceServiceImpl.saveNewMainService(field), message);
    }
}
