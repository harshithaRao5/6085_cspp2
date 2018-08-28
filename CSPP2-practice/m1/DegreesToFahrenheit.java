import java.util.*;
public class DegreesToFahrenheit
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		float celsius = sc.nextFloat();
		float value = 1.8f;
		float fahrenheit = (celsius*(value))+32;
		System.out.println(fahrenheit);
	}
}