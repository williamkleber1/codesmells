import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class Error {
	
	private static Scanner scanner;

	public static int returnInt(String value)
	{
		scanner = new Scanner(System.in);
		int choice;
		while(true)
		{
			try
			{
				System.out.print(value);
				choice = scanner.nextInt();
				break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Utilize apenas inteiros.");
				scanner.nextLine();
			}
		}
		
		return choice;	
	}
	
	public static double returnDouble(String value)
	{
		scanner = new Scanner(System.in);
		double choice;
		while(true)
		{
			try
			{
				System.out.print(value);
				choice = scanner.nextDouble();
				break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Utilize apenas numeros.");
				scanner.nextLine();
			}
		}
		
		return choice;	
	}
}
