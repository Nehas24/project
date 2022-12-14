package c2tc.batch.employee;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("api")
@CrossOrigin("*")


public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	//Retrieve All data
	@GetMapping ("/employee")
	public List <Employee> list()
	{
		return service.listAll();
		
	}
	
	//Retrieve Specific data
	@GetMapping ("/employee/{id}")
	public ResponseEntity <Employee> get(@PathVariable Integer id)
	{
		try {
			Employee employee = service.get(id);
			return new ResponseEntity <Employee> (employee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity <Employee> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Create Operation
	@PostMapping ("/employee")
	public void add (@RequestBody Employee employee)
	{
		service.save(employee);
	}
	
	//Update Operation
	@PutMapping ("/employee/{id}")
	public ResponseEntity <?> update (@RequestBody Employee employee, @PathVariable Integer id)
	{
		try {
			service.save(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete Operation
	
	@DeleteMapping ("/employe/{id}")
	public void delete (@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	
}
