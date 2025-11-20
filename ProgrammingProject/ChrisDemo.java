public class ChrisDemo {
    public static void main(String[] args){
        Student[] students = {new Student("Jerry", 1), new Student("John", 2), new Student("Mary", 3), new Student("Bob", 4)};
        Student[] students2 = {new Student("William", 5), new Student("Chris", 6), new Student("Mary", 7), new Student("Jack", 8)};


        CollegeClass collegeClass = new CollegeClass(students, students2);

        System.out.println(collegeClass.toString());

    }
}