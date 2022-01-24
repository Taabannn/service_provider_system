package ir.maktab58.controller;

import ir.maktab58.config.LastViewInterceptor;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.dto.users.ManagerDto;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.impl.ExpertServiceImpl;
import ir.maktab58.service.validation.OnLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Taban Soleymani
 */
@Controller
public class ExpertController {
    @Autowired
    private ExpertServiceImpl expertService;

    @GetMapping("/expertLogin")
    public ModelAndView getExpertLoginView() {
        return new ModelAndView("expertLogin","expert", new ExpertDto());
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = ServiceSysException.class)
    public ModelAndView loginExceptionHandler(ServiceSysException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("expert", new ExpertDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("expertLogin", model);
    }

    @PostMapping("/managerLogin")
    public String loginExpert(@ModelAttribute("expert") @Validated(OnLogin.class) ExpertDto expertDto,
                                Model model) {
        expertService.expertLogin(expertDto);
        //model.addAttribute("pcDto", new ProductCategoryDto());
        return "productList";
    }
}
