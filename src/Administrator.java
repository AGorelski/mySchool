import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
/**
 * This class will run day to day our school.
 * It will take information from a file and will use it to create objects of
 * subjects, students and instructors, and it will run the whole process as many times as given.
 * Every day new students up to two students will join and an instructor,
 * the quantity and the types will be chosen with a random generator.
 */
public class Administrator {
    private School school;
    private Random random = new Random();
    private DataReader storedData;
    private ArrayList<LineData> lines;
    /**
     * An administrator will try to read a file, with the help of a DataReader class
     * to take information from and store it in an Arraylist,
     * in which it will be divided into lines and each line will tell the administrator to create a specific object.
     * @param filename is the name of the file, that the administrator is taking information from
     */
    public Administrator(String filename) {
        storedData = new DataReader(filename);
        lines = storedData.getData();
        read();
    }
    /**
     * Depending on the random number that is generated each day up to 2 students will join the school.
     * Each day, there is a chance for an instructor to join the school.
     * There is 20% percent chance to be a Teacher
     *          10% percent chance to be a Demonstrator
     *          5% percent chance to be a OOTrainer or GUITrainer,
     *          as if that is the case, there is 50% for each of them.
     * All new additions will have randomly chosen names.
     * Than with this additional information it calls aDayAtSchool method to make all the connections.
     */
    public void run(){
        int numOfStudents = random.nextInt(2) + 1;
        int typeOfInstructor = random.nextInt(100) + 1;
        int guiOrOO = random.nextInt(2) + 1;
        String name = UUID.randomUUID().toString();
        if (numOfStudents == 1){ //if the randomly chosen number is 1, than one new student will join the school.
            school.add(new Student(name, 'F',23));
        }else if (numOfStudents == 2){ //if the randomly chosen number is 2, than two new students will join the school.
            school.add(new Student(name, 'F',23));
            school.add(new Student(name, 'M',23));
        }
        if (typeOfInstructor <= 20){ // we get a random number from 0 to 100 and if it is less than 20(20%),
            // than a new teacher will join the school.
            school.add(new Teacher(name, 'F',46));
        }else if (typeOfInstructor <= 30){ // if the randomly chosen number is not less than 20,
            // than it might be less than 30(10%) and new demonstrator will join the school.
            school.add(new Demonstrator(name, 'M',35) );
        }
        else if (typeOfInstructor <= 35){ // if the number is not less than 30, than it might be less than 35(35%),
            // than either a new ootrainer or a new guitrainer will join the school
            if (guiOrOO == 1){ //if we get to this point we have different randomly chosen number,
                //that if it is 1(50%), a new ootrainer will join the school.
                school.add(new OOTrainer(name, 'F',27));
            }else if (guiOrOO == 2){ // if it is 2(50%) a new guitrainer will join the school.
                school.add(new GUITrainer(name, 'M',34));
            }
        }
        school.aDayAtSchool(); // see School.class
    }
    /**
     * Depending on the number given when an administrator is created, this method will run that many times,
     * as the number is and with the try-catch block it will slow down a bit.
     * @param numOfDays is number that is given to the administrator when created
     */
    public void run(int numOfDays){
        for (int i = 1; i <= numOfDays; i++) {
            try
            {
                Thread.sleep(500);
                System.out.println("Day " + i);
                run();
            }
            catch (InterruptedException e) {
                System.out.println("Failed!");
            }
        }
    }
    /**
     * This method deals with the configuration of the information from the file,
     * that the administrator takes information from.
     * Each line of the file contains two parts: the name of the object and its characteristics.
     * Depending on what the object on a line is, new instance of that is created in the school
     * with the given characteristics.
     * As for each kind of object the characteristics are different, they are turned into an String array,
     * which allows to take the specific information about the different objects.
     */
    public void read(){
        String[] objectInfo;
        for (LineData line : lines) {
            objectInfo = line.getInfo().split(","); // the second part of a line is split by a ",",
            //which allows to get to each of the characteristics for an object.
            if (line.getObject().equals("school")){ // if the first part of the line is school,
                // than the second is only the name.
                school = new School(line.getInfo());
            }else if (line.getObject().equals("subject")){ // if the first part is a subject,
                // than the second part is divided into 5 parts
                int id = Integer.parseInt(objectInfo[1]);
                int specialism = Integer.parseInt(objectInfo[2]);
                int duration = Integer.parseInt(objectInfo[3]);
                int prerequisites = Integer.parseInt(objectInfo[4]);
                Subject newSubject = new Subject(id,specialism,duration,prerequisites);
                newSubject.setDescription(objectInfo[0]);
                school.add(newSubject);
            }else if (line.getObject().equals("student")){ // if the first part is student,
                // the second part is divided into 3 parts.
                String name = objectInfo[0];
                char gender = objectInfo[1].charAt(0);
                int age = Integer.parseInt(objectInfo[2]);
                Student student = new Student(name,gender,age);
                school.add(student);
            }else if (line.getObject().equals("Teacher")){ // if the first part is a kind of instructor,
                // the second is divided into 3 parts.
                String name = objectInfo[0];
                char gender = objectInfo[1].charAt(0);
                int age = Integer.parseInt(objectInfo[2]);
                Teacher teacher = new Teacher(name,gender,age);
                school.add(teacher);
            }else if (line.getObject().equals("Demonstrator")){
                String name = objectInfo[0];
                char gender = objectInfo[1].charAt(0);
                int age = Integer.parseInt(objectInfo[2]);
                Demonstrator demonstrator = new Demonstrator(name,gender,age);
                school.add(demonstrator);
            }else if (line.getObject().equals("OOTrainer")){
                String name = objectInfo[0];
                char gender = objectInfo[1].charAt(0);
                int age = Integer.parseInt(objectInfo[2]);
                OOTrainer ooTrainer = new OOTrainer(name,gender,age);
                school.add(ooTrainer);
            }else if (line.getObject().equals("GUITrainer")){
                String name = objectInfo[0];
                char gender = objectInfo[1].charAt(0);
                int age = Integer.parseInt(objectInfo[2]);
                GUITrainer guiTrainer = new GUITrainer(name,gender,age);
                school.add(guiTrainer);
            }
        }
    }
    /**
     * This is where an administrator is created and takes information about the school
     * and how many times to run the simulation for it.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0]; // the name of the file, that we want to take information from.
        int days = Integer.parseInt(args[1]); // the number of days that the school will be working.
        Administrator administrator = new Administrator(fileName);
        administrator.run(days);
    }
}
