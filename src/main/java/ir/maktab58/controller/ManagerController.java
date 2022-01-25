package ir.maktab58.controller;

import ir.maktab58.config.LastViewInterceptor;
import ir.maktab58.data.entities.users.Manager;
import ir.maktab58.dto.users.ManagerDto;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.impl.ManagerServiceImpl;
import ir.maktab58.service.interfaces.ManagerService;
import ir.maktab58.service.mapper.interfaces.ManagerMapper;
import ir.maktab58.service.validation.OnLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Taban Soleymani
 */
@Controller
public class ManagerController {
    @Autowired
    private ManagerServiceImpl managerService;

    @Autowired
    private ManagerMapper managerMapper;

    @GetMapping("/managerLogin")
    public ModelAndView getManagerLoginView() {
        return new ModelAndView("managerLogin","manager", new ManagerDto());
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = ServiceSysException.class)
    public ModelAndView loginExceptionHandler(ServiceSysException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("manager", new ManagerDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("managerLogin", model);
    }

    @PostMapping("/managerLogin")
    public String loginManager(@ModelAttribute("manager") @Validated(OnLogin.class) ManagerDto managerDto, BindingResult bindingResult,
                                Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "customerLogin";
        }

        Manager manager = managerService.managerLogin(managerDto);
        ManagerDto toManagerDto = managerMapper.toManagerDto(manager);

        model.addAttribute("manager", toManagerDto);
        model.addAttribute("message", "Welcome " + toManagerDto.getFirstName() + " " + toManagerDto.getLastName() +
                "!<br>We are happy to see you again!");
        httpSession.setAttribute("manager", toManagerDto);
        return "managerDashboard";
    }

    @GetMapping("/managerLogout")
    public ModelAndView getCustomerLogoutView(HttpSession httpSession) {
        httpSession.removeAttribute("manager");
        return new ModelAndView("logout");
    }
}
