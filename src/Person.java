/**
 * This is the subclass of all type of people in the school,
 * instructors and students
 */
public class Person {
    private String name;
    private char gender;
    private int age;
    /**
     *
     * @param name a person will have a name given when created
     * @param gender a person will be initialized with gender when created
     * @param age a student will be given an age when created
     */
    public Person(String name,char gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    /**
     *
     * @return the name of a person
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @return the gender of a person
     */
    public char getGender() {
        return gender;
    }
    /**
     *
     * @param age is what is given to a person as an age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     *
     * @return the age of a person.
     */
    public int getAge() {
        return age;
    }
}
