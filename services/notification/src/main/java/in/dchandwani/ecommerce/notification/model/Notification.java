package in.dchandwani.ecommerce.notification.model;

import in.dchandwani.ecommerce.kafka.order.OrderConfirmation;
import in.dchandwani.ecommerce.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
@ToString
public class Notification {

    @Id
    private String id;

    private NotificationType notificationType;
    private LocalDateTime notificationDateTime;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
