package ir.maktab58.service;

/**
 * @author Taban Soleymani
 */
public class OfferServiceTest {
    /*ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
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
    }*/
}
