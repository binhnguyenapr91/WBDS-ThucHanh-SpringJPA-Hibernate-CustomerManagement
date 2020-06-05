package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import org.springframework.data.domain.Pageable;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create-customer")
    ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    ModelAndView createCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message","Create new customer successfully");
        return modelAndView;
    }

    @GetMapping("/customers")
    ModelAndView listingCustomer(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("customer/listing");
        Page<Customer> customers = customerService.findAll(pageable);
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/update-customer/{id}")
    ModelAndView showUpdateForm(@PathVariable Long id){
        Customer customer = customerService.findOne(id);
        if(customer!=null){
            ModelAndView modelAndView = new ModelAndView("customer/update");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/update-customer")
    ModelAndView updateCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/update");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","Update customer successfully");
        return  modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = new Customer();
        customer = customerService.findOne(id);
        if(customer!=null){
            ModelAndView modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("404");
            return modelAndView;
        }

    }

    @PostMapping("/delete-customer")
    ModelAndView deleteCustomer(@ModelAttribute Customer customer){
        customerService.delete(customer.getId());
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","Delete customer successfully");
        return modelAndView;
    }
}
