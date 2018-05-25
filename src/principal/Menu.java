package principal;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public abstract class Menu extends Error{

	static Map<String,User> listOfUsers = new HashMap<String,User>();
	private static Scanner scanner;
	
	public static void userMenu(User loggedUser) {
		int choice =0;
		do {
			System.out.println("MENU DE USUARIO.\n1 - Criar projeto;\n2 - Buscar projeto"
					+ "\n98 - sair.");
			choice = returnInt("Opcao: ");
			
			switch(choice){
				case 1:
					Project newProject = Project.createProject(listOfUsers, loggedUser); 
					loggedUser.setProject(newProject);
					break;
				
				case 2:
					Project.searchProject(listOfUsers);
					break;
					
				case 98:
					return;
			}	
		} while(choice!=98);
	}
	
	public static User signIn( Map<String,User> listOfUsers)
	{
		scanner = new Scanner(System.in);
		String email, password;
		
		System.out.print("Email: ");
		email = scanner.nextLine();
		System.out.print("Senha: ");
		password = scanner.nextLine();
		
		if(listOfUsers.containsKey(email)) {
				if(listOfUsers.get(email).getPassword().equals(password))
					return listOfUsers.get(email);	
		}
		
		
		System.out.println("Email ou senha não confere.");
			return null;
	
	}
	
	public static void signUp(Map<String,User> listOfUsers)
	{
		System.out.println("MENU DE CADASTRO");
		String email, name, password;
		User newUser;
		
		email = askEmail(listOfUsers);
		name = askName();
		password = askPassword();
		
		newUser = new User(name, password, email);
		listOfUsers.put(email,newUser);
		
	}
	
	private static String askName()
	{
		scanner = new Scanner(System.in);
		System.out.print("Nome: ");
		String name = scanner.nextLine();		
		
		return name;
	}

	private static String askPassword()
	{
		 scanner = new Scanner(System.in);
		System.out.print("Senha: ");
		String password = scanner.nextLine();		
		
		return password;
	}
	
	private static String askEmail(Map<String,User> listOfUsers)
	{
		scanner = new Scanner(System.in);
		String email;
		System.out.print("Email: ");
		email = scanner.nextLine();
		
		while(listOfUsers.containsKey(email))
		{
			System.out.print("Email ja existe.\nEmail: ");
			email = scanner.nextLine();
		}
		
		return email;
	}
}