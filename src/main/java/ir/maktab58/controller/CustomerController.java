package ir.maktab58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Taban Soleymani
 */
@Controller
public class CustomerController {
    @RequestMapping("/customerLogin")
    public ModelAndView getLogoutView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customerLogin");
        return modelAndView;
    }
}
