package in.dchandwani.ecommerce.order.request;

import in.dchandwani.ecommerce.order.model.PaymentMethod;
import in.dchandwani.ecommerce.order.product.request.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,

        @Positive(message = "Order amount should be positive")
        BigDecimal amount,

        @NotNull(message = "should be present")
        PaymentMethod paymentMethod,

        @NotNull(message = "customer should be present")
        @NotEmpty(message = "customer should be present")
        @NotBlank(message = "customer should be present")
        String customerId,

        @NotEmpty(message = "Should purchase atleast one product")
        List<PurchaseRequest> products
) {
}
