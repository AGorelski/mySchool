/**
 * This class represents the subjects, that will be taught in the school.
 * A subject will have an ID, a specialism, duration and a description and a prerequisites,
 * which will be ID's of other subjects.
 * When creating a Subject these need to be declared and the description can be set with a method.
 */
public class Subject {
    private Integer id;
    private int specialism;
    private int duration;
    private String description;
    private int prerequisitesforSubject;
    /**
     *
     * @param id is the unique ID of the subject.
     * @param specialism is the specialism ID of the subject.
     * @param duration is how long the subject will be taught.
     * @param prerequisitesforSubject is what are the prerequisites for a subject
     */
    public Subject(Integer id,int specialism,int duration,int prerequisitesforSubject){
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
        this.prerequisitesforSubject = prerequisitesforSubject;
    }
    /**
     * overrides toString method as it returns the description of a subject
     * @return the description that has been set to a subject.
     */
    public String toString() {
        return description;
    }
    /**
     *
     * @return the ID of a subject
     */
    public Integer getID() {
        return id;
    }
    /**
     *
     * @return the specialism of a subject.
     */
    public int getSpecialism() {
        return specialism;
    }
    /**
     *
     * @return the duration of a subject
     */
    public int getDuration() {
        return duration;
    }
    /**
     *
     * @return the description of a subject
     */
    public String getDescription() {
        return description;
    }
    /**
     * Gives value to description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     * @return get the prerequisites for a subject
     */
    public int getPrerequisitesforSubject() {
        return prerequisitesforSubject;
    }
}
