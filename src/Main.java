
public class Main {
	public static void main(String[] args) {
		String filePath = "src/tree.txt";
		Saveable saveable = new FileHandler();

		Tree tree = (Tree)saveable.load(filePath);
//		Tree tree = new Tree();
//
//		tree.addPerson(new Person("Mara", Gender.Female));
//		tree.addPerson(new Person("Rob", Gender.Male));
//		tree.addPerson(new Person("Miria", Gender.Female, tree.getByName("Rob"), tree.getByName("Mara")));
//		tree.addPerson(new Person("Ragnar", Gender.Male, tree.getByName("Rob"), tree.getByName("Mara")));
//
//
//		saveable.save(tree, filePath);
		System.out.println(tree.getInfo());
		

	}
}
