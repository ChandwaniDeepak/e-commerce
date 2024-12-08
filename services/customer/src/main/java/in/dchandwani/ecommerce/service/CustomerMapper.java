package in.dchandwani.ecommerce.service;

import in.dchandwani.ecommerce.model.Customer;
import in.dchandwani.ecommerce.request.CustomerRequest;
import in.dchandwani.ecommerce.response.CustomerResponse;
import org.springframework.stereotype.Service;


@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request){
        if(request == null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstname())
                .lastName(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
