package com.example.EMS_UST;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EmsUstApplication {//implements CommandLineRunner {
	
	@Autowired
	EMSRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmsUstApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * EMS ems = repository.findById("E1").get();
	 * System.out.println(ems.geteName());
	 * 
	 * EMS ems1=new EMS();
	 * 
	 * ems.seteID("E3"); ems.seteID("Amitha"); ems.seteSal("60000");
	 * repository.save(ems1);
	 * 
	 * //get all entries List<EMS> allRecords=repository.findAll();
	 * 
	 * for(EMS items: allRecords) { System.out.println(items.geteName()); }
	 * 
	 * repository.delete(ems1);
	 * 
	 * 
	 * }
	 */


}
