import java.util.*;
public class Area_of_Cricle
{
	public static void main(String[] args)
	{
		double area, pi = 3.14, radius;
		Scanner scan = new Scanner(System.in);
		radius = scan .nextDouble();
		area = pi*(radius*radius);
		System.out.println(area);
	}
}
