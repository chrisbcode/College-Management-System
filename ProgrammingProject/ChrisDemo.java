public class ChrisDemo {
    public static void main(String[] args){
        Student[] students = {new Student("Jerry"), new Student("John"), new Student("Mary"), new Student("Bob")};
        Student[] students2 = {new Student("William"), new Student("Chris"), new Student("Mary"), new Student("Jack")};


        CollegeClass collegeClass = new CollegeClass(students, students2);

        System.out.println(collegeClass.toString2());

    }
}