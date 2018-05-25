import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public abstract class Menu extends Error{

	public static ArrayList<User> listOfUsers = new ArrayList<User>();
	private static Scanner scanner;
	
	public static void userMenu(User loggedUser) {
		
		System.out.println("MENU DE USUARIO.\n1 - Criar projeto;\n2 - Buscar projeto"
				+ "\n98 - sair.");
		int choice = returnInt("Opcao: ");
		
		switch(choice){
			case 1:
				Project newProject = Project.createProject(listOfUsers, loggedUser); 
				loggedUser.setProject(newProject);
				break;
			
			case 2:
				listOfUsers = Project.searchProject(listOfUsers);
				break;
				
			case 98:
				return;
		}	
	}
	
	public static User signIn( ArrayList<User> listOfUsers)
	{
		scanner = new Scanner(System.in);
		String email, password;
		
		System.out.print("Email: ");
		email = scanner.nextLine();
		System.out.print("Senha: ");
		password = scanner.nextLine();
		
		for (User user : listOfUsers) {
			if(user.getEmail().equals(email))
			{
				if(user.getPassword().equals(password))
					return user;	
			}
		}
		
		System.out.println("Email ou senha não confere.");
		return null;
	}
	
	public static ArrayList<User> signUp(ArrayList<User> listOfUsers)
	{
		System.out.println("MENU DE CADASTRO");
		String email, name, password;
		User newUser;
		
		email = askEmail(listOfUsers);
		name = askName();
		password = askPassword();
		
		newUser = new User(name, password, email);
		listOfUsers.add(newUser);
		
		return listOfUsers;
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
	
	private static String askEmail(ArrayList<User> listOfUsers)
	{
		scanner = new Scanner(System.in);
		String email, tempEmail = "0";
		System.out.print("Email: ");
		email = scanner.nextLine();
		
		for (User user : listOfUsers) {
			if(user.getEmail().equals(email))
				tempEmail = email;
		}
		
		while(email.equals(tempEmail))
		{
			System.out.print("Email ja existe.\nEmail: ");
			email = scanner.nextLine();
		}
		
		return email;
	}
}