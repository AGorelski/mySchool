/**
 * Takes two String parameters, which are used to differentiate the Object part from the characteristics part from a file
 */
public class LineData {
    private String object;
    private String info;
    /**
     *
     * @param object a String parameter, which we use to initialize the object part of a line from a file
     * @param info a String parameter, which is used to initialize the characteristics part of a line from a file
     */
    public LineData(String object, String info){
        this.object = object;
        this.info = info;
    }
    /**
     *
     * @return the characteristics part
     */
    public String getInfo() {
        return info;
    }
    /**
     *
     * @return the object name part
     */
    public String getObject() {
        return object;
    }
}
