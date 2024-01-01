package Question3;

import java.io.Serializable;

public class Employee implements Serializable{
	  private String name;
	  private String CNIC;
	  private String Designation;
	  private String Department;
	  private int EmployeeID;

	  public Employee(String name,String CNIC,String Designation,String Department, int EmployeeID) {
	    this.name = name;
	    this.CNIC = CNIC;
	    this.Designation = Designation;
	    this.Department = Department;
	    this.EmployeeID = EmployeeID;
	   
	  }

	  public String getName() {
	    return name;
	  }
	  public String getCNIC() {
	    return CNIC;
	  }
	  
	  public String getDesignation() {
	    return Designation;
	  }
	  
	  public String getDepartment() {
	    return Department;
	  }
	  
	  public int getID() {
	    return EmployeeID;
	  }
 

}
