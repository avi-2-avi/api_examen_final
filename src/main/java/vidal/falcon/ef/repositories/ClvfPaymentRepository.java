package vidal.falcon.ef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vidal.falcon.ef.entities.ClvfPayment;

public interface ClvfPaymentRepository extends JpaRepository<ClvfPayment, Long> {
}
