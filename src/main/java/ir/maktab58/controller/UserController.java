package ir.maktab58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Taban Soleymani
 */
@Controller
public class UserController {
    @RequestMapping("/signUp")
    public ModelAndView getLogoutView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customerSignUp");
        return modelAndView;
    }
}
