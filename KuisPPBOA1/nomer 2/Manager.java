public class Manager extends Employee {
    public Manager(String name, String department, String dateOfBirth) {
        super(name, department, dateOfBirth);
    }

    @Override
    protected String getDepartmentCode() {
        return "PROD";
    }

    @Override
    protected double calculateSalary() {
        return 20000000; // Gaji pokok Manager
    }
}
