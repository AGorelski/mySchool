/**
 * This is a type of instructor and can teach subjects with specialization 1 and 2.
 */
public  class Teacher extends Instructor {
    public Teacher(String name, char gender, int age) {
        super(name, gender, age);
    }
    /**
     * if the specialism of a subject is 1 and 2, than a teacher can teach it.
     * @param subject is the subject, that is checked whether an instructor can teach it.
     * @return
     */
    @Override
    public  Boolean canTeach(Subject subject){
        if (subject.getSpecialism() == 1 || subject.getSpecialism() == 2){
            return true;
        }else {
            return false;
        }
    }
}
