package roadrunner.com.exam.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roadrunner.com.exam.Modal.Cars;
import roadrunner.com.exam.Repository.CarsRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    private CarsRepository carsrepo;

    @PostMapping("/post")
    public void saveData(@RequestBody Cars cars){
        carsrepo.save(cars);
    }
    @GetMapping("/get")
    public List<Cars> getCars(){
        return carsrepo.findAll();
    }
     @GetMapping("/gets/{id}")
    public Optional<Cars> getById(@PathVariable Long id) {
     return carsrepo.findById(id);
    }

}
