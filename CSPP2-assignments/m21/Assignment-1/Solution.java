import java.util.Scanner;
class Food {
	private String itemName;
	private String quantity;
	private String time;
	private String date;
	Food() {

	}
	Food(String fooditem, String quant, String d, String t) {
		this.itemName = fooditem;
		this.quantity = quant;
		this.date = d;
		this.time = t;
	}
	public String getItemName() {
		return this.itemName;
	}
	public String getQuantity() {
		return this.quantity;
	}
	public String getTime() {
		return this.time;
	}
	public String getFoodDate() {
		return this.date;
	}
	public String toString() {
		return "Date:"+ getFoodDate() +"\n"+ "Time:" + getTime()+"\n" + "Name:" +getItemName() +"\n" + "Quantity" + getQuantity();
	}
}

class Water {
	private String quantity;
	private String date;
	private String time;
	Water() {

	}
	Water(String quant, String d, String t) {
		this.quantity = quant;
		this.date = d;
		this.time = t;
	}
	public String getQuantity() {
		return this.quantity;
	}
	public String getWaterDate() {
		return this.date;
	}
	public String getTime() {
		return this.time;
	}
	public void setQuantity(String change) {
		this.quantity += change;
	}
	public String toString() {
		return "Date:" + getWaterDate() +"\n"+ "Quantity" + getQuantity();
	}
}

class PhysicalActivity {
	private String activityName;
	private String startTime;
	private String endTime;
	private String notes;
	private String date;
	PhysicalActivity(String act,  String note, String d, String st, String et) {
		this.activityName = act;
		this.startTime = st;
		this.endTime = et;
		this.notes = note;
		this.date = d;
	}
	public String getActivityName() {
		return this.activityName;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public String getNotes() {
		return this.notes;
	}
	public String getActivityDate() {
		return this.date;
	}
	public void setNotes(String change) {
		this.notes += change;
	}
	public String toString() {
		return "Name:"+getActivityName()+"\n"+"Notes:"+getNotes()+"\n"+"Date:"+getActivityDate()+"\n"+"Starttime:"+getStartTime()+"\n"+"Endtime:"+getEndTime();
	}
}

class Weight {
	private String kilograms;
	private String fatpercent;
	private String date;
	private String time;
	Weight() {

	}
	Weight(String d,  String t, String kg, String fat) {
		this.kilograms = kg;
		this.fatpercent = fat;
		this.date = d;
		this.time = t;
	}
	public String getKiloGrams() {
		return this.kilograms;
	}
	public String getFatPercent() {
		return this.fatpercent;
	}
	public String getWeightDate() {
		return this.date;
	}
	public String getTime() {
		return this.time;
	}
	public String toString() {
		return "Date:"+getWeightDate()+"\n" + "Time:" +getTime()+"\n" + "Weight:" +getKiloGrams()+"\n" + "Fat:" + getFatPercent();
	}
}

class Sleep {
	private String startTime;
	private String endTime;
	private String date;
	Sleep() {

	}
	Sleep(String d, String sTime, String eTime) {
		this.startTime = sTime;
		this.endTime = eTime;
		this.date = d;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public String getSleepDate() {
		return this.date;
	}
	public String toString() {
		return "Date:"+getSleepDate()+"\n" + "Starttime:" + getStartTime()+"\n" + "Endtime:" + getEndTime();
	}
}

class DailyTracker {
	List <Food> fooddetails;
	List <Water> waterdetails;
	List <PhysicalActivity> activitydetails;
	List <Sleep> sleepdetails;
	List <Weight> weightdetails;
	DailyTracker() {
		fooddetails = new List<Food>();
		waterdetails = new List<Water>();
		activitydetails = new List<PhysicalActivity>();
		sleepdetails = new List<Sleep>();
		weightdetails = new List<Weight>();
	}
	public void addFood(Food fobj) {
		fooddetails.add(fobj);
	}
	public void addWater(Water wobj) {
		waterdetails.add(wobj);
	}
	public void addActivity(PhysicalActivity aobj) {
		activitydetails.add(aobj);
	}
	public void addSleep(Sleep sobj) {
		sleepdetails.add(sobj);
	}
	public void addWeight(Weight weobj) {
		weightdetails.add(weobj);
	}
	public void showAll() {
		//System.out.println("hello");
		getFooddetails();
		getWaterdetails();
		getPhysicalActivitydetails();
		getSleepdetails();
		getWeightdetails();
	}
	public void getFooddetails() {
		if (fooddetails.size() > 0) {
			for (int i = 0; i < fooddetails.size(); i++) {
				System.out.println(fooddetails.get(i).toString());
			}
		} else {
			System.out.println("Food"+"\n"+"None");
		}

	}
	public void getWaterdetails() {
		if (waterdetails.size() > 0) {
			for (int i = 0; i < waterdetails.size(); i++) {
				System.out.println(waterdetails.get(i).toString());
			}
		} else {
			System.out.println("Water"+"\n"+"None");
		}
	}
	public void getPhysicalActivitydetails() {
		if (activitydetails.size() > 0) {
			for (int i = 0; i < activitydetails.size(); i++) {
				System.out.println(activitydetails.get(i).toString());
			}
		} else {
			System.out.println("PhysicalActivity"+"\n"+"None");
		}

	}
	public void getSleepdetails() {
		if (sleepdetails.size() > 0) {
			for (int i = 0; i < sleepdetails.size(); i++) {
				System.out.println(sleepdetails.get(i).toString());
			}
		} else {
			System.out.println("Sleep"+"\n"+"None");
		}

	}
	public void getWeightdetails() {
		if (weightdetails.size() > 0) {
			for (int i = 0; i < weightdetails.size(); i++) {
				System.out.println(weightdetails.get(i).toString());
			}
		} else {
			System.out.println("Weight"+"\n"+"None");
		}

	}
	public void showAll(String summary) {
		for (int i = 0; i < fooddetails.size(); i++) {
			if (summary.equals(fooddetails.get(i).getFoodDate())) {
				System.out.println(fooddetails.get(i).toString());
			}

		}
		for (int i = 0; i < waterdetails.size(); i++) {
			if (summary.equals(waterdetails.get(i).getWaterDate())) {
				System.out.println(waterdetails.get(i).toString());
			}

		}
		for (int i = 0; i < activitydetails.size(); i++) {
			if (summary.equals(activitydetails.get(i).getActivityDate())) {
				System.out.println(activitydetails.get(i).toString());
			}

		}
		for (int i = 0; i < sleepdetails.size(); i++) {
			if (summary.equals(sleepdetails.get(i).getSleepDate())) {
				System.out.println(sleepdetails.get(i).toString());
			}

		}
		for (int i = 0; i < weightdetails.size(); i++) {
			if (summary.equals(weightdetails.get(i).getWeightDate())) {
				System.out.println(weightdetails.get(i).toString());
			}
		}

	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DailyTracker daily = new DailyTracker();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch(tokens[0]) {
				case "Food":
				String[] item = tokens[1].split(",");
				Food fobj = new Food(item[0], item[1], item[2], item[3]);
				daily.addFood(fobj);
				break;
				case "PhysicalActivity":
				item = tokens[1].split(",");
				PhysicalActivity actobj = new PhysicalActivity(item[0], item[1], item[2], item[3], item[4]);
				daily.addActivity(actobj);
				break;
				case "Water":
				item = tokens[1].split(",");
				Water wobj = new Water(item[0], item[1], item[2]);
				daily.addWater(wobj);
				break;
				case "Sleep":
				item = tokens[1].split(",");
				Sleep sobj = new Sleep(item[0], item[1], item[2]);
				daily.addSleep(sobj);
				break;
				case "Weight":
				item = tokens[1].split(",");
				Weight weigh = new Weight(item[0], item[1], item[2], item[3]);
				daily.addWeight(weigh);
				break;
				case "Foodlog":
				System.out.println("Food");
				daily.getFooddetails();
				System.out.println();
				break;
				case "Waterlog":
				System.out.println("Water");
				daily.getWaterdetails();
				System.out.println();
				break;
				case "PhysicalActivitylog":
				System.out.println("PhysicalActivity");
				daily.getPhysicalActivitydetails();
				System.out.println();
				break;
				case "Weightlog":
				System.out.println("Weight");
				daily.getWeightdetails();
				System.out.println();
				break;
				case "Sleeplog":
				System.out.println("Sleep");
				daily.getSleepdetails();
				System.out.println();
				break;
				case "Summary":
				//item = tokens[1].split(",");
				if (tokens.length == 1) {
					daily.showAll();
				} else {
					daily.showAll(tokens[1]);
				}

				break;

			}
 		}
	}
}