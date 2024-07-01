import java.util.ArrayList;

public class EmployeeCRUD {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        // CREATE (C)
        System.out.println("CREATION: ");

        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Employee 1");
        emp1.setDepartment("Department 1");

        Employee emp2 = new Employee();

        emp2.setId(2);
        emp2.setName("Employee 2");
        emp2.setDepartment("Department 2");

        employees.add(emp1);
        employees.add(emp2);

        System.out.println(employees);

        // READ (R)
        System.out.println("READ: ");
        System.out.println(employees);

        Employee emp = employees.get(0);

        System.out.println(emp);

        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Department: " + emp.getDepartment());

        // UPDATE (U)
        System.out.println("UPDATE:");

        Employee emp3 = new Employee();
        emp3.setId(3);
        emp3.setName("Employee 3");
        emp3.setDepartment("Department 3");

        employees.set(1, emp3);

        System.out.println(employees);

        // DELETE (D)
        System.out.println("DELETE: ");

        employees.remove(1);

        System.out.println(employees);
    }

}
