import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        Human person1 = new Human("05.05.1901", "05.05.1977", "male", "Nicola", "Tesla");
        Human person2 = new Human("05.06.1903", "15.08.1979","female", "Maria", "Tropicana");

        Human person3 = person1.createHuman("05.06.1925", "15.08.1980","male", person2, "Max");
        Human person4 = new Human("06.06.1923", "13.08.1989","female", "Anna", "Verita");
        Human person5 = person3.createHuman("05.06.1930", "15.08.1969", "female", person4, "Giulia");
        Human person6 = person3.createHuman("05.06.1931", "15.08.1979","male", person4, "Alessanro");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);
        System.out.println(person6);
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);
        familyTree.addPerson(person5);
        familyTree.addPerson(person6);
        System.out.println(familyTree.familyTree);

        familyTree.save(familyTree, "src/familyTree.json");

        // загружаем дерево из файла
        FamilyTree loadedTree = new FamilyTree();
        loadedTree.load("src/familyTree.json");
        System.out.println(loadedTree);
    }

}