package roadrunner.com.exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import roadrunner.com.exam.Controller.CarsController;
import roadrunner.com.exam.Modal.Cars;
import roadrunner.com.exam.Repository.CarsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class ExamApplicationTests {

	private MockMvc mvc;
	@Mock
	private CarsRepository carsrepo;

	@InjectMocks
	private CarsController carsController;

	private JacksonTester<Cars> jsonCar;

	private JacksonTester<Collection<Cars>> jsonCars;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(carsController).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddANewCar() throws Exception {
		Cars car = new Cars(1L,"tarzan","ozaibhanif","tarzan car", "its a tarzan car",300000 );
       when(carsrepo.save(car)).thenReturn((car));
		mvc.perform(post("/cars/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonCar.write(car).getJson()))
				.andExpect(status().isOk());

	}

	@Test
	public void canGetAllCars() throws Exception {
		Cars car1 = new Cars(1L,"best car","cvic","cvic car", "it is a cvic car",275000 );
		Cars car2 = new Cars(1L,"cars","toyota","toyota car", "it is toyota car",250000 );

       
		List<Cars> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		when(carsrepo.findAll()).thenReturn(carList);
		mvc.perform(get("/cars/get")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonCars.write(carList).getJson()));
	}

	@Test
	public void canGetACar() throws Exception {
		Cars car1 = new Cars(1L,"carimage","ozaibkhatri","its is a car", "its run very fast",200000 );
		when(carsrepo.findById(1L)).thenReturn(Optional.of(car1));
		mvc.perform(MockMvcRequestBuilders.get("/cars/gets/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonCar.write(car1).getJson()));
	}
}