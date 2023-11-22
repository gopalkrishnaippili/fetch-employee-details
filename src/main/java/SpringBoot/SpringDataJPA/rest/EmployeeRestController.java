package SpringBoot.SpringDataJPA.rest;

import SpringBoot.SpringDataJPA.dto.EmployeeDTO;
import SpringBoot.SpringDataJPA.entity.Employee;
import SpringBoot.SpringDataJPA.exception.EmployeeException;
import SpringBoot.SpringDataJPA.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController 
{
    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }
    
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) throws EmployeeException
    {
    	employee.setId(0);
		String valRes = employeeService.validate(employee);
		if (!valRes.isEmpty()) {
			throw new EmployeeException(valRes);
		}
        employeeService.save(employee);
        return employee;
    }
    
    @GetMapping("/allEmployeesTaxDeduc")
    public List<EmployeeDTO> getAllEmployeesTaxDeductions()
    {
    	return employeeService.getTaxDedForCFY();
    }

}
