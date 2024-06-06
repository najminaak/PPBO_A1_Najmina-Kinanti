import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
    protected String id;
    protected String name;
    protected String department;
    protected String dateOfBirth;
    protected double salary;

    public Employee(String name, String department, String dateOfBirth) {
        this.name = name;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.id = generateUniqueId();
        this.salary = calculateSalary();
    }

    private String generateUniqueId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String datePart = dateFormat.format(new Date());
        int randomNumber = (int) (Math.random() * 1000);
        return String.format("000%s%s%03d", getDepartmentCode(), datePart, randomNumber);
    }

    protected abstract String getDepartmentCode();

    protected abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department +
                ", Date of Birth: " + dateOfBirth + ", Salary: " + salary;
    }
}
