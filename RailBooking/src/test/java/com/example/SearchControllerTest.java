package com.example;

import java.util.List;

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

import com.apurv.apurv.TrainServiceApplication;
import com.apurv.apurv.entities.Train;
import com.apurv.apurv.Services.TrainSearchService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TrainServiceApplication.class)
@AutoConfigureMockMvc
public class SearchControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private TrainSearchService trainSearch;
	@Autowired 
	List<Train> trains;
	
	@Autowired 
	Train train;
	
	@Test
	public void check() throws Exception
	{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"http://localhost:8080/search/Ahmedabad/Bharuch").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected ="{\"train\":[{\"trainno\":101,\"trainname\":\"GUJARAT Express\",\"source\":\"Ahmedabad\",\"destination\":\"Bharuch\",\"distance\":200},{\"trainno\":102,\"trainname\":\"Gujarat Queen \",\"source\":\"Ahmedabad\",\"destination\":\"Bharuch\",\"distance\":200}]}";
	
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
