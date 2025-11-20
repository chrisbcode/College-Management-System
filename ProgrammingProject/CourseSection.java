public class CourseSection {
    private Course course;
    private int sectionNumber;
    private String timeSlot;
    private Faculty instructor;

    public CourseSection(Course course, int sectionNumber, String timeSlot) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.timeSlot = timeSlot;
        this.instructor = null;
    }

    public Course getCourse() {
        return course;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public Faculty getInstructor() {
        return instructor;
    }

    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }
}
