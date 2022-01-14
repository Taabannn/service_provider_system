package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.Address;
import ir.maktab58.exceptions.ServiceSysException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
public class AddressServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AddressServiceImpl addressService = context.getBean(AddressServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In AddressServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In AddressServiceTest after...");
    }

    static Stream<Arguments> generateAnAddress() {
        return Stream.of(
                Arguments.of("Tehran", "Tehran", "Mirdamad", "5th", "1919191919"),
                Arguments.of("Isfahan", "Isfahan", "Enghrlab", "2nd", "1717171771"),
                Arguments.of("Tehran", "Tehran", "Zafar", "4th", "1234554321")
        );
    }

    @ParameterizedTest
    @MethodSource("generateAnAddress")
    public void saveAnNewAddressTestWithNotExistedAddress(String county, String city, String street, String alley, String postalCode) {
        Address address = addressService.saveAnAddress(alley, street, city, county, postalCode);
        Assertions.assertNotNull(address);
    }

    static Stream<Arguments> generateExistedAddress() {
        return Stream.of(
                Arguments.of("Tehran", "Tehran", "Mirdamad", "5th", "1919191919"),
                Arguments.of("Isfahan", "Isfahan", "Enghrlab", "2nd", "1717171771"),
                Arguments.of("Tehran", "Tehran", "Zafar", "4th", "1234554321")
        );
    }

    @ParameterizedTest
    @MethodSource("generateExistedAddress")
    public void saveAnNewAddressTestWithExistedAddress(String county, String city, String street, String alley, String postalCode) {
        Assertions.assertThrows(ServiceSysException.class, () -> addressService.saveAnAddress(alley, street, city, county, postalCode), "The entered Address has already saved in address table.");
    }
}
