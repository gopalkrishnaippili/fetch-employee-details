package SpringBoot.SpringDataJPA.service;

import SpringBoot.SpringDataJPA.dao.EmployeeRepository;
import SpringBoot.SpringDataJPA.dto.EmployeeDTO;
import SpringBoot.SpringDataJPA.entity.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public void save(Employee theEmployee) 
    {
        employeeRepository.save(theEmployee);
    }

	public String validate(Employee employee) {
		String errorMessage = "";
		if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
			errorMessage = "FistName must not be null or empty";
		} else if (employee.getLastName() != null && !employee.getLastName().isEmpty()) {
			errorMessage = "LastName must not be null or empty";
		} else if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
			errorMessage = "Email must not be null or empty";
		} else if (employee.getPhoneNumber() != null && employee.getPhoneNumber().size()>0) {
			errorMessage = "PhoneNumber must not be null or empty";
		} else if (employee.getDoj() != null) {
			errorMessage = "Date Of Joining must not be null or empty";
		}
		return errorMessage;
		
	}

	@Override
	public List<EmployeeDTO> getTaxDedForCFY() {
		//get all employees
		List<Employee> empList = employeeRepository.findAll();
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		if (empList.size() > 0) {
			for (Employee emp : empList) {
				EmployeeDTO empDTO = new EmployeeDTO();
				empDTO.setEmployeeId(emp.getId());
				empDTO.setFirstName(emp.getFirstName());
				empDTO.setLastName(emp.getLastName());
				//caluclate yearly salary
				int joiningdayOfMonth = emp.getDoj().getDayOfMonth();
				int joiningMonth = emp.getDoj().getMonthValue();
				int totalDaysInMonth = 30;
				double actualMonthlySal = emp.getSalary();
				double daySal = actualMonthlySal/30;
				int payableDays = totalDaysInMonth - (joiningdayOfMonth-1);
				double totalSal = payableDays*daySal + 11*actualMonthlySal;
				empDTO.setSalary(totalSal);
				
				//calculate tax amount
				double taxDed;
				double cessAmnt = 0;
				if (totalSal < 250000) {
					taxDed = 0;
				} else if (totalSal > 250000 && totalSal <= 500000) {
					taxDed = 0.05*totalSal;
					
				} else if (totalSal > 500000 && totalSal <= 1000000) {
					
					taxDed = 0.10*totalSal;
				} else {
					taxDed = 0.25*totalSal;
					cessAmnt = 0.02*totalSal;
				}
				
				empDTO.setTaxAmount(taxDed);
				empDTO.setCessAmount(cessAmnt);
				empDTOList.add(empDTO);
				
			}
			
		}
		return empDTOList;
		
	}
}
