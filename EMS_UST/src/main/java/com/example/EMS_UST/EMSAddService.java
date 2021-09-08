package com.example.EMS_UST;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EMSAddService {
	
	@Autowired
	EMSRepository repository;
	
	public boolean checkEMPAlreadyExist(String id) 
	{
	Optional<EMS> ems= repository.findById(id); //Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. 
	
	if(ems.isPresent()) {
		return true;
	}
	else {
		return false;
	}
		
	}

}
