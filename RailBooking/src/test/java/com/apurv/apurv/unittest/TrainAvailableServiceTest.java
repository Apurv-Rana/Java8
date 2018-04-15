package com.apurv.apurv.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.apurv.apurv.Services.TrainAvailableService;
import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Available;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.apurv.apurv.repository.AvailRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainAvailableServiceTest {

	@Autowired
    Available available ;
	
	@MockBean
	private AvailRepo availrepo;
	
	@Autowired
    AvailKey key;
	
	@Autowired
    TrainAvailableService trainAvailable;
	
	@Before
	public void setAvailRepo()
	{
		key.setDate("2019-09-20");
		key.setTrainno(101);
		
		available.setMyKey(key);
		available.setFc(100);
available.setSl(100);
Optional<Available> op = Optional.empty();

op =Optional.ofNullable(available);	  
Mockito.when(availrepo.findById(key))
	      .thenReturn(op);
System.out.println(op.isPresent());
	}
	
	
	@Test
	public void AvailServiceCheck()
	{
		Optional actual =Optional.empty();
		actual = Optional.ofNullable(available);
		
		Optional check =Optional.empty();
		check =trainAvailable.getAvailable(key);
		
		assertThat(actual.isPresent()).isEqualTo(check.isPresent());
	}
	
}
