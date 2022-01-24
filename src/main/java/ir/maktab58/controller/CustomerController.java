package ir.maktab58.controller;

import ir.maktab58.config.LastViewInterceptor;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.impl.CustomerServiceImpl;
import ir.maktab58.service.mapper.interfaces.CustomerMapper;
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
        model.put("customer", new ExpertDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("customerLogin", model);
    }

    @PostMapping("/customerLogin")
    public String loginCustomer(@ModelAttribute("customer") @Validated(OnLogin.class) CustomerDto customerDto,
                              Model model) {
        Customer customer = customerService.customerLogin(customerDto);
        CustomerDto toCustomerDto = customerMapper.toCustomerDto(customer);
        //model.addAttribute("pcDto", new ProductCategoryDto());
        return "productList";
    }
}
