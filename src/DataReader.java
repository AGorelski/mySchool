import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * A class, that reads a file using BuffetReader.
 * It reads separately the lines of the file and splits them in two parts.
 */
public class DataReader {
    private BufferedReader reader = null;
    private ArrayList<LineData> lines;
    /**
     * The constructor takes a String as a parameter, which will be the name of the file, that we want to read.
     * It tries to read it and if everything is fine, it will work, otherwise it will throw exception.
     * @param fileName is the name of the file, from which we are trying to read.
     */
    public DataReader(String fileName){
        try {
            reader = new BufferedReader(new FileReader(fileName));
        }catch (Exception e){
            System.out.println("The file can Not be read!");
        }
    }
    /**
     * it reads only one line from the file.
     * if it can read the line, it will return the line, otherwise it will throw exception.
     * @return a line from the file
     */
    public String getLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Takes the the lines from the file and splits them by ":".
     * Adds the lines to an ArrayList of type FlashCard, which will divide the line into a question and an answer.
     * If it can't read from the file it will throw exception.
     * @return the ArrayList which contains lines, which are divided into questions and answers.
     */
    public ArrayList getData(){
        lines = new ArrayList<LineData>();
        String part;
        try {
            while((part = getLine())!=null) {
                String[] arr = part.split(":");
                lines.add(new LineData(arr[0],arr[1]));
            }
        }catch (Exception e){
            System.err.println("File is not read!");
        }
        return lines;
    }
}
