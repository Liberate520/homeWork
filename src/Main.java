import family_tree.CustomFamilyTree;
import family_tree.FamilyTree;
import person.Person;


public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new CustomFamilyTree().getCustomFamilyTree();
        for (Person person : familyTree) {
            System.out.println(person);
        }
        familyTree.sortByName();
        System.out.println(familyTree);
    }
}
