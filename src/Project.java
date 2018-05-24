import java.util.ArrayList;
import java.util.Scanner;


public class Project {
	private String projectName;
	private Category category;
	private String idea;
	private Found found;
	
	public Project(String projectName, Category category, String idea, Found found) 
	{
		super();
		this.projectName = projectName;
		this.category = category;
		this.idea = idea;
		this.found = found;
	}

	public Category getCategory() 
	{
		return category;
	}

	public String getProjectName() 
	{
		return projectName;
	}

	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}

	public String getIdea()
	{
		return idea;
	}

	public void setIdea(String idea) 
	{
		this.idea = idea;
	}

	public static Category askCategory()
	{
		Category category;
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		while(true)
		{
			System.out.print("Categoria:\n1 - arte, 2 - quadrinhos, 3 - criação,"
					+ "4 - dança, 5 - designe, 6 - filme, 7 - comida, 8 - jogos,"
					+ "9 - musica, 10 - tecnologia.\n");
			choice = Error.returnInt("Escolha: ");
			
			if(choice == 1)
			{
				category = Category.ART;
				break;
			}
			else if(choice == 2)
			{
				category = Category.COMICS;
				break;
			}
			else if(choice == 3)
			{
				category = Category.CRAFT;
				break;
			}
			else if(choice == 4)
			{
				category = Category.DANCE;
				break;
			}
			else if(choice == 5)
			{
				category = Category.DESIGN;
				break;
			}
			else if(choice == 6)
			{
				category = Category.FILM;
				break;
			}
			else if(choice == 7)
			{
				category = Category.FOOD;
				break;
			}	
			else if(choice == 8)
			{
				category = Category.GAMES;
				break;
			}	
			else if(choice == 9)
			{
				category = Category.MUSIC;
				break;
			}	
			else if(choice == 10)
			{
				category = Category.TECNOLOGY;
				break;
			}
			
		}
		
		return category;
	}
	
	public static String askIdea()
	{
		String idea;
		Scanner	scanner = new Scanner(System.in);
		
		System.out.print("Entre sua ideia: ");
		idea = scanner.nextLine();
		
		return idea;
	}
	
	public static String askProjectName(ArrayList<User> listOfUsers)
	{
		Scanner scanner = new Scanner(System.in);
		String projectName, tempName = "-";
		System.out.print("Digite o nome do projeto: ");
		projectName = scanner.nextLine();
		
		for (User user : listOfUsers) {
			if(user.getProject() != null)
				if(projectName.equals(user.getProject().getProjectName()))
					tempName = projectName;
		}
		
		while(projectName.equals(tempName))
		{
			System.out.print("Nome de projeto ja existe. Nome: ");
			projectName = scanner.nextLine();
		}
		
		return projectName;
	}
	
	public static Project createProject(ArrayList<User> listOfUsers, User loggedUser)
	{
		Category category;
		Project newProject;
		Scanner scanner = new Scanner(System.in);
		String idea;
		String projectName;
		Found found;

		projectName = askProjectName(listOfUsers);
		category = askCategory();
		idea = askIdea();
		found = Found.createFound();
		newProject = new Project(projectName, category, idea, found);
		
//		scanner.close();
		return newProject;
	}
	
	public static ArrayList<User> searchProject(ArrayList<User> listOfUsers)
	{
		System.out.print("MENU DE BUSCA\nEntre o nome do projeto: ");
		int choice;
		double donation, donated;
		Project project = null;
		Scanner scanner = new Scanner(System.in);
		String projectName = scanner.nextLine();
		
		for (User user : listOfUsers) {
			if(user.getProject() != null)
				if(user.getProject().getProjectName().equals(projectName))
				{
					project = user.getProject();
				}
		}
		
		if(project == null)
			System.out.println("Projeto nao encontrado.");
		else
		{
			System.out.println(project.getProjectName());
			System.out.println("\nIDEIA\n" + project.getIdea());
			choice = Error.returnInt("Digite 1 para fazer uma doação: ");
			
			if(choice == 1)
			{
				for (int i = 0; i < project.found.getFoundingReward().size(); i++) 
				{
					System.out.println("\nDoando " + project.found.getFounding().get(i) +
						" ou mais.\n" + project.found.getFoundingReward().get(i));
				}
				
				donation = Error.returnDouble("Doar: ");
				donated = project.found.getDonated();
				donated += donation;
				project.found.setDonated(donated);
			}					
		}		
		return listOfUsers;
	}
	
}