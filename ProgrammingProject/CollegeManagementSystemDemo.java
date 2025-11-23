import java.util.Scanner;

/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - CollegeManagementSystemDemo
 */

public class CollegeManagementSystemDemo {
    public static void main(String[] args){
        int option;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Welcome to the College Management System, Programming Project made by Chris B, Maryam A and Anh V\n");



        do {
            System.out.println("Are you an admin (1), student (2) or faculty member (3)?");
            option = keyboard.nextInt();

            if(option == 1){
                System.out.println("""
                    \nEnter 1 to 
                    Enter 2 to
                    Enter 3 to
                    Enter 4 to
                    Enter 5 to  """);

                option = keyboard.nextInt();

                if (option == 1) {

                } else if (option == 2) {

                } else if (option == 3) {

                } else if (option == 4) {

                } else if (option == 5) {

                }
                else {

                }
            }
            else if(option == 2){
                System.out.println("""
                    \nEnter 1 to 
                    Enter 2 to
                    Enter 3 to
                    Enter 4 to
                    Enter 5 to  """);

                option = keyboard.nextInt();

                if (option == 1) {

                } else if (option == 2) {

                } else if (option == 3) {

                } else if (option == 4) {

                } else if (option == 5) {

                }
                else {

                }
            }
            else if(option == 3){
                System.out.println("""
                    \nEnter 1 to 
                    Enter 2 to
                    Enter 3 to
                    Enter 4 to
                    Enter 5 to  """);

                option = keyboard.nextInt();

                if (option == 1) {

                } else if (option == 2) {

                } else if (option == 3) {

                } else if (option == 4) {

                } else if (option == 5) {

                }
                else {

                }
            }
        }
        while(option != 5); {
        }


    }
}