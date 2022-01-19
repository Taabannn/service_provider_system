package ir.maktab58.service;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.entities.Offer;
import ir.maktab58.data.entities.Order;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.service.impl.ExpertServiceImpl;
import ir.maktab58.service.impl.OfferServiceImpl;
import ir.maktab58.service.impl.OrderServiceImpl;
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
public class OfferServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    OfferServiceImpl offerService = context.getBean(OfferServiceImpl.class);
    OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
    ExpertServiceImpl expertService = context.getBean(ExpertServiceImpl.class);

    @BeforeAll
    public static void init() {
        System.out.println("In OfferServiceTest init...");
    }

    @AfterAll
    public static void after() {
        System.out.println("In OfferServiceTest after...");
    }

    static Stream<Arguments> generateOffers() {
        return Stream.of(
                Arguments.of("AmirA", 1, 300000, 2, new Date(122, 2, 3)),
                Arguments.of("Aminn", 1, 500000, 2, new Date(122, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("generateOffers")
    public void saveNewOfferTest(String username, int orderId, long offeredPrice, int numOfEstimatedHours, Date timeOfBeginning) {
        try {
            Expert expert = expertService.findVerifiedExpertByUsername(username).get();
            Order order = orderService.findOrderByOrderId(orderId).get();
            Offer offer = offerService.saveNewOffer(order, expert, offeredPrice, numOfEstimatedHours, timeOfBeginning);
            Assertions.assertNotNull(offer);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
