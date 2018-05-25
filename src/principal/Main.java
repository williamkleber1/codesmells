package principal;


public class Main extends Menu {
	
public static void main(String[] args) {
		
		User user1 = new User("Victor", "1", "vhla@ic.ufal.br");
		listOfUsers.put("vhla@ic.ufal.br",user1);
	

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
					signUp(listOfUsers);
					break;
			}
			
			

		}	while(choice != 99);

	}
	

}
