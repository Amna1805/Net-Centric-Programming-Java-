package Question3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream {
	public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "12345-6789012-3", "Manager", "HR",1));
        employees.add(new Employee("Jane Smith","98765-4321098-7", "Developer", "IT",2));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Question3/employee_records.ser"))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Question3/employee_records.ser"))) {
      
			@SuppressWarnings("unchecked")
			List<Employee> loadedEmployees = (List<Employee>) ois.readObject();
            for (Employee employee : loadedEmployees) {
                System.out.println("Name: " + employee.getName());
                System.out.println("EmpID: " + employee.getID());
                System.out.println("CNIC: " + employee.getCNIC());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
