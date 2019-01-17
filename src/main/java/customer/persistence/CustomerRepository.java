package customer.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerPO, Long> {
    Optional<CustomerPO> findByKey(String key);

    Optional<CustomerPO> findById(Long id);
}
