package ir.maktab58.controller;

import ir.maktab58.config.LastViewInterceptor;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.dto.users.ManagerDto;
import ir.maktab58.exceptions.DuplicateUserException;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.impl.ExpertServiceImpl;
import ir.maktab58.service.mapper.Impl.ExpertSubServiceMapperImpl;
import ir.maktab58.service.mapper.interfaces.ExpertMapper;
import ir.maktab58.service.validation.OnLogin;
import ir.maktab58.service.validation.OnRegister;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Taban Soleymani
 */
@Controller
public class ExpertController {
    @Autowired
    private ExpertServiceImpl expertService;

    @Autowired
    private ExpertMapper expertMapper;

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

    @PostMapping("/expertLogin")
    public String loginExpert(@ModelAttribute("expert") @Validated(OnLogin.class) ExpertDto expertDto, BindingResult bindingResult,
                                Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "expertLogin";
        }
        Expert expert = expertService.expertLogin(expertDto);
        ExpertDto toExpertDto = expertMapper.toExpertDto(expert);

        model.addAttribute("expert", toExpertDto);
        model.addAttribute("message", "Welcome " + toExpertDto.getFirstName() + " " + toExpertDto.getLastName() +
                "!<br>Your account has been created successfully!");
        List<SubServiceDto> serviceDtoList = expertService.getSubServiceListByExpert(expert);
        model.addAttribute("services", serviceDtoList);
        httpSession.setAttribute("expert", toExpertDto);
        return "expertDashboard";
    }

    @GetMapping("/expertSignUp")
    public ModelAndView getExpertSignUpView() {
        return new ModelAndView("expertSignUp","expert", new ExpertDto());
    }

    @PostMapping("/expertSignUp")
    public String signUpExpert(@ModelAttribute("expert") @Validated(OnRegister.class) ExpertDto expertDto, BindingResult bindingResult,
                                 Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "expertSignUp";
        }

        Expert expert = expertService.expertSignUp(expertDto);
        ExpertDto toExpertDto = expertMapper.toExpertDto(expert);
        List<SubServiceDto> serviceDtoList = expertService.getSubServiceListByExpert(expert);
        model.addAttribute("expert", toExpertDto);
        model.addAttribute("message", "Welcome " + toExpertDto.getFirstName() + " " + toExpertDto.getLastName() +
                "!<br>Your account has been created successfully!");
        model.addAttribute("services", serviceDtoList);
        httpSession.setAttribute("expert", toExpertDto);
        return "expertDashboard";
    }

    @ExceptionHandler(value = DuplicateUserException.class)
    public ModelAndView signUpExpertExceptionHandler(DuplicateUserException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("expert", new ExpertDto());
        model.put("signupError", ex.getMessage() + "You are redirected to expertSignUp page.");
        return new ModelAndView("expertSignUp", model);
    }

    @GetMapping("/expertPassEdition")
    public ModelAndView getCustomerPassEditionView(HttpSession httpSession) {
        ExpertDto expert = (ExpertDto) httpSession.getAttribute("expert");
        return new ModelAndView("expertPassEdition", "expert", expert);
    }

    @PostMapping("/expertPassEdition")
    public String editCustomerPass(@RequestParam(value = "password") String password,
                                   @RequestParam(value = "newPassword") String newPass,
                                   Model model, HttpSession session) {
        ExpertDto expert = (ExpertDto) session.getAttribute("expert");
        expert.setPassword(password);
        expertService.changeExpertPassword(expert, newPass);
        expert.setPassword(newPass);
        Expert modifiedExpert = expertService.expertLogin(expert);
        ExpertDto toExpertDto = expertMapper.toExpertDto(modifiedExpert);
        model.addAttribute("expert", toExpertDto);
        model.addAttribute("message", expert.getFirstName()+ "!" +
                "<br>Your password has been updated successfully.");
        session.setAttribute("expert", toExpertDto);
        return "expertDashboard";
    }

    @GetMapping("/expertLogout")
    public ModelAndView getCustomerLogoutView(HttpSession httpSession) {
        httpSession.removeAttribute("expert");
        return new ModelAndView("logout");
    }
}
