package in.dchandwani.ecommerce.repository;

import in.dchandwani.ecommerce.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
