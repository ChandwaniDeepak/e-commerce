package in.dchandwani.ecommerce.order.payment;

import in.dchandwani.ecommerce.order.customer.response.CustomerResponse;
import in.dchandwani.ecommerce.order.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
