package in.dchandwani.ecommerce.service;


import in.dchandwani.ecommerce.exception.CustomerNotFoundException;
import in.dchandwani.ecommerce.model.Customer;
import in.dchandwani.ecommerce.repository.CustomerRepository;
import in.dchandwani.ecommerce.request.CustomerRequest;
import in.dchandwani.ecommerce.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public Customer createCustomer(CustomerRequest request){
        var customer = repository.save(mapper.toCustomer(request));
        return customer;
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = this.repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
                ));
        mergeCustomer(customer, request);
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request){
        if(StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }

        if (StringUtils.isNotBlank(request.lastName())){
            customer.setLastName(request.lastName());
        }

        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }

        if(request.address() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> getAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Customer not found, No customer exist with provided Id: %s", customerId)
                ));
    }

    public void deleteById(String customerId) {
        repository.deleteById(customerId);
    }
}
