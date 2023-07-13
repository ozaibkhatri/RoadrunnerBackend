package roadrunner.com.exam;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import roadrunner.com.exam.Controller.RentalFormController;
import roadrunner.com.exam.Modal.RentalForm;
import roadrunner.com.exam.Repository.RentalFormRepository;

@SpringBootTest
public class RentalTest {

	private MockMvc mvc;
	@Mock
	private RentalFormRepository rentalformrepo;

	@InjectMocks
	private RentalFormController rentalController;

	private JacksonTester<RentalForm> jsonRentalForm;

	private JacksonTester<Collection<RentalForm>> jsonRentalFormCollection;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(rentalController).build();
	}
    @Test
        public void addRental() throws Exception {
            RentalForm rentalform1 = new RentalForm(1L, "Ozaib", "nazimabad", "0230943","1641385624","23-10-23" , "25-12-23", 456425L, 45442L, 545341L);
            ArrayList<RentalForm> rentalform = new ArrayList<>();
            rentalform.add(rentalform1);
            mvc.perform(post("/rentalform/postrental")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonRentalForm.write(rentalform1).getJson()))
                    .andExpect(status().isOk());
    }
        @Test
        public void getAllRental() throws Exception {
        RentalForm rentalform1 = new RentalForm(1L, "Ozaib", "nazimabad", "0230943","1641385624","23-10-23" , "25-12-23", 456425L, 45442L, 545341L);
        RentalForm rentalform2 = new RentalForm(1L, "Ozaib", "nazimabad", "0230943","1641385624","23-10-23" , "25-12-23", 456425L, 45442L, 545341L);
        RentalForm rentalform3 = new RentalForm(1L, "Ozaib", "nazimabad", "0230943","1641385624","23-10-23" , "25-12-23", 456425L, 45442L, 545341L);
        ArrayList<RentalForm> RentalForm = new ArrayList<>();
        RentalForm.add(rentalform1);
        RentalForm.add(rentalform2);
        RentalForm.add(rentalform3);
        when(rentalformrepo.findAll()).thenReturn(RentalForm);
        mvc.perform(get("/rentalform/getrental")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}



	