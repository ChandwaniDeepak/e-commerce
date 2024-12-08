package in.dchandwani.ecommerce.response;

import in.dchandwani.ecommerce.model.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address) {
}
