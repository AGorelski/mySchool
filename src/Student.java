import java.util.ArrayList;
/**
 * This is a student from our school.
 * He can enrol in one course at a time with some conditions:
 * course must not be in progress, the number of enrolled students should not be more than 2
 * and a student need to have a certificate with the same ID as the prerequisites of the course,
 * and when finished, he gets a certificate for the same course.
 */
public class Student extends Person {
    private ArrayList<Integer> certificates;
    private boolean enrolled = false;
    /**
     * Every student have a collection of certificates, containing the IDs of the subjects
     * which will increase whenever he graduates from a course
     * @param name a student will have a name given when created
     * @param gender a student will be initialized with gender when created
     * @param age a student will be given an age when created
     */
    public Student(String name, char gender, int age) {
        super(name, gender, age);
        certificates = new ArrayList<Integer>();
        certificates.add(0);
    }
    /**
     * when a course is finished, the student will add the subject's ID
     * to his collection of certificates
     * @param subject is the subject that the student has graduated from and has to take the certificate
     */
    public void graduate(Subject subject){
        certificates.add(subject.getID());
    }
    /**
     *
     * @return the certificates of a student
     */
    public ArrayList<Integer> getCertificates() {
        return certificates;
    }
    /**
     * checks whether the student already has a certificate for a specific subject
     * @param subject is the specific subject, that a student might or not have a certificate from
     * @return whether a student has a certificate ot not
     */
    public Boolean hasCertificate(Subject subject){
        if (certificates.contains(subject.getID())){
            return true;
        }else {
            return false;
        }
    }
    /**
     * If student is enrolled in any course at all, this method has to be called.
     */
    public void setEnrolled(boolean status){
        enrolled = status;
    }
    /**
     *
     * @return whether or not the student is enrolled anywhere.
     */
    public boolean isEnrolled(){
        return enrolled;
    }
    /**
     * overriding toString method, so when called to return the name of the student
     * @return
     */
    @Override
    public String toString() {
        return getName();
    }
}
