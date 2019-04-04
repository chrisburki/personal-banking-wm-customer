package customer.api;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import customer.model.Customer;
import customer.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/customer?firstName=Aniel&lastName=Burki&birthDate=1974-04-08

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {


    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public Customer createCustomer(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                             @RequestParam("birthDate") LocalDate birthDate,
                                   @RequestParam(value = "civilStatus",defaultValue = "") String civilStatus,
                                   @RequestParam(value = "email",defaultValue = "") String email) {
        return new Customer(counter.incrementAndGet(),firstName,lastName,birthDate,civilStatus,email);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") Long id) {
        final String lastName = "Burki";
        final String firstName = "Christoph";
        final LocalDate birthDate = java.time.LocalDate.now();
        final String civilStatus = null;
        final String email = "christoph@burki.ch";

        return customerService.findById(id);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public Customer findCustomer(@RequestParam("key") String key) {
        return customerService.findByKey(key);
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public Customer findCustomer2(@RequestParam("search") String search) {
        return new Customer(counter.incrementAndGet(),"AAA","BBBB",null,null,null);
    }

    @RequestMapping(value="/ready", method = RequestMethod.GET)
    public Customer readyCustomer() {
        return new Customer(counter.incrementAndGet(),"Ready","Ready",null,null,null);
    }

}