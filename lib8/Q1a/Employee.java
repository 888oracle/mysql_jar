import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bob Smith"));
        employees.add(new Employee("Alice Johnson"));
        employees.add(new Employee("Charlie Brown"));
        employees.add(new Employee("David Williams"));

        System.out.println("Employees whose name starts with 'A':");
        for (Employee employee : employees) {
            if (employee.getName().startsWith("A")) {
                System.out.println(employee.getName());
            }
        }
    }
}