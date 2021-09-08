package com.example.EMS_UST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EMSRepositoryImpl implements EMSRepositoryCustom {

	@Autowired
	EMSRepository repository;

	@Override
	public List<EMS> findAllByeName(String eName) {
		
		List<EMS> eNames=new ArrayList<EMS>();
		List<EMS>emprecords=repository.findAll();
		
		for(EMS items:emprecords) {
			if(items.geteName().equalsIgnoreCase(eName)) {
				eNames.add(items);
			}
		}
		
		return eNames;
	}
}
