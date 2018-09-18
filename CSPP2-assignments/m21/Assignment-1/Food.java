class Food {
	private String itemName;
	private String quantity;
	private String time;
	Food() {

	}
	Food(String fooditem, String quant, String t) {
		this.itemName = fooditem;
		this.quantity = quant;
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
}

class Water {
	private String quantity;
	Water() {

	}
	Water(String quant) {
		this.quantity = quant;
	}
	public String getQuantity() {
		return this.quantity;
	}
	public void setQuantity(String change) {
		this.quantity += change;
	}
}

class PhysicalActivity {
	private String activityName;
	private String startTime;
	private String endTime;
	private String notes;
	PhysicalActitvity(String act, String st, String et, String note) {
		this.activityName = act;
		this.startTime = st;
		this.endTime = et;
		this.notes = note;
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
	public void setNotes(String change) {
		this.notes += change;
	}
}

class Weight {
	private int kilograms;
	private float fatpercent;
	Weight() {

	}
	Weight(int kg, float fat) {
		this.kilograms = kg;
		this.fatpercent = fat;
	}
	public int getKiloGrams() {
		return this.kilograms;
	}
	public float getFatPercent() {
		return this.fatpercent;
	}

}

class Sleep {
	private String startTime;
	private String endTime;
	Sleep() {

	}
	Sleep(String sTime, String eTime) {
		this.startTime = sTime;
		this.endTime = eTime;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
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
	public void weightdetails(Weight weobj) {
		weightdetails.add(weobj);
	}

}
