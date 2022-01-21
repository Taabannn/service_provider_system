package ir.maktab58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Taban Soleymani
 */
@Controller
public class ManagerController {
    @RequestMapping("/managerLogin")
    public ModelAndView getLogoutView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("managerLogin");
        return modelAndView;
    }
}
