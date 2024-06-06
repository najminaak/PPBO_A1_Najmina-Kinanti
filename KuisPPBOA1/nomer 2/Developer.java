public class Developer extends Employee {
    public Developer(String name, String department, String dateOfBirth) {
        super(name, department, dateOfBirth);
    }

    @Override
    protected String getDepartmentCode() {
        return "PROD";
    }

    @Override
    protected double calculateSalary() {
        return 10000000; // Gaji pokok Developer
    }
}
