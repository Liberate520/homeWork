import java.util.ArrayList;
import java.util.List;

public class Research {
    public static List<Person> getAllChildren(Person person) {
        List<Person> allChildren = new ArrayList<>();
        getAllChildrenRecursive(person, allChildren);
        return allChildren;
    }

    private static void getAllChildrenRecursive(Person person, List<Person> allChildren) {
        List<Person> children = person.getChildren();
        for (Person child : children) {
            allChildren.add(child);
            getAllChildrenRecursive(child, allChildren);
        }
    }
}