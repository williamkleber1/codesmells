import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	private String name;
	private String password;
	private String email;
	private Project project;
	
	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Project getProject() 
	{
		return project;
	}

	public void setProject(Project project) 
	{
		this.project = project;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	private static String askEmail(ArrayList<User> listOfUsers)
	{
		Scanner scanner = new Scanner(System.in);
		String email, tempEmail = "0";
		System.out.print("Email: ");
		email = scanner.nextLine();
		
		for (User user : listOfUsers) {
			if(user.email.equals(email))
				tempEmail = email;
		}
		
		while(email.equals(tempEmail))
		{
			System.out.print("Email ja existe.\nEmail: ");
			email = scanner.nextLine();
		}
		
//		scanner.close();
		return email;
	}
	
	private static String askName()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nome: ");
		String name = scanner.nextLine();		
		
//		scanner.close();
		return name;
	}

	private static String askPassword()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Senha: ");
		String password = scanner.nextLine();		
		
//		scanner.close();
		return password;
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
	
	public static User signIn( ArrayList<User> listOfUsers)
	{
		Scanner scanner = new Scanner(System.in);
		String email, password;
		
		System.out.print("Email: ");
		email = scanner.nextLine();
		System.out.print("Senha: ");
		password = scanner.nextLine();
		
		for (User user : listOfUsers) {
			if(user.email.equals(email))
			{
				if(user.password.equals(password))
				{
				//	scanner.close();
					return user;	
				}
			}
		}
		
		System.out.println("Email ou senha não confere.");
//		scanner.close();
		return null;
	}
}
