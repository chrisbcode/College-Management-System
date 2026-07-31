# Programming Project - College Management System (CMS) by Christopher Bergsveinsson, Anh Vo and Maryam Anwari

* This was the final project for my Computer Science - Data Structures and Analysis of Algorithms class in the fall of 2025, featuring classes made from scratch simulating and/or being different roles and data structures, like Stack, List and Queue.
* These classes and an added CSV file and the ability to parse such a file was combined to create the CMS and the console UI, ensuring a clean and fast user experience, whether they decide to take on the role of admin, student or faculty.

## Data Structures Implemented
* List was implemented in two ways, appearing in the forms of ArrayBasedList and NodeBasedList to store faculty, students and users, with the implementation chosen reflecting the dynamic and static limits of each class.
* Stack was implemented using nodes, reflecting the seniority-based hiring and firing process of the college workplace.
* Queue was given a custom implementation in ClassWaitlist, simulating the waitlist when a class is full when enrolling in college classes.

## Features
* Console UI allows the user to interact directly or indirectly with every class and structure, as an admin, student or member of the faculty. Interacting with the UI as:
  * an admin allows for the complete management of classes and faculty
  * a student allows for logging on, creating an account, and managing, removing or viewing classes.
  * a member of the faculty allows for creating an account tied to your existing faculty profile, reassigning one of your classes (assigned by admin) to a part-time member of faculty, and viewing your assigned classes.
* CSV file parsing has been added, with pre-loaded AI-generated CollegeClass arguments already located in the file, allowing for the user to load these on UI startup.
  * This CSV file can be modified to add more or less instances of CollegeClass, as long as the user considers limits on said instances established in the sizeOfCollegeClassList parameter.
