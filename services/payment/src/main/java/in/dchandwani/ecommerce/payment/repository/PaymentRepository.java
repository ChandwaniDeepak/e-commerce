package in.dchandwani.ecommerce.payment.repository;

import in.dchandwani.ecommerce.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
