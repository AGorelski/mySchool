import java.util.*;
/**
 * This is a school, where information about courses, subjects, students and instructors
 * will be stored and structured in a rational way, depending on the information,
 * that is received from the file.
 * Each day there will be some actions about the school and at the end the state of it
 * will be printed out.
 */
public class School {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;
    private Random random = new Random();
    /**
     * A school has a name and collections of subjects, courses, students and instructors.
     * @param name is the name given to the school when created.
     */
    public School(String name){
        this.name = name;
        students = new ArrayList<Student>();
        subjects = new ArrayList<Subject>();
        courses = new ArrayList<Course>();
        instructors = new ArrayList<Instructor>();
    }
    /**
     * adds a new student to the collection of students.
     * @param student is the new student to be added.
     */
    public void add(Student student){
        students.add(student);
    }
    /**
     * removes a student from the collection of students.
     * @param student is the student to be removed.
     */
    public void remove(Student student){
        students.remove(student);
    }
    /**
     *
     * @return the collection of students.
     */
    public ArrayList<Student> getStudents(){
        return students;
    }
    /**
     * Stores information about a student and all the courses he is enrolled in and
     * return the collection of these courses.
     * @param student is the student, that needs the information about courses he is enrolled in
     * @return the collection of courses a student is enrolled in.
     */
    public int getEnrolledCourses(Student student){
        ArrayList<Course> enrolledCourses = new ArrayList<Course>();
        for (Course course : courses) {
            if (course.isStudentEnrolled(student)){
                enrolledCourses.add(course);
            }
        }
        return enrolledCourses.size();
    }
    /**
     * adds a new subject to the collection of subjects.
     * @param subject is the subject to be added.
     */
    public void add(Subject subject){
        subjects.add(subject);
    }
    /**
     * removes a subject from the collection of subjects.
     * @param subject is the subject to be removed.
     */
    public void remove(Subject subject){
        subjects.remove(subject);
    }
    /**
     *
     * @return the collection of subjects.
     */
    public ArrayList<Subject> getSubjects(){
        return subjects;
    }
    /**
     * adds a new course to the collection of course.
     * @param course is the course to be added.
     */
    public void add(Course course){
        courses.add(course);
    }
    /**
     * removes a course from the collection of courses.
     * @param course is the course to be removed.
     */
    public void remove(Course course){
        courses.remove(course);
    }
    /**
     *
     * @return the collection of courses.
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }
    /**
     * adds a new instructor to the collection of instructors.
     * @param instructor is the instructor to be added.
     */
    public void add(Instructor instructor){
        instructors.add(instructor);
    }
    /**
     * removes a new instructor to the collection of instructors.
     * @param instructor is the instructor to be removed.
     */
    public void remove(Instructor instructor){
        instructors.remove(instructor);
    }
    /**
     *
     * @return the collection of instructors.
     */
    public ArrayList<Instructor> getInstructors(){
        return instructors;
    }
    /**
     * Stores and returns data about the current state of the school:
     * the courses and their subjects, the instructors teaching the courses
     * and the number of students enrolled in each course.
     * @return information about a course
     */
    public String getData(){
        String courseNames = "\n";
        String instructorsName = "";
        int numOfStudents = 0;
        for (Course course : courses) {
            if (course.getInstructor() != null){ //if a course has an instructor get his name and later print it out
                instructorsName = course.getInstructor().getName();
            }else {
                instructorsName = "No instructor can teach this course!";
                // if a course does not have an instructor print a message.
            }
            numOfStudents = course.getStudents().length;// get the number of students enrolled in a course.
            courseNames += "\n" + "This subject is: " + course.getSubject() + "\n" +
                    "The instructor for this subject is: " + instructorsName + "\n" +
                    "The number of the students enrolled in this course is: " + numOfStudents + "\n";
        }
        return courseNames;
    }
    /**
     * Gives a school a visual look of its name, courses, subjects, students and instructors.
     * @return the visual look of the school.
     */
    public String toString() {
        String schoolInfo = "Name of the school: " + name + getData();
        return schoolInfo;
    }
    /**
     * if a subject is not already a subject of a course, the subject will be available.
     * @param sub is the subject to be checked whether is available.
     * @return whether a subject is already a subject of an existing course.
     */
    public boolean isAvailable(Subject sub) {
        boolean available = true;
        for (Course course : courses) {
            if (course.getSubject() == sub) {
                available = false;
                break;
            }
        }
        return available;
    }
    /**
     * Deals with the information received and sorts it out.
     * Creates new courses with subjects and assignes instructors and
     * enrolls students. This is all stored and at the end of the day is printed out
     * as every day there is a change in the configuration of the school.
     * It may remove students and instructors if they are not doing anything.
     */
    public void aDayAtSchool() {
        int leaveInstructor = random.nextInt(100) + 1;
        int leaveStudent = random.nextInt(100) + 1;
        for (Subject subject : subjects) { // if a subject does not have a course going on,
            // one is created for the subject and 2 days are left till it starts.
            if (isAvailable(subject)) {
                courses.add(new Course(subject, 2));
            }
        }
        for (Course course : courses) { // if a course does not have an instructor, the instructors
            //will be checked one by one if they are suitable to teach the course.
            if (!course.hasInstructor()) {
                for (Instructor instructor : instructors) {
                    if (instructor.getAssignedCourse() == null) {// if an instructor is not teaching already.
                        if (course.setInstructor(instructor)){
                            break;
                        }
                    }
                }
            }
        }
        for (Student student : students) {// if a course is not enrolled in any course and
            // does not have a certificate for a certain course, he will try to be enrolled.
            if (!student.isEnrolled()) {
                for (Course course : courses) {
                    if (!student.hasCertificate(course.getSubject())) {
                        if (course.enrolStudent(student)){
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(toString());// prints the state of the school so far.

        //if a instructor is not assigned to any course he has a chance of leaving the school
        //if a randomly chosen number is less than 20(20%), than he will be added to a collection,
        //which will be removed from the collections of instructors in the school.
        ArrayList<Instructor> instructorsToRemove = new ArrayList<Instructor>();
        for (Instructor instructor : instructors) {
            if (instructor.getAssignedCourse() == null){
                if (leaveInstructor <= 20){
                    instructorsToRemove.add(instructor);
                }
            }
        }
        instructors.removeAll(instructorsToRemove);

        //if a student is not enrolled in any course he has a chance of leaving the school
        //if a randomly chosen number is less than 5(5%), than he will be added to a collection,
        //which will be removed from the collections of students in the school.
        ArrayList<Student> studentsToLeave = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getCertificates().size() == subjects.size()){
                studentsToLeave.add(student);
            }
            if (!student.isEnrolled()){
                if (leaveStudent <= 5){
                    studentsToLeave.add(student);
                }
            }
        }
        students.removeAll(studentsToLeave);

        //if a course is finished or cancelled, than it is removed from the school.
        Iterator<Course> courseIterator = courses.iterator();
        while(courseIterator.hasNext()){
            Course course = courseIterator.next();
            if (course.isCourseFinished() || course.isCancelled()){
                courseIterator.remove();
            }
        }

        for (Course course : courses) {//prints out how many days are left either till each course begins or till it ends
            //and the enrolled students in each course.
            System.out.println("Course's status: " + course.getStatus() + "\n" +
                    "Enrolled students for this course: " + Arrays.toString(course.getStudents()));
        }
        System.out.println();

        for (Student student : students) {// prints out each student's certificates and enrolled courses if any.
            System.out.println(student.getName() + "'s certificates: " + student.getCertificates());
            if (student.isEnrolled()){
                System.out.println("Enrolled courses: " + getEnrolledCourses(student));
            }
        }
        System.out.println();

        for (Instructor instructor : instructors) {// prints out each instructor's name and the course each is assigned to.
            System.out.println("Assigned courses for " +instructor.getName() + " are: " + instructor.getAssignedCourse());
        }

        //for each course passes a day and if any of them is cancelled or finished adds them to a collection
        // and later removes them from the collection of courses in the school
        List<Course> courseToRemove = new ArrayList<>();
        for (Course course : courses) {
            course.aDayPasses();
            if (course.isCancelled() || course.isCourseFinished()) {
                courseToRemove.add(course);
            }
        }
        courses.removeAll(courseToRemove);
        System.out.println();
    }
}
