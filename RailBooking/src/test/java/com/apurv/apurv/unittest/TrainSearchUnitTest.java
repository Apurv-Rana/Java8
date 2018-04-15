package com.apurv.apurv.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.apurv.apurv.Services.TrainSearchService;
import com.apurv.apurv.entities.Train;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.apurv.apurv.repository.TrainRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainSearchUnitTest {

	
	@MockBean
	private TrainRepo trainrepo;
	
	@Autowired
	private TrainSearchService trainsearch ;
	
	
	
	@Before
	public void setUp() {
	   
	 
	    Mockito.when(trainrepo.getByPlace("Ahmedabad", "Bharuch"))
	      .thenReturn(new ArrayList());
	}
	@Test
	public void dotest()
	{
	
		List<Train> train = trainsearch.searchTrain("Ahmedabad", "Bharuch");
		assertThat(train.size()).isEqualTo(0);

	}
}
