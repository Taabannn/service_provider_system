package ir.maktab58;

import ir.maktab58.config.SpringConfig;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.saveManager(Manager.builder().withEmail("taban")
                .withUsername("kara").withPassword("89").withFirstAccess(new Date()).build());
    }
}
