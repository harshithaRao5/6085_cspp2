import java.util.*;

class Task{
	private static String title;
	private static String personName;
	private static int time;
	private static String important;
	private static String urgent;
	private static String status;
	Task(String task, String name, int t, String imp, String urg, String stat) {
		this.title = task;
		this.personName = name;
		this.time = t;
		this.important = imp;
		this.urgent = urg;
		this.status = stat;
	}
	public static String getTitle(){
		 return title;
	}
	public static String getPersonName() {
		return personName;
	}
	public static int getTime() {
		return time;
	}
	public static String getImportant() {
		boolean y = true;
		if (y) {
			return "Important";
		} else {
			return "Not Important";
		}
	}
	public static String getUrgent() {
		boolean y = true;
		if (y) {
			return "Urgent";
		} else {
			return "Not Urgent";
		}
	}
	public static String getStatus() {
		return status;
	}
	public void showAll() {
		System.out.println(getTitle()+", "+getPersonName()+", "+getTime()+", "+getImportant()+", "+getUrgent()+", "+getStatus());
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch(tokens[0]) {
				case "task":
				String[] item = tokens[1].split(",");
				Task tobj = new Task(tokens[0],item[0], item[1], Integer.parseInt(item[2]), item[3],item[4],item[5]);
				break;
			}
		}
	}
}