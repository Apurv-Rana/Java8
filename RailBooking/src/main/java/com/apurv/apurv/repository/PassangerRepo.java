package com.apurv.apurv.repository;

import com.apurv.apurv.entities.Passanger;
import com.apurv.apurv.entities.PassangerKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassangerRepo  extends JpaRepository<Passanger, PassangerKey>{

	
}
