import java.util.*;
class Student {
	static String name;
	static String rollnumber;
	static double grade1, grade2, grade3;
	public Student(String name, String rollnumber, double grade1, double grade2, double grade3) {
		this.name = name;
		this.rollnumber = rollnumber;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
	}
	double gpa() {
		double gpa = (grade1+grade2+grade3)/3.0D;
		return gpa;
	}
}
public class StudentDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String rollnumber = sc.next();
		double grade1 = sc.nextDouble();
		double grade2 = sc.nextDouble();
		double grade3 = sc.nextDouble();
		Student s = new Student(name, rollnumber, grade1, grade2, grade3);
		System.out.format("%.1f",s.gpa());
	}
}
