package c2tc.batch.employee;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		repo.save(employee);
		System.out.println(employee.getId());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
