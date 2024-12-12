package in.dchandwani.ecommerce.payment.service;

import in.dchandwani.ecommerce.kafka.NotificationProducer;
import in.dchandwani.ecommerce.kafka.payment.PaymentNotificationRequest;
import in.dchandwani.ecommerce.payment.request.PaymentRequest;
import in.dchandwani.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    public Integer createPayment(PaymentRequest paymentRequest) {
        var payment = repository.save(mapper.toPayment(paymentRequest));

        // send a notification to notification-ms

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );
        return payment.getId();
    }
}
