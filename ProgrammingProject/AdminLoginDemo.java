import java.util.Scanner;

public class AdminLoginDemo {

    public static void runAdminLogin(Administrator admin,
                                     ArrayBasedList<CourseSection> sectionList,
                                     ArrayBasedList<Faculty> facultyList) {

        Scanner in = new Scanner(System.in);

        String adminUsername = "admin";
        String adminPassword = "1234";

        boolean loggedIn = false;

        System.out.println("===== Administrator Login =====");
        System.out.print("Username: ");
        String inputUser = in.nextLine();
        System.out.print("Password: ");
        String inputPass = in.nextLine();

        boolean correct = inputUser.equals(adminUsername) && inputPass.equals(adminPassword);

        if (correct) {
            loggedIn = true;
            System.out.println("\nLogin successful. Welcome, Administrator!\n");
        } else {
            System.out.println("\nInvalid username or password.\n");
        }

        
        if (loggedIn) { //if loggedIn = true -> go to menu admin
            AdminDemo1.adminMenu(admin, sectionList, facultyList);
        }
    }
}
