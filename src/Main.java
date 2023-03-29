import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Human human = new Human("Mary",  1970, 2010);
        Human human1 = new Human("Genry",  1974, 2010);
        Human human2 = new Human("Ivan",  1988);
        Human human3 = new Human("David",  1939, 2000);
        Human human4 = new Human("Anna",  1990);
        Human human5 = new Human("Inga",2014);

       FamilyTree familyTree = new FamilyTree();

       familyTree.addHuman(human);
       familyTree.addHuman(human1);
       familyTree.addHuman(human2);
       familyTree.addHuman(human3);
       familyTree.addHuman(human4);
       familyTree.addHuman(human5);



       System.out.println(human5.relativeLog());

       System.out.println(human4);

       System.out.println(familyTree); // показать все дерево


    }
}
