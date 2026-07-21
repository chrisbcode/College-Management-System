# Programming Project - Collge Management System (CMS)

* This was the final project for my Computer Science - Data Structures and Analysis of Algorithms class in the fall of 2025, featuring classes simulating and/or being different roles and data structures, like Stack, List and Queue.
* Orginally, me and 2 teammates worked on this project, turned in a version stored locally on one of their computers and received an A+, but since then I have worked on and completed the version I have.

## Data Structures Implemented
* List was implemented in two ways, appearing in the forms of ArrayBasedList and NodeBasedList to store faculty, students and users, with the implementation chosen reflecting the dynamic and static limits of each class.
* Stack was implemented using nodes, reflecting the seniority-based hiring and firing process of the college workplace.
* Queue was given a custom implementation in ClassWaitlist, simulating the waitlist when a class is full when enrolling in college classes.

## Features
* Console UI allows the user to interact directly or indirectly with every class and structure, as an admin, student or member of the faculty.
**
**
* CSV file parsing has been added, with pre-loaded AI-generated CollegeClass arguments already located in the file, allowing for the user to load these on UI startup.
** This CSV file can be modified to add more or less instances of CollegeClass, as long as the user considers limits on said instances established in the sizeOfCollegeClassList parameter.
