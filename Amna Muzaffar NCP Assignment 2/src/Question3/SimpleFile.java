package Question3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class SimpleFile {
	public static void main(String[] args) {
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee("John Doe", "12345-6789012-3", "Manager", "HR", 1));
	        employees.add(new Employee("Jane Smith", "98765-4321098-7", "Developer", "IT", 2));

	        // Write employee records to the file
	        try (FileOutputStream fos = new FileOutputStream("src/Question3/employee_records.txt");
	             PrintWriter writer = new PrintWriter(fos)) {
	            for (Employee employee : employees) {
	                writer.println(
	                    employee.getName() + "," +
	                    employee.getCNIC() + "," +
	                    employee.getDesignation() + "," +
	                    employee.getDepartment() + "," +
	                    employee.getID()
	                );
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Read employee records from the file
	        List<Employee> loadedEmployees = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream("src/Question3/employee_records.txt");
	             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 5) {
	                    String name = parts[0];
	                    String cnic = parts[1];
	                    String designation = parts[2];
	                    String department = parts[3];
	                    int id = Integer.parseInt(parts[4]);

	                    Employee employee = new Employee(name, cnic, designation, department, id);
	                    loadedEmployees.add(employee);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Print the loaded employee records
	        for (Employee employee : loadedEmployees) {
	            System.out.println("Name: " + employee.getName());
	            System.out.println("CNIC: " + employee.getCNIC());
	            System.out.println("Designation: " + employee.getDesignation());
	            System.out.println("Department: " + employee.getDepartment());
	            System.out.println("ID: " + employee.getID());
	            System.out.println();
	        }
	    }
}

