package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.stream.Stream;

/**
 * @author Taban Soleymani
 */
public class OrderServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
    AddressServiceImpl addressService = context.getBean(AddressServiceImpl.class);
    CustomerServiceImpl customerService = context.getBean(CustomerServiceImpl.class);
    SubServiceServiceImpl subServiceService = context.getBean(SubServiceServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In OrderServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In OrderServiceTest after...");
    }

    static Stream<Arguments> generateOrders() {
        return Stream.of(
                Arguments.of("Taabannn", "1919191919", "repairment", "I want to get someone to repair my house's pipes.", 300000, new Date(122, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("generateOrders")
    public void saveAnNewAddressTestWithNotExistedAddress(String username, String postalCode, String subServiceDescription, String details, long offeredPriceByCustomer, Date requestedDate) {
        try {
            Address address = addressService.findAddressByPostalCode(postalCode).get();
            Customer customer = customerService.findVerifiedCustomerByUsername(username).get();
            SubService subService = subServiceService.findSubServiceByDescription(subServiceDescription).get();
            Order order = orderService.saveNewOrder(customer, address, subService, details, offeredPriceByCustomer, requestedDate);
            Assertions.assertNotNull(order);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
