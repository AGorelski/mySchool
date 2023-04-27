/**
 * This is a type of instructor and can teach subjects with specialization 1,2 and 4.
 */
public class GUITrainer extends Teacher {
    public GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }
    /**
     * if the specialism of a subject is 1,2 or 4, than a GUItrainer can teach it.
     * @param subject is the subject, that is checked whether an instructor can teach it.
     * @return
     */
    @Override
    public Boolean canTeach(Subject subject) {
        if (subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 4){
            return true;
        }else {
            return false;
        }
    }
}
