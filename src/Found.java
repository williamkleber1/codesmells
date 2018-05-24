import java.util.ArrayList;
import java.util.Scanner;

public class Found {
	private double goal;
	private double donated;
	private ArrayList<Double> founding;
	private ArrayList<String> foundingReward;
	
	public Found(double goal, double donated, ArrayList<Double> founding,
			ArrayList<String> foundingReward) 
	{
		super();
		this.goal = goal;
		this.donated = donated;
		this.founding = founding;
		this.foundingReward = foundingReward;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public double getDonated() {
		return donated;
	}

	public void setDonated(double donated) {
		this.donated = donated;
	}

	public ArrayList<String> getFoundingReward() {
		return foundingReward;
	}

	public void setFoundingReward(ArrayList<String> foundingReward) {
		this.foundingReward = foundingReward;
	}
	
	public ArrayList<Double> getFounding() 
	{
		return founding;
	}

	public void setFounding(ArrayList<Double> founding) {
		this.founding = founding;
	}

	public static Found createFound()
	{
		ArrayList<Double> found = new ArrayList<Double>();
		ArrayList<String> foundingReward = new ArrayList<String>();
		double donated = 0.0, goal, value;
		Found newFound;		
		int choice;
		Scanner scanner = new Scanner(System.in);
		String description;
		
		goal = Error.returnDouble("Entre com a meta de arrecadacao: ");
		
		System.out.println("Entre com as recompensas.");
		
		while(true)
		{
			value = Error.returnDouble("Valor: ");
			scanner.nextLine();
			
			System.out.println("Descreva a recompensa: ");
			description = scanner.nextLine();
			
			found.add(value);
			foundingReward.add(description);
			
			System.out.print("Digite 1 para encerrar: ");
			choice = scanner.nextInt();
			
			if (choice == 1) 
				break;					
		}
		
		newFound = new Found(goal, donated, found, foundingReward);

		return newFound;
	}
}
