import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
    private  String title;
    private  String personName;
    private  int time;
    private  boolean important;
    private  boolean urgent;
    private  String status;
    Task() {

    }
    Task(String task, String name, int t, boolean imp, boolean urg, String stat) {
        this.title = task;
        this.personName = name;
        this.time = t;
        this.important = imp;
        this.urgent = urg;
        this.status = stat;
    }
    public String getTitle(){
         return this.title;
    }
    public String getPersonName() {
        return this.personName;
    }
    public  int getTime() {
        return this.time;
    }
    public  boolean getImportant() {
        return this.important;
    }
    public  boolean getUrgent() {
        return this.urgent;
    }
    public  String getStatus() {
        return this.status;
    }
    public String setTitle(String change){
         return this.title = change;
    }
    public String setPersonName(String change) {
        return this.personName = change;
    }
    public  int setTime(int change) {
        return this.time = change;
    }
    public  boolean setImportant(Boolean change) {
        return this.important = change;
    }
    public  boolean setUrgent(Boolean change) {
        return this.urgent = change;
    }
    public  String setStatus(String change) {
        return this.status = change;
    }
    public void testTask() {
        System.out.println(getTitle() + ", " + getPersonName() + ", "+getTime()+", "+getImportant()+", "+getUrgent()+", "+getStatus());

    }
}
class Todoist {
    private Task[] task;

    private int size;
    Todoist() {
        task = new Task[size];
    }
    public void addTask(Task t) {
        task[size++] = t;
    }
    public Task getTask(int index) {
        return task[index];
    }
    public String toString() {
        String s ="";
        for (int i =0; i < size; i++) {
            s+=task[i]+"\n";
        }
        return s;
    }
     public void totalTime4Completion() {

    }
    public void getNextTask() {

    }
    public void createTask(){

    }

}

// }
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        //Task obj = new Task();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                // case "add-task":
                //     testAddTask(todo, tokens);
                // break;
                // case "print-todoist":
                //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    // /**
    //  * method to test add task.
    //  *
    //  * @param      todo    The todo
    //  * @param      tokens  The tokens
    //  */
    // public static void testAddTask(final Todoist todo, final String[] tokens) {
    //     try {
    //         todo.addTask(createTask(tokens));


    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        //Task obj = new Task();
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        // return new Task(
        //     title, assignedTo, timeToComplete, important, urgent, status);
        //System.out.println(obj.testTask());
        //return Task();
        //return new Task(obj.getTitle(),obj.getPersonName(),obj.getTime(),obj.getImportant(),obj.getUrgent(),obj.getStatus());

        if (tokens[1].length()==0) {
            throw new Exception("Title not provided");
        }
        if (Integer.parseInt(tokens[3]) < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        }
        if (tokens[6]!="todo" || tokens[6]!="done") {
            throw new Exception("Invalid status "+status);
        }

        return new Task(
                title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
