/**
 * College Management System - MyDemo
 * <p>
 * @version 7/16/2026
 * <p>
 * Description: test file
 * <p>
 * @authors Christopher Bergsveinsson, Anh Vo, Maryam Anwari
 */

public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter your username: ");
    String username = keyboard.nextLine();
    System.out.println("Enter your password: ");
    String password = keyboard.nextLine();

    NodeBasedList<User> UserList = new NodeBasedList<>();
    UserList.add(new User(username, password));
    System.out.println(UserList);
    System.out.println(UserList.find(new User("John1", "Doe1")));
    System.out.println(UserList.find2(new User("John1", "Doe1")));


}
