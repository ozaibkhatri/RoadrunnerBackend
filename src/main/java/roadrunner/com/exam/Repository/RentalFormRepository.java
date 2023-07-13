package roadrunner.com.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import roadrunner.com.exam.Modal.RentalForm;

public interface RentalFormRepository extends JpaRepository<RentalForm, Long> {
    
}
