package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.users.Expert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
public class SubServiceServiceTest {
    private SubServiceService subServiceService;

    @BeforeAll
    public static void init() {
        System.out.println("In subServiceServiceTest init...");
    }

    @BeforeEach
    public void beforeEach() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        subServiceService = context.getBean(SubServiceService.class);
    }

    @AfterAll
    public static void after() {
        System.out.println("In subServiceServiceTest after...");
    }

    static Stream<Arguments> generateExpert() {
        return Stream.of(
                Arguments.of("Aminn", "12Amin", "aminAmini@example.com", "decoration", "repairment", 250000)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExpert")
    public void addASubServiceToExpertTest_whenAddASubServiceToExpertCalls_withExistedExpert(String username, String password, String email, String description, String field, long basePrice) {
        subServiceService.addASubServiceToExpert(username, password, description, field, basePrice);
    }
}
