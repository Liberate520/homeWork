import java.util.List;

public class Main {
	public static void main(String[] args) {
		Person person1 = new Person("Sanni", "Eria", "12.03.1990", "Norway");
		Person person2 = new Person("Lemu", "Eria", "22.07.2020", "Norway");
		Person person3 = new Person("Billy", "Rotten", "17.10.1978","America");
		Person person4 = new Person("Josh", "Rotten", "17.10.1990","America");
		
		Tree tree = new Tree();
		//делаем детей
		tree.addChild(person1, person2);
		tree.addChild(person3, person4);
		
		List<Person> children = tree.getChildren(person1);
		
		for (Person child: children) {
			System.out.println(child.getName() + " " + child.getSurname());
		}
	}
}
