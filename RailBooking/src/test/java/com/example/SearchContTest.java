package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.apurv.apurv.TrainServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainServiceApplication.class)
@AutoConfigureMockMvc
public class SearchContTest {
    @Autowired
    private MockMvc mockMvc;

    
   

	@Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
     
	 mockMvc.perform(get("http://localhost:8085/search?source=Ahmedabad&destination=Bharuch&date=2018-09-20"))
         .andExpect(status().isOk())
         .andExpect(view().name("search"))
         .andExpect(forwardedUrl("search.jsp"));
      
    }
	
	
}
