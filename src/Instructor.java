/**
 * Instructor work in the school, they teach different courses,
 * as one instructor can teach only one at a time.
 * An instructor can be assigned to a course and unassigned.
 * Depending on the time of instructor, he can teach only specific students.
 */
public abstract class Instructor extends Person {
    private Course assignedCourse;
    /**
     *
     * @param name is the name of the instructor given when created.
     * @param gender is initialized when an instructor is created.
     * @param age is the age that is given to the instructor when created.
     */
    public Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }
    /**
     * Assign course to an instructor.
     * @param course is the course, that the instructor will be assigned to.
     */
    public void assignCourse(Course course){
        if (getAssignedCourse() == null) {
            this.assignedCourse = course;
        }
    }
    /**
     * Unassign course to an instructor.
     */
    public void unassignCourse(){
        assignedCourse = null;
    }
    /**
     *
     * @return the assigned course of an instructor.
     */
    public Course getAssignedCourse() {
        if (assignedCourse != null){
            return assignedCourse;
        }else {
            return null;
        }
    }
    /**
     * This method is initialized in the subclasses of Instructor
     * Checks whether an instructor can teach a specific subject,
     * depending on the subject's specialization.
     * @param subject is the subject, that is checked whether an instructor can teach it.
     * @return
     */
    public abstract Boolean canTeach(Subject subject);
}
