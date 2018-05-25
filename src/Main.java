import java.util.Scanner;

public class Main extends Menu {
	
public static void main(String[] args) {
		
		
		listOfUsers.add(new User("Victor", "1", "vhla@ic.ufal.br"));
	
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do
		{			
			System.out.println("1 - entrar, 2 - cadastrar, 99 - encerrar");
			choice = returnInt("Opcao: ");
		
			switch(choice)
			{
				case 1:
					User loggedUser = signIn(listOfUsers);
					userMenu(loggedUser);
					break;
				case 2:
					listOfUsers = signUp(listOfUsers);
					break;
			}
			
			

		}	while(choice != 99);
		scanner.close();
	}
	

}
