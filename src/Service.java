import java.util.Collections;

public class Service {
    public static void sortByName(FamilyTree tree){
        Collections.sort(tree.getTreeElements(), new HumanComparatorByName());
    }

    public static void sortByAge(FamilyTree tree){
        Collections.sort(tree.getTreeElements(), new HumanComparatorByAge());
    }
}
