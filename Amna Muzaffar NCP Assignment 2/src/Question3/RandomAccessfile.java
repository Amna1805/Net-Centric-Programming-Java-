package Question3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessfile {
	 public static void main(String[] args) {
		        try (RandomAccessFile raf = new RandomAccessFile("src/Question3/employee_records.dat", "rw")) {
		            // Writing employee records to the file
		            Employee emp1 = new Employee("John Doe", "12345-6789012-3", "Manager", "HR", 1);
		            Employee emp2 = new Employee("Jane Smith", "98765-4321098-7", "Developer", "IT", 2);

		            // Write employee data to the file
		            writeEmployee(raf, emp1);
		            writeEmployee(raf, emp2);

		            // Reading employee records from the file
		            raf.seek(0); // Move to the beginning of the file
		            Employee readEmp1 = readEmployee(raf);
		            Employee readEmp2 = readEmployee(raf);

		            System.out.println("Employee 1:");
		            System.out.println("Name: " + readEmp1.getName());
		            System.out.println("EmpID: " + readEmp1.getID());
		            System.out.println("CNIC: " + readEmp1.getCNIC());
		            System.out.println("Designation: " + readEmp1.getDesignation());
		            System.out.println("Department: " + readEmp1.getDepartment());
		            System.out.println("----------------------------------------------------");
		            System.out.println("Employee 2:");
		            System.out.println("Name: " + readEmp2.getName());
		            System.out.println("EmpID: " + readEmp2.getID());
		            System.out.println("CNIC: " + readEmp2.getCNIC());
		            System.out.println("Designation: " + readEmp2.getDesignation());
		            System.out.println("Department: " + readEmp2.getDepartment());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    // Helper method to write an Employee object to the file
		    private static void writeEmployee(RandomAccessFile raf, Employee employee) throws IOException {
		        raf.writeUTF(employee.getName());
		        raf.writeUTF(employee.getCNIC());
		        raf.writeUTF(employee.getDesignation());
		        raf.writeUTF(employee.getDepartment());
		        raf.writeInt(employee.getID());
		    }

		    // Helper method to read an Employee object from the file
		    private static Employee readEmployee(RandomAccessFile raf) throws IOException {
		        String name = raf.readUTF();
		        String cnic = raf.readUTF();
		        String designation = raf.readUTF();
		        String department = raf.readUTF();
		        int id = raf.readInt();
		        return new Employee(name, cnic, designation, department, id);
		    }
}
