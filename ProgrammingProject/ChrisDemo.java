public class ChrisDemo {
    public static void main(String[] args){
        Student chris = new Student("Chris", 123, 2025, 3, 11);

        CollegeClass collegeClass = new CollegeClass("CompSci", "CSC", 123, 5, "Thursday", 9, 35, 35, 30, 45);

        collegeClass.addStudent(chris);

        boolean FT = false;
        collegeClass.setProfessor(new Faculty("William", 123, "CompSci", FT));

        chris.removeClass();

        System.out.println(collegeClass.toString2());

    }
}