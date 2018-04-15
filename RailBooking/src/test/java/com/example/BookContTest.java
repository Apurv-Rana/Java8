package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.apurv.apurv.TrainServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TrainServiceApplication.class)
@AutoConfigureMockMvc
public class BookContTest {

	@Autowired
    private MockMvc mockMvc;

    
   

	@Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
     
		 mockMvc.perform(get("http://localhost:8085/tick?number=101&source=Ahmedabad&destination=Bharuch&trainname=GUJARAT+Express&date=2018-09-20&name=Apurv&email=r.apurv2%40gmail.com&gender=male&clas=FC"))
         .andExpect(status().isOk())
         .andExpect(view().name("ticket"))
         .andExpect(forwardedUrl("ticket.jsp"));
      
    }
}
