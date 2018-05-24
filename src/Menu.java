import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> listOfUsers = new ArrayList<User>();
		listOfUsers.add(new User("Victor", "1", "vhla@ic.ufal.br"));
		int choice;
		Project newProject;
		Scanner scanner = new Scanner(System.in);
		
		User loggedUser = null;
		
		do
		{			
			if(loggedUser != null)
			{
				System.out.println("MENU DE USUARIO.\n1 - Criar projeto;\n2 - Buscar projeto"
						+ "\n98 - sair.");
				choice = Error.returnInt("Opcao: ");
//				scanner.nextLine();
				
				switch(choice)
				{
				case 1:
					newProject = Project.createProject(listOfUsers, loggedUser); 
					loggedUser.setProject(newProject);
					break;
				
				case 2:
					listOfUsers = Project.searchProject(listOfUsers);
					break;
				case 98:
					loggedUser = null;
					break;
				}				
			}
			else
			{
				System.out.println("1 - entrar, 2 - cadastrar, 99 - encerrar");
				choice = Error.returnInt("Opcao: ");
			
				switch(choice)
				{
				case 1:
					loggedUser = User.signIn(listOfUsers);
					break;
				case 2:
					listOfUsers = User.signUp(listOfUsers);
					break;
				}
			}

		}while(choice != 99);
		scanner.close();
	}
}