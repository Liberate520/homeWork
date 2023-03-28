import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree {
    public static List<Human> humans = new ArrayList<>();
    public static HashMap<String, List<Human>> allRelations(Human human)
    {
        HashMap<String, List<Human>> allRelations = new HashMap<>();
        allRelations.put("бабушки", human.grandMothers());
        allRelations.put("дедушки", human.grandFathers());
        allRelations.put("родители", human.parents());
        allRelations.put("братья и сестры", human.brotherAndSisters());
        allRelations.put("дети", human.childs());
        allRelations.put("внуки", human.grandChildrens());
        allRelations.put("супруг", human.spouse());

        return allRelations;

    }
}
