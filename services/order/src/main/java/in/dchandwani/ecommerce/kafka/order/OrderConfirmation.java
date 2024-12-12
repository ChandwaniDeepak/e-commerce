package in.dchandwani.ecommerce.kafka.order;

import in.dchandwani.ecommerce.order.customer.response.CustomerResponse;
import in.dchandwani.ecommerce.order.model.PaymentMethod;
import in.dchandwani.ecommerce.order.product.response.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
