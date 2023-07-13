package roadrunner.com.exam.Modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Cars {
    public Cars(long id2, String image2, String name2, String shortdescription2, String longdescription2, int i) {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String name;
    private String shortdescription;
    @Column(length =2000)
    private String longdescription;
    private Long rentalfeeperday;
    

    
    
}
