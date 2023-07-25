import enums.Gender;
import interfaces.Writable;
import treeWorkspace.FamilyTree;
import treeWorkspace.Person;
import treeWorkspace.RecordTree;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Александр", Gender.Male, null, null);
        Person p2 = new Person("Александра", Gender.Female, null, null);
        Person p3 = new Person("Олег", Gender.Male, p2, p1);
        Person p4 = new Person("Петр", Gender.Male, p2, p1);
        FamilyTree tree = new FamilyTree();
        tree.setPerson(p1, p2, p3, p4);
        // Демонстрация чтения и записи
        Writable write = new RecordTree();
        write.saveTree(tree, ".//src//SavedTrees//treeWorkspace.FamilyTree.bin");
        write.loadTree(".//src//SavedTrees//treeWorkspace.FamilyTree.bin");
    }
}
