import model.family_tree.CustomFamilyTree;
import model.family_tree.FamilyTree;
import model.person.Person;
import model.serialization.SerializationService;
import view.ConsoleUI;
import view.View;


public class Main {
    public static void main(String[] args) {



//        FamilyTree<Person> familyTree = new CustomFamilyTree().getCustomFamilyTree();
//        System.out.println(familyTree.size());



//        SerializationService ser = new SerializationService();
//        for (Person person : familyTree) {
//            System.out.println(person);
//        }
//        familyTree.sortByName();
//        System.out.println(familyTree);

        View view = new ConsoleUI();
        view.start();
    }
}
