import person.Gender;
import presenter.Presenter;
import service.Service;
import tree.FamilyTree;
import ui.Console;
import ui.View;
import write_read.FileHandler;
import write_read.Saveable;

public class Main {
	public static void main(String[] args) {
		String filePath = "src/familyTree.txt";
		Saveable saveable = new FileHandler();

//		tree.FamilyTree familyTree = (tree.FamilyTree)saveable.load(filePath);
		FamilyTree familyTree = new FamilyTree();
		Service service = new Service(familyTree);
//		service.addPerson("Mara", Gender.Female);
//		service.addPerson("Zerom", Gender.Male);
//		service.addPerson("Miria", Gender.Female, familyTree.getByName("Zerom"), familyTree.getByName("Mara"));
//		service.addPerson("Ragnar", Gender.Male, familyTree.getByName("Zerom"), familyTree.getByName("Mara"));
//		System.out.println(familyTree);
//		service.sortByName();
//		System.out.println("Sorted list by name: ");
//		System.out.println(familyTree);
		View view = new Console();
		Presenter presenter = new Presenter(view, service);
		view.start();
		
//		saveable.save(familyTree, filePath);
//		System.out.println(familyTree.getInfo());

	}
}
