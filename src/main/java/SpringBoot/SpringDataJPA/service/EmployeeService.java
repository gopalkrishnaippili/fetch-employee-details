package SpringBoot.SpringDataJPA.service;

import java.util.List;

import SpringBoot.SpringDataJPA.dto.EmployeeDTO;
import SpringBoot.SpringDataJPA.entity.Employee;

public interface EmployeeService 
{
    public void save(Employee employee);

	public String validate(Employee employee);

	public List<EmployeeDTO> getTaxDedForCFY();
}
