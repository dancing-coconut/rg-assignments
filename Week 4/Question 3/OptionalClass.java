import java.util.Optional;

class Employee {
    int id;
    String name;
    String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }


    public static Optional<Employee> checkOptional(Employee employee) {
        Optional<Employee> employeeOptional = Optional.ofNullable(employee);

        if (employeeOptional.isPresent()) {
            System.out.println(employeeOptional.get());
        } else {
            System.out.println("No employee recorded.");
        }

        return employeeOptional;
    }

    public static Employee checkNormal(Employee employee) {
        if (employee != null) {
            System.out.println(employee);
            return employee;
        } else {
            System.out.println("No employee recorded.");
            return new Employee(0, "Employee", "Department");
        }
    }
}

public class OptionalClass {
    public static void main(String[] args) {
        Employee employee1 = null;
        Employee employee2 = new Employee(2, "Employee 2", "Department 2");

        Employee employee1Optional = Employee.checkOptional(employee1).orElse(new Employee(0, "Employee", "Department"));
        Employee employee2Optional = Employee.checkOptional(employee2).orElse(new Employee(0, "Employee", "Department"));

        System.out.println(employee1Optional);
        System.out.println(employee2Optional);

        Employee employee1Normal = Employee.checkNormal(employee1);
        Employee employee2Normal = Employee.checkNormal(employee2);

        System.out.println(employee1Normal);
        System.out.println(employee2Normal);
    }
}
