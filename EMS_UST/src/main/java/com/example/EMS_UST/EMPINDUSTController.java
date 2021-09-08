package com.example.EMS_UST;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javassist.NotFoundException;

@RestController
public class EMPINDUSTController  {
	
	AtomicInteger counter = new AtomicInteger();
	
	@Autowired
	EMSRepository repository;
	
	@Autowired
	EMSAddService emsservice;
	
	@GetMapping("/getEmployee")
	public List<EMS> getEmployeeByName(@RequestParam(value="EmployeeName")String EmployeeName) {
		
		return repository.findAllByeName(EmployeeName);
		
		//Add EMSRepositoryCustom to the repositoryy inteface
		//1. public interface EMSRepository extends JpaRepository<EMS, String>,EMSRepositoryCustom
		//2. create interface called EMSRepositoryCustom
		//3. All following line to interface 	List<EMS>findAllByEMPName(String employeename);
		//4.create on class for implementing the interface - class name EMSRepositoryCUtomIMPL
		//5. Add the unimplemented method to the above class

	}
	
	@PostMapping("/addEmployee") // to insert new entry to table via post man
	public ResponseEntity<AddResponse> addEmployeeImplementation(@RequestBody EMS ems) {
		
		HttpHeaders headers = new HttpHeaders();
		String id = ems.geteName()+counter.getAndIncrement();
		AddResponse add= new AddResponse();
		
		if(!emsservice.checkEMPAlreadyExist(id)) {
		ems.seteID(id);
		repository.save(ems);
		
		//now to get the response , we will create one bean class with ID and msg (class name AddResponse)
		//add.setId(ems.geteName()+counter.getAndIncrement());
		add.setId(id);
		add.setMsg("Success : Employee is Added");
		headers.add("Unique", id);
		
		
		return new ResponseEntity<AddResponse>(add,headers,HttpStatus.CREATED);
		}
		else
		{
			//if it is true
			add.setId(id);
			add.setMsg("Employee Already exists");
			
			return new ResponseEntity<AddResponse>(add,headers,HttpStatus.ACCEPTED);
		}
		
	}
	
	@GetMapping("/getEmployee/{id}")
	public EMS getEmployeeByID(@PathVariable(value="id")String id) {
		
		try{
			EMS ems=repository.findById(id).get();
			return ems;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
		}
	}
	
	@PutMapping("/updateEmployee/{id}")
	private ResponseEntity<EMS> updateEmployee(@PathVariable(value="id")String id,@RequestBody EMS ems) {

		EMS empRecord=repository.findById(id).get();
		empRecord.seteName(ems.geteName());
		empRecord.seteSal(ems.geteSal());
		repository.save(empRecord);
		return new ResponseEntity<EMS>(empRecord,HttpStatus.OK);
	}
	
	//Delete by id method
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestBody EMS ems) {
		
		EMS delID=repository.findById(ems.geteID()).get();
		repository.delete(delID);
		return new ResponseEntity<>("Employee record is deleted",HttpStatus.CREATED);
		
	}
	
	//DeleteAll method
	
	@DeleteMapping("/deleteAll")
	private ResponseEntity<String> deleteAllEmployee() {
		
		repository.deleteAll();
		return new ResponseEntity<>("All Employee Details deleted",HttpStatus.CREATED);
	}


}
