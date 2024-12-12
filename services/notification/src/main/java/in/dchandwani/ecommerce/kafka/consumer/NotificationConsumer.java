package in.dchandwani.ecommerce.kafka.consumer;

import in.dchandwani.ecommerce.notification.repository.NotificationRepository;
import in.dchandwani.ecommerce.kafka.order.OrderConfirmation;
import in.dchandwani.ecommerce.kafka.payment.PaymentConfirmation;
import in.dchandwani.ecommerce.notification.model.Notification;
import in.dchandwani.ecommerce.notification.model.NotificationType;
import in.dchandwani.ecommerce.notification.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) {
        log.info(String.format("Consuming the message form payment-topic:: %s", paymentConfirmation));

        notificationRepository.save(
                Notification.builder()
                        .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDateTime(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        // send email
        var customerName = paymentConfirmation.customerFirstName();
//                .concat(" ")
//                .concat(paymentConfirmation.customerLastName());

        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );


    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) {
        log.info(String.format("Consuming the message form order-topic:: %s", orderConfirmation));

        notificationRepository.save(
                Notification.builder()
                        .notificationType(NotificationType.ORDER_CONFIRMATION)
                        .notificationDateTime(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        // send email
        var customerName = orderConfirmation.customer().firstName();
//                .concat(" ")
//                .concat(orderConfirmation.customer().lastName());

        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );


    }
}
