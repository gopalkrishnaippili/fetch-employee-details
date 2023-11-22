package SpringBoot.SpringDataJPA.exception;

public class EmployeeException extends Exception{
    public EmployeeException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  

}
