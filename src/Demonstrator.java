/**
 * This is a type of instructor and can teach subjects with specialization 2.
 */
public class Demonstrator extends Instructor {
    public Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }
    /**
     * if the specialism of a subject is 2, than a demonstrator can teach it.
     * @param subject is the subject, that is checked whether an instructor can teach it.
     * @return
     */
    @Override
    public Boolean canTeach(Subject subject) {
        if (subject.getSpecialism() == 2){
            return true;
        }else {
            return false;
        }
    }
}
