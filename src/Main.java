import person.Gender;
import person.Person;

import javax.print.attribute.standard.Severity;

public class Main {
	public static void main(String[] args) {
		String filePath = "src/familyTree.txt";
		Saveable saveable = new FileHandler();

//		FamilyTree familyTree = (FamilyTree)saveable.load(filePath);
		FamilyTree familyTree = new FamilyTree();
		Service service = new Service(familyTree);
		service.addPerson("Mara", Gender.Female);
		service.addPerson("Zerom", Gender.Male);
		service.addPerson("Miria", Gender.Female, familyTree.getByName("Zerom"), familyTree.getByName("Mara"));
		service.addPerson("Ragnar", Gender.Male, familyTree.getByName("Zerom"), familyTree.getByName("Mara"));
		System.out.println(familyTree);
		service.sortByName();
		System.out.println("Sorted list by name");
		System.out.println(familyTree);
		
//		familyTree.addPerson(new Person("Mara", "Female"));
//		familyTree.addPerson(new Person("Rob", Gender.Male));
//		familyTree.addPerson(new Person("Miria", Gender.Female, familyTree.getByName("Rob"), familyTree.getByName("Mara")));
//		familyTree.addPerson(new Person("Ragnar", Gender.Male, familyTree.getByName("Rob"), familyTree.getByName("Mara")));


//		saveable.save(familyTree, filePath);
//		System.out.println(familyTree.getInfo());
		
	}
}
