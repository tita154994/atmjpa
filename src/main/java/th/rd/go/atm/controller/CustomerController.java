package th.rd.go.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.rd.go.atm.model.Customer;
import th.rd.go.atm.service.CustomerService;

import java.util.ArrayList;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //ArrayList<Customer> customers = new ArrayList<>();

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    //@RequestMapping("/customer")
    public String getCustomerPage(Model model) {
//        ArrayList<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(1,"Peter",1234));
//        customers.add(new Customer(2,"Nancy",2345));
//        customers.add(new Customer(3,"Rick",3456));
        //model.addAttribute("allCustomers", customers);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer";
    }

    @PostMapping("/search")
    public String searchCustomerPage(@ModelAttribute Customer customer, Model model) {
        //System.out.println("Customer Id >>>" + customer.getId());
        Customer record = customerService.findCustomer(customer.getId());
        //System.out.println("Find Customer >>>"+ record);
        model.addAttribute("allCustomers", record);
        //model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:/customer";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        //customers.add(customer);
        //model.addAttribute("allCustomers", customers);
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }
    @DeleteMapping
    public String deleteCustomer(@ModelAttribute Customer customer, Model model){
        customerService.deleteCustomer(customer.getId());
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }

    @PutMapping
    public String updateCustomer(@ModelAttribute Customer customer,Model model) {
        Customer record = customerService.findCustomer(customer.getId());
        //record.setName(customer.getName());
        record.setName("TiTaEdit");
        customerService.updateCustomer(record);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";

    }



}
