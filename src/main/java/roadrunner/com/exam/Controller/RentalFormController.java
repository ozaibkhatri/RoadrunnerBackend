package roadrunner.com.exam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roadrunner.com.exam.Modal.RentalForm;
import roadrunner.com.exam.Repository.RentalFormRepository;

@RestController
@RequestMapping("/rentalform")
public class RentalFormController {
    
    @Autowired
private RentalFormRepository rentalformrepo;

@PostMapping("/postrental")
    public void saveData(@RequestBody RentalForm rentalform){
        rentalformrepo.save(rentalform);
    }

    @GetMapping("/getrental")
    public List<RentalForm> getRentalForm(){
        return rentalformrepo.findAll();
    }
}

