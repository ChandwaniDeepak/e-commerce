package in.dchandwani.ecommerce.notification.repository;

import in.dchandwani.ecommerce.notification.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
