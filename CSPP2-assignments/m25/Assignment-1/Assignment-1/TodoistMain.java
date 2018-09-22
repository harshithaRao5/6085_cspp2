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
    Task(String task, String name, int t, boolean imp, boolean urg, String stat)throws Exception {
        if (name.length() == 0) {
            throw new Exception("Title not provided");
        } else {
             this.title = task;
        }

        this.personName = name;
        if (t < 0) {
            throw new Exception("Invalid timeToComplete "+this.time);
        } else {
            this.time = t;
        }

        this.important = imp;
        this.urgent = urg;
        if (stat!="todo" || stat !="done") {
            throw new Exception("Invalid status "+this.status);
        } else {
            this.status = stat;
        }

        // if (this.title == null) {
        //     throw new Exception("Title not provided");
        // }
        // if (this.time < 0) {
        //     throw new Exception("Invalid timeToComplete "+this.time);
        // }
        // if (this.status!="todo" || this.status!="done") {
        //     throw new Exception("Invalid status "+this.status);
        // }
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
    public String getImpStatus() {
        if(this.important==true) {
            return "Important";
        } else {
            return "Not Important";
        }
    }
    public String getUrgStat() {
        if(this.urgent == true) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }
    public String toString() {
        return getTitle() + ", " + getPersonName() + ", "+getTime()+", "+getImpStatus()+", "+getUrgStat()+", "+getStatus();

    }
}
class Todoist {
    //private final int hundered = 100;
    private List<Task> task;
    //private int size;
    Todoist() {
        task = new List<Task>();
    }
    public void addTask(Task t) {
        task.add(t);
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < task.size(); i++) {
            s += task.get(i).toString() + "\n";
        }
        return s;
    }
    public Task getNextTask(String name) {
        for (int i = 0; i < task.size(); i++) {
            if (name.equals(task.get(i).getPersonName())) {
                if ("todo".equals(task.get(i).getStatus()) && ("Important".equals(task.get(i).getImpStatus()))
                    && ("Urgent".equals(task.get(i).getUrgStat()))){
                            return task.get(i);
                        } else if ("todo".equals(task.get(i).getStatus()) && ("Important".equals(task.get(i).getImpStatus()))
                        && ("Not Urgent".equals(task.get(i).getUrgStat()))){
                            return task.get(i);
                        }
                    }
                }
        return null;
    }
    public List getNextTask(String name, int count) {
        List<String> nextArray = new List<String>();
        for (int i = 0; i < task.size(); i++) {
            for (int j = 0; j < count; j++) {
            if (name.equals(task.get(i).getPersonName())) {
                if ("todo".equals(task.get(i).getStatus())
                    && ("Important".equals(task.get(i).getImpStatus()))
                    && ("Not Urgent".equals(task.get(i).getUrgStat()))) {
                    nextArray.add(task.get(i).toString());
                }
                }
                    }
                }
                return nextArray;
    }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    //Task[] tasks = todo.getNextTask(tokens[1], n);
                    //System.out.println(Arrays.deepToString(tasks));
                    System.out.println(todo.getNextTask(tokens[1], n));
                break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                //break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        //int len = tokens[1].length();
        // if (title.length() == 0) {
        //     throw new Exception("Title not provided");
        // }
        // //int len1 = Integer.parseInt(tokens[3]);
        // if (timeToComplete < 0) {
        //     throw new Exception("Invalid timeToComplete "+ timeToComplete);
        // }
        // //String ref3 = tokens[6];
        // if (!status.equals("todo") || !status.equals("done")) {
        //     throw new Exception("Invalid status "+ status);
        // }
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
