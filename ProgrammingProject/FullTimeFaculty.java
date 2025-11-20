public class FullTimeFaculty extends Faculty {

    public static final int REQUIRED_CREDITS = 15;

    public FullTimeFaculty(String firstName, String lastName, String DOB, int employeeId, String username, String password,
                   Employee.MyDate hireDate, String department) {
        super(firstName, lastName, DOB, employeeId, username, password, hireDate, department);
    }

    //public boolean meetsRequiredLoad() {
    //    return getTotalCredits() >= REQUIRED_CREDITS;
    //}
}
