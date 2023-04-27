/**
 * This is a type of instructor and can teach subjects with specialization 2.
 */
public class OOTrainer extends Teacher {
    public OOTrainer(String name, char gender, int age) {
        super(name, gender, age);
    }
    /**
     * if the specialism of a subject is 1,2 or 3, than a OOtrainer can teach it.
     * @param subject is the subject, that is checked whether an instructor can teach it.
     * @return
     */
    @Override
    public Boolean canTeach(Subject subject) {
        if (subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 3){
            return true;
        }else {
            return false;
        }
    }
}
