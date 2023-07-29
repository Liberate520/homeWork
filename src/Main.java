package OOP.Less_001.Home_work_less_01;



import OOP.Less_001.Home_work_less_01.Family_tree.Family_tree;
import OOP.Less_001.Home_work_less_01.Gender.Gender;
import OOP.Less_001.Home_work_less_01.Human.Human;

public class Main {
    public static void main(String[] args) {
        Family_tree familyTree = new Family_tree();

        Human human1 = new Human("Irina", Gender.Female);
        Human human2 = new Human("Ivan", Gender.Male);
        Human human3 = new Human("Boris", Gender.Male, human1, human2);
        Human human4 = new Human("John", Gender.Male, human1, human2);

        familyTree.addTree(human1);
        familyTree.addTree(human2);
        familyTree.addTree(human3);
        familyTree.addTree(human4);

        
        System.out.println(familyTree.getInfo());

    }
}
