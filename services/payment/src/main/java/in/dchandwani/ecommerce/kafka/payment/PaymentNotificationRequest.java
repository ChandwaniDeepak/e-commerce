package in.dchandwani.ecommerce.kafka.payment;

import in.dchandwani.ecommerce.payment.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail

) {
}