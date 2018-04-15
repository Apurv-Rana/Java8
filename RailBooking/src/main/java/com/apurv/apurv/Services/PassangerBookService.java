package com.apurv.apurv.Services;

import java.util.Optional;

import com.apurv.apurv.entities.AvailKey;
import com.apurv.apurv.entities.Available;
import com.apurv.apurv.entities.Passanger;
import com.apurv.apurv.repository.AvailRepo;
import com.apurv.apurv.repository.PassangerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassangerBookService {

	@Autowired
	TrainAvailableService available;


	@Autowired
    PassangerRepo details;

	@Autowired
    AvailRepo change;

	public boolean book(final AvailKey key, final Passanger passanger, final String clas) {
		Optional<AvailKey> availKey = Optional.ofNullable(key);
		

		Optional<Passanger> passangers = Optional.ofNullable(passanger);

		Optional<String> classs = Optional.ofNullable(clas);

		boolean status = false;
		if (availKey.isPresent() && passangers.isPresent() && classs.isPresent() && clas.equals("FC")) {
			status = this.bookFc(key, passanger, clas);
			

		} else if (availKey.isPresent() && passangers.isPresent() && classs.isPresent() && clas.equals("SL")) {
			status = this.bookSl(key, passanger, clas);
		}

		else
			status = false;

		return status;
	}

	public boolean bookFc(final AvailKey key, final Passanger passanger, final String clas) {
		boolean status = false;

		Optional<Available> avail =  available.getAvailable(key);
		
	
		if (avail.isPresent()) {
			
			Available seat = avail.get();

			if (seat.getFc() > 0 && passanger.getKey().getDate().equals(key.getDate())) {
				passanger.setSeatnumber(clas + "-" + (100 - (seat.getFc()) + 1));
				seat.setFc(seat.getFc() - 1);
				this.change.save(seat);
				if (passanger.getKey().getDate().equals(key.getDate())) {
					
					details.saveAndFlush(passanger);
					status = true;
				}
			}

		} else {
			status = false;
		}

		return status;

	}

	public boolean bookSl(final AvailKey key, final Passanger passanger, final String clas) {
		boolean status = false;

		Optional<Available> avail = available.getAvailable(key);
		if (avail.isPresent()) {
			Available seat = avail.get();

			if (seat.getSl() > 0 && passanger.getKey().getDate().equals(key.getDate())) {
				passanger.setSeatnumber(clas + "-" + (100 - (seat.getSl()) + 1));
				seat.setSl(seat.getSl() - 1);
				this.change.save(seat);
				if (passanger.getKey().getDate().equals(key.getDate())) {
					details.saveAndFlush(passanger);
					status = true;
				}
			}
		}

		else {
			status = false;
		}

		return status;
	}
}
