package roadrunner.com.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import roadrunner.com.exam.Modal.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long>{
    
}
