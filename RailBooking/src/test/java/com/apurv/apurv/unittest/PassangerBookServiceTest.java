package com.apurv.apurv.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.apurv.apurv.Services.TrainAvailableService;
import com.apurv.apurv.TrainServiceApplication;
import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Available;
import com.apurv.apurv.entities.Passanger;
import com.apurv.apurv.entities.PassangerKey;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.apurv.apurv.repository.AvailRepo;
import com.apurv.apurv.repository.PassangerRepo;
import com.apurv.apurv.Services.PassangerBookService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= TrainServiceApplication.class)
public class PassangerBookServiceTest {
	@Autowired
    TrainAvailableService trainService;
	@Autowired
    Available available;

	@MockBean
	PassangerRepo details;

	@MockBean
	AvailRepo availrepo;
	
	@Autowired
    AvailKey key;
	
	@Autowired
    Passanger passanger ;
	@Autowired
    PassangerKey passangerkey;
	
	@Autowired 
	PassangerBookService passangerbook;
	
	
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

	}
	
	@Before
	public void setPaassangerRepo()
	{
		passangerkey.setDate("2019-09-20");
		passangerkey.setName("Apurv");
		passangerkey.setTrainno(101);
		
		passanger.setKey(passangerkey);
		passanger.setSeatnumber("FC-1");
		Mockito.when(details.saveAndFlush(passanger))
	      .thenReturn(passanger);
	}
	
	
	@Test
	public void bookFcTest()
	{
	boolean check =passangerbook.bookFc(key, passanger, "FC"); 
	boolean expected = true;
	assertThat(expected).isEqualTo(check);
	}
	
	@Test
	public void bookSlTest()
	{
	boolean check =passangerbook.bookSl(key, passanger, "SL"); 
	boolean expected = true;
	assertThat(expected).isEqualTo(check);
	}
	
	@Test
	public void book()
	{
	boolean check =passangerbook.book(key, passanger, "SL"); 
	boolean expected = true;
	assertThat(expected).isEqualTo(check);
	}
}
