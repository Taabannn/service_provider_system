package ir.maktab58.controller;

import ir.maktab58.config.LastViewInterceptor;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.dto.TransactionDto;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.exceptions.DuplicateUserException;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.impl.CustomerServiceImpl;
import ir.maktab58.service.mapper.interfaces.CustomerMapper;
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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Taban Soleymani
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/customerLogin")
    public ModelAndView getCustomerLoginView() {
        return new ModelAndView("customerLogin","customer", new CustomerDto());
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = ServiceSysException.class)
    public ModelAndView loginExceptionHandler(ServiceSysException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", new CustomerDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("customerLogin", model);
    }

    @PostMapping("/customerLogin")
    public String loginCustomer(@ModelAttribute("customer") @Validated(OnLogin.class) CustomerDto customerDto, BindingResult bindingResult,
                                Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "customerLogin";
        }

        Customer customer = customerService.customerLogin(customerDto);
        CustomerDto toCustomerDto = customerMapper.toCustomerDto(customer);
        model.addAttribute("customer", toCustomerDto);
        model.addAttribute("message", "Welcome " + toCustomerDto.getFirstName() + " " + toCustomerDto.getLastName() +
                "!<br>We are happy to see you again!");
        httpSession.setAttribute("customer", toCustomerDto);
        return "customerDashboard";
    }

    @GetMapping("/customerSignUp")
    public ModelAndView getCustomerSignUpView() {
        return new ModelAndView("customerSignUp","customer", new CustomerDto());
    }

    @PostMapping("/customerSignUp")
    public String signUpCustomer(@ModelAttribute("customer") @Validated(OnRegister.class) CustomerDto customerDto, BindingResult bindingResult,
                                 Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "customerSignUp";
        }

        Customer customer = customerService.customerSignUp(customerDto);
        CustomerDto toCustomerDto = customerMapper.toCustomerDto(customer);
        model.addAttribute("customer", toCustomerDto);
        model.addAttribute("message", "Welcome " + toCustomerDto.getFirstName() + " " + toCustomerDto.getLastName() +
                "!<br>Your account has been created successfully!");
        httpSession.setAttribute("customer", toCustomerDto);
        return "customerDashboard";
    }

    @ExceptionHandler(value = DuplicateUserException.class)
    public ModelAndView signUpCustomerExceptionHandler(DuplicateUserException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", new CustomerDto());
        model.put("signupError", ex.getMessage() + "You are redirected to customerSignUp page.");
        return new ModelAndView("customerSignUp", model);
    }

    @GetMapping("/customerPassEdition")
    public ModelAndView getCustomerPassEditionView(HttpSession httpSession) {
        CustomerDto customer = (CustomerDto) httpSession.getAttribute("customer");
        return new ModelAndView("customerPassEdition", "customer", customer);
    }

    @PostMapping("/customerPassEdition")
    public String editCustomerPass(@RequestParam(value = "password") String password,
                                   @RequestParam(value = "newPassword") String newPass,
                                   Model model, HttpSession session) {
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        customer.setPassword(password);
        customerService.changeCustomerPassword(customer, newPass);
        customer.setPassword(newPass);
        Customer modifiedCustomer = customerService.customerLogin(customer);
        CustomerDto toCustomerDto = customerMapper.toCustomerDto(modifiedCustomer);
        model.addAttribute("customer", toCustomerDto);
        model.addAttribute("message", customer.getFirstName()+ "!" +
                "<br>Your password has been updated successfully.");
        session.setAttribute("customer", toCustomerDto);
        return "customerDashboard";
    }

    /*@ExceptionHandler(value = SQLException.class)
    public ModelAndView editPassExceptionHandler(SQLException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", new CustomerDto());
        model.put("wrongPassErrors", ex.getMessage() + "You are redirected to customerLogin page.");
        return new ModelAndView("customerLogin", model);
    }*/

    @GetMapping("/depositWallet")
    public ModelAndView getDepositWalletView(HttpSession httpSession) {
        CustomerDto customer = (CustomerDto) httpSession.getAttribute("customer");
        return new ModelAndView("depositWallet", "customer", customer);
    }

    @PostMapping("/depositWallet")
    public String depositWallet(@RequestParam(value = "depositAmount") String amount,
                                   Model model, HttpSession session) {
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        long depositAmount = Long.parseLong(amount);
        TransactionDto transactionDto = customerService.depositCustomerBalance(customer, depositAmount);
        Customer modifiedCustomer = customerService.customerLogin(customer);
        CustomerDto toCustomerDto = customerMapper.toCustomerDto(modifiedCustomer);
        model.addAttribute("customer", toCustomerDto);
        model.addAttribute("message", customer.getFirstName()+ "!" +
                "<br>Your balance is " + toCustomerDto.getWallet().getWallet() + " now."
                + "<br> Successful Transaction with tracking code : " + transactionDto.getTrackingCode());
        session.setAttribute("customer", toCustomerDto);
        return "customerDashboard";
    }

    @GetMapping("/logout")
    public ModelAndView getCustomerLogoutView(HttpSession httpSession) {
        httpSession.removeAttribute("customer");
        return new ModelAndView("logout");
    }
}
