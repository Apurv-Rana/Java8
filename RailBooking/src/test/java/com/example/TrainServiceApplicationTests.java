package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.apurv.apurv.TrainServiceApplication;
import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Available;
import com.apurv.apurv.entities.Passanger;
import com.apurv.apurv.entities.PassangerKey;
import com.apurv.apurv.entities.Train;
import com.apurv.apurv.Services.PassangerBookService;
import com.apurv.apurv.Services.TrainAvailableService;
import com.apurv.apurv.Services.TrainSearchService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainServiceApplication.class)
public class TrainServiceApplicationTests {

	@Autowired
	private TrainSearchService trainSearch;
	@Autowired 
	List<Train> trains;
	
	@Autowired 
	Train train;
	
	@Autowired 
	TrainAvailableService availService ;
	@Autowired 
	AvailKey availkey;
	
	@Autowired 
	PassangerBookService passangerBook;
	
	@Autowired 
	PassangerKey passangerkey;
	
	@Autowired 
	Passanger passanger ;
	
	
	@Test
	public void getBySourceAndDestination() {

	 trains = this.trainSearch.searchTrain("Ahmedabad", "Bharuch");
		int number = trains.get(0).getTrainno();
		String name = trains.get(0).getTrainname();

		assertThat(number).isEqualTo(101);
		assertThat(name).isEqualTo("GUJARAT Express");

	}

	@Test
	public void SourceIsNull() {
trains.removeAll(trains);

		 trains = this.trainSearch.searchTrain(null, "Bharuch");
		boolean check = trains.isEmpty();
		assertThat(check).isEqualTo(true);
		
	}
	
	@Test
	public void destinationIsNull() {
trains.removeAll(trains);

		 trains = this.trainSearch.searchTrain("Ahmedabad", null);
		boolean check = trains.isEmpty();
		assertThat(check).isEqualTo(true);
		
	}
	
	@Test
	public void trainNotFound()
	{
		trains.removeAll(trains);
		 trains = this.trainSearch.searchTrain("Ahmedabad", "Hyderabad");
		 boolean check = trains.isEmpty();
		 
			assertThat(check).isEqualTo(true);
		
	}
	
	@Test
	 public void getAvailable()
	 {
		 this.availkey.setDate("2018-09-20");
		 this.availkey.setTrainno(101);
		Optional<Available> available = availService.getAvailable(availkey); 
		boolean check = available.isPresent();
		
	
		assertThat(check).isEqualTo(true);
	 }
	 
	@Test
	public void AvailKeyNull()
	{
		
		Optional<Available> available = availService.getAvailable(null); 
		boolean check = available.isPresent();
		assertThat(check).isEqualTo(false);
		
	}
	
	@Test
	public void trainNotFoundWithDate() {
		this.availkey.setDate("2018-09-21");
		 this.availkey.setTrainno(101);
		Optional<Available> available = availService.getAvailable(availkey); 
		boolean check = available.isPresent();
		
		assertThat(check).isEqualTo(false);
	 
	}
	
	@Test
	public void trainNotFoundWithTrainNoOnDate() {
		this.availkey.setDate("2018-09-20");
		 this.availkey.setTrainno(102);
		Optional<Available> available = availService.getAvailable(availkey); 
		boolean check = available.isPresent();
		
		assertThat(check).isEqualTo(false);
	 
	}
	
	
	@Test 
	public void bookFc()
	{
passangerkey.setDate("2018-09-20");
passangerkey.setName("Apurv");
passangerkey.setTrainno(101);
this.availkey.setDate("2018-09-20");
this.availkey.setTrainno(101);
passanger.setKey(passangerkey);

	boolean check =	passangerBook.book(availkey, passanger, "FC");
	
	assertThat(check).isEqualTo(true);
		
	}
	
	@Test 
	public void bookSL()
	{
passangerkey.setDate("2018-09-20");
passangerkey.setName("Neha");
passangerkey.setTrainno(101);
this.availkey.setDate("2018-09-20");
this.availkey.setTrainno(101);
passanger.setKey(passangerkey);

	boolean check =	passangerBook.book(availkey, passanger, "SL");
	
	assertThat(check).isEqualTo(true);
		
	}
	
	@Test
	public void availKeyNotPresent()
	{
		passangerkey.setDate("2018-09-20");
		passangerkey.setName("Neha");
		passangerkey.setTrainno(101);
		
		passanger.setKey(passangerkey);

			boolean check =	passangerBook.book(null, passanger, "SL");
			
			assertThat(check).isEqualTo(false);
		
	}
	
	@Test
	public void PassangerNotPresent()
	{
		
		this.availkey.setDate("2018-09-20");
		this.availkey.setTrainno(101);
	

			boolean check =	passangerBook.book(availkey, null, "SL");
			
			assertThat(check).isEqualTo(false);
	}
	
	@Test 
	public void clasNotPresent()
	{
		passangerkey.setDate("2018-09-20");
		passangerkey.setName("Neha");
		passangerkey.setTrainno(101);
		this.availkey.setDate("2018-09-20");
		this.availkey.setTrainno(101);
		passanger.setKey(passangerkey);

			boolean check =	passangerBook.book(availkey, passanger, null);
			
			assertThat(check).isEqualTo(false);
		
	}
	
	@Test
	public void ParameterNotPassedToBook()
	{
		boolean check =	passangerBook.book(null, null, null);
		
		assertThat(check).isEqualTo(false);
	}  
	
	@Test
	public void availKeyNotFoundForBookFc()
	{
		passangerkey.setDate("2018-09-20");
		passangerkey.setName("Neha");
		passangerkey.setTrainno(101);
		this.availkey.setDate("2018-09-21");
		this.availkey.setTrainno(101);
		passanger.setKey(passangerkey);

			boolean check =	passangerBook.book(availkey, passanger, "FC");
			
			assertThat(check).isEqualTo(false);
		
	}
	
	
	
}
