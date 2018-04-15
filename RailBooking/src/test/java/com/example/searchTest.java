package com.example;

import com.apurv.apurv.TrainServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainServiceApplication.class)
@AutoConfigureMockMvc
public class searchTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void searchtest() throws Exception
    {
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"http://localhost:8085/search/Ahmedabad/Bharuch").accept(
				MediaType.APPLICATION_JSON);
    	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	String expected ="{\"train\":[{\"trainno\":101,\"trainname\":\"GUJARAT Express\",\"source\":\"Ahmedabad\",\"destination\":\"Bharuch\",\"distance\":200},{\"trainno\":102,\"trainname\":\"Gujarat Queen \",\"source\":\"Ahmedabad\",\"destination\":\"Bharuch\",\"distance\":200}]}";
    	JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
    	  
    
    @Test 
    public void bookTest() throws Exception
    {
    	String k="{\"key\": {\"date\": \"2018-09-20\",\"trainno\": 101},\"passanger\": {\"key\": {\"name\": \"ViditttT\",\"date\": \"2018-09-20\",\"trainno\": 101},\"seatnumber\": \"-\"}}";
    	RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("http://localhost:8085/ticket/FC")
				.accept(MediaType.APPLICATION_JSON).content(k)
				.contentType(MediaType.APPLICATION_JSON);
    	
    	String expected = "{\"key\":{\"name\":\"ViditttT\",\"date\":\"2018-09-20\",\"trainno\":101},\"seatnumber\":\"FC-1\"}";
    	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
    }
    
}
