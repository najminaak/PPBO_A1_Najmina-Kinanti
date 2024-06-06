public class HRStaff extends Employee {
    public HRStaff(String name, String department, String dateOfBirth) {
        super(name, department, dateOfBirth);
    }

    @Override
    protected String getDepartmentCode() {
        return "HR";
    }

    @Override
    protected double calculateSalary() {
        return 5000000; // Gaji pokok HR Staff
    }
}
