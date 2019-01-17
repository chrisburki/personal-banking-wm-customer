package customer.model;

import customer.persistence.CustomerPO;
import customer.persistence.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final String firstName1 = "Aniél";
    private final String firstName2 = "Christoph";
    private final String lastName = "Burki";
    private final LocalDate birthDate = java.time.LocalDate.now();
    private final String civilStatus = "ledig";
    private final String email = "aniel@burki.ch";

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id) {
        Optional<CustomerPO> customerPOSearch = customerRepository.findById(id);

        CustomerPO customerPO = new CustomerPO();
        if (customerPOSearch.isPresent()) {
            customerPO = customerPOSearch.get();
        } else {
            customerPO.setKey("BUC");
            customerPO.setFirstName(firstName2);
            customerPO.setLastName(lastName);
            customerPO.setBirthDate(birthDate);
            customerPO.setCivilStatus(civilStatus);
            customerPO.setEmail(email);
            customerRepository.save(customerPO);
        }
        return new Customer(customerPO.getId(), customerPO.getFirstName(), customerPO.getLastName(), customerPO.getBirthDate(), customerPO.getCivilStatus(), customerPO.getEmail() );
    }

    public Customer findByKey(String key) {
        Optional<CustomerPO> customerPOSearch = customerRepository.findByKey(key);

        CustomerPO customerPO = new CustomerPO();
        if (customerPOSearch.isPresent()) {
            customerPO = customerPOSearch.get();
        } else {
            customerPO.setKey(key);
            customerPO.setFirstName(firstName1);
            customerPO.setLastName(lastName);
            customerPO.setBirthDate(birthDate);
            customerPO.setCivilStatus(civilStatus);
            customerPO.setEmail(email);
            customerRepository.save(customerPO);
        }
        return new Customer(customerPO.getId(), customerPO.getFirstName(), customerPO.getLastName(), customerPO.getBirthDate(), customerPO.getCivilStatus(), customerPO.getEmail() );
    }
}
