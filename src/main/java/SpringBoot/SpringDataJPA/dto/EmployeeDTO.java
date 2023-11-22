package SpringBoot.SpringDataJPA.dto;

public class EmployeeDTO {
	private int employeeId;
	private String FirstName;
	private String LastName;
	private double salary;
	private double taxAmount;
	private double cessAmount;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", salary=" + salary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}
	

}
