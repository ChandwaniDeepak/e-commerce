package in.dchandwani.ecommerce.payment.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,

        @NotNull(message = "firstName is required")
        String firstName,

        @NotNull(message = "lastName is required")
        String lastName,

        @NotNull(message = "email is required")
        @Email(message = "Customer email is not valid")
        String email
) {
}
