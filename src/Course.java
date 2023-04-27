import java.util.ArrayList;
import java.util.Arrays;
/**
 * A course is what is happening in the school.
 * It has one subject, instructors, that are teaching it and enrolled students up to 3
 * There will be progressions every day, as the days till the end of it will decrease.
 */
public class Course {

    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;
    private ArrayList<Student> enrolledStudents;
    private Instructor instructor;
    private boolean cancelCourse;
    /**
     * the hole span of a course will be formed from the days until it starts and the days it is running.
     * It contains a collection of students, that are enrolled.
     * @param subject is the subject that will be taught in this course
     * @param daysUntilStarts are the days remaining till the beginning of the course
     */
    public Course(Subject subject, int daysUntilStarts){
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        this.daysToRun = subject.getDuration();
        enrolledStudents = new ArrayList<Student>();
    }
    /**
     * if the course hasn't started yet and if there are still free spaces,
     * a student gets to be enrolled in this course
     * @param student is the student, who is trying to get enrolled in the course.
     * @return
     */
    public Boolean enrolStudent(Student student){
        if (daysUntilStarts == 0) {
            return false;
        }else if (enrolledStudents.size() > 2){
            return false;
        } else if (!student.getCertificates().contains(getSubject().getPrerequisitesforSubject())){
            return false;
        } else {
            enrolledStudents.add(student);
            student.setEnrolled(true);
            return true;
        }
    }
    /**
     * Checks whether a specific student is enrolled in the course
     * @param student is the specific student, that is checked
     * @return
     */
    public boolean isStudentEnrolled(Student student){
        if (enrolledStudents.contains(student)){
            return true;
        }else {
            return false;
        }
    }
    /**
     *
     * @return the size of the enrolled students to a course.
     */
    public int getSize(){
        return enrolledStudents.size();
    }
    /**
     * puts the enrolled students in an Array.
     * @return an Array of the enrolled students
     */
    public Student[] getStudents(){
        Student[] arrayForEnrolledStudents = enrolledStudents.toArray(new Student[enrolledStudents.size()]);
        return arrayForEnrolledStudents;
    }
    /**
     *
     * @return the subject of this course.
     */
    public Subject getSubject() {
        return subject;
    }
    /**
     * Calculates how many days are left till a course starts
     * and how many days are left if a course has already started.
     * @return the current stage at which the course is.
     */
    public int getStatus(){
        if (daysUntilStarts > 0){
            return -daysUntilStarts;
        }
        if (daysToRun <= subject.getDuration()){
            return daysToRun;
        }else {
            return 0;
        }
    }
    /**
     * if an instructor is able to teach a course, depending on the subject's specialization
     * he gets to be assigned to this course.
     * @param instructor is the instructor, that wants to be assigned for a course.
     * @return
     */
    public Boolean setInstructor(Instructor instructor){
        if (instructor.getAssignedCourse() == null){
            if (instructor.canTeach(subject)){
                this.instructor = instructor;
                instructor.assignCourse(this);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }
    /**
     *
     * @return whether or not a course has an instructor.
     */
    public boolean hasInstructor(){
        if (instructor != null){
            return true;
        }else {
            return false;
        }
    }
    /**
     *
     * @return the instructor assigned to a course if any
     */
    public Instructor getInstructor(){
        if(hasInstructor()){
            return instructor;
        }else {
            return null;
        }
    }
    /**
     * This is how a course will be represented.
     * It contains the subject, the status and the assigned students to the course.
     * @return
     */
    public String toString() {
        return subject.toString() + " " + getStatus() + " " + Arrays.toString(getStudents());
    }
    /**
     * Adds one more day to a course and decreases the number of days until it starts and
     * when it starts decreases the number of days till it is finished, depending on the subject's duration.
     * It cancels the course if it starts without an instructor or any students.
     * When the course is finished gives the certificates of the subject to the students and
     * at the end removes them from the enrolled students and unassignes the instructors.
     */
    public void aDayPasses(){
        if(daysUntilStarts > 0){
            daysUntilStarts--;
        }
        else if (daysToRun > 0){
            daysToRun--;
        }
        if (daysUntilStarts == 0 && daysToRun > 0){
            if (!hasInstructor()) {
                cancelCourse = true;
                enrolledStudents.clear();
            }
            if (enrolledStudents.size() == 0){
                cancelCourse = true;
                if(instructor != null) {
                    instructor.unassignCourse();
                }
            }
        }
        if (daysToRun == 0){
            for (Student enrolledStudent : enrolledStudents) {
                enrolledStudent.graduate(subject);
                enrolledStudent.setEnrolled(false);
            }
            enrolledStudents.clear();
            instructor.unassignCourse();
        }
    }
    /**
     *
     * @return whether the course is cancelled or not.
     */
    public boolean isCancelled(){
        return cancelCourse;
    }
    /**
     * if the days remaining till a course are 0 and the number of students enrolled is 0,
     * it means that the course is finished.
     * @return whether the course is finished.
     */
    public boolean isCourseFinished(){
        if (daysToRun == 0 && enrolledStudents.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
