package principal;
import java.util.Map;
import java.util.Scanner;


public class Project extends Error {
	private String projectName;
	private Category category;
	private String idea;
	private Found found;
	private static Scanner scanner;
	
	
	public Project(String projectName, Category category, String idea, Found found) {
		super();
		this.projectName = projectName;
		this.category = category;
		this.idea = idea;
		this.found = found;
	}

	public Category getCategory() {
		return category;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getIdea(){
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String toString() {
		return this.getProjectName()+"\nIDEIA\n" + this.getIdea();
		
	}
	
	public static Category selectCategory(int choice)
	{
		Category[] allCategory = { Category.ART, Category.COMICS,
				Category.CRAFT,Category.DANCE, Category.DESIGN, Category.FILM, 
				Category.FOOD, Category.GAMES, Category.MUSIC, Category.TECNOLOGY};
		
		return allCategory[choice -1];
				
	}
	
	public static Category askCategory()
	{
		System.out.print("Categoria:\n1 - arte, 2 - quadrinhos, 3 - criação,"
				+ "4 - dança, 5 - designe, 6 - filme, 7 - comida, 8 - jogos,"
				+ "9 - musica, 10 - tecnologia.\n");
		int choice = 0;
		
		do {
			choice = returnInt("Escolha: ");
		}while(choice < 1 || choice > 10);
			
		return selectCategory(choice);
		
	}
	
	public static String askIdea()
	{
		String idea;
		scanner = new Scanner(System.in);
		
		System.out.print("Entre sua ideia: ");
		idea = scanner.nextLine();
		
		return idea;
	}
	
	public static String askProjectName( Map<String,User> listOfUsers)
	{
		scanner = new Scanner(System.in);
		String projectName, tempName = "-";
		System.out.print("Digite o nome do projeto: ");
		projectName = scanner.nextLine();
		
		for (String key : listOfUsers.keySet()) {
			User user = listOfUsers.get(key);
			if(user.getProject() != null) {
				if(projectName.equals(user.getProject().getProjectName()))
					tempName = projectName;
			}
				
		}
		
		while(projectName.equals(tempName))
		{
			System.out.print("Nome de projeto ja existe. Nome: ");
			projectName = scanner.nextLine();
		}
		
		return projectName;
	}
	
	public static Project createProject( Map<String,User> listOfUsers, User loggedUser)
	{
		Category category;
		Project newProject;
		String idea;
		String projectName;
		Found found;

		projectName = askProjectName(listOfUsers);
		category = askCategory();
		idea = askIdea();
		found = Found.createFound();
		newProject = new Project(projectName, category, idea, found);

		return newProject;
	}
	
	public static void searchProject(Map<String,User> listOfUsers)
	{
		System.out.print("MENU DE BUSCA\nEntre o nome do projeto: ");
		int choice;
		double donation, donated;
		Project project = null;
		scanner = new Scanner(System.in);
		String projectName = scanner.nextLine();
		
		for (String key : listOfUsers.keySet()) {
			User user = listOfUsers.get(key);
			
			if(user.getProject() != null)
				if(user.getProject().getProjectName().equals(projectName))
					project = user.getProject();
		}
		
		if(project == null)
			System.out.println("Projeto nao encontrado.");
		else
		{
			project.toString();
			choice = returnInt("Digite 1 para fazer uma doação: ");
			
			if(choice == 1)
			{
				for (int i = 0; i < project.found.getFoundingReward().size(); i++) 
				{
					System.out.println("\nDoando " + project.found.getFounding().get(i) +
						" ou mais.\n" + project.found.getFoundingReward().get(i));
				}
				
				donation = returnDouble("Doar: ");
				donated = project.found.getDonated();
				donated += donation;
				project.found.setDonated(donated);
			}					
		}		
	}
	
}