package in.dchandwani.ecommerce.payment.request;

import in.dchandwani.ecommerce.payment.customer.Customer;
import in.dchandwani.ecommerce.payment.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
