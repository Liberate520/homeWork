import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree {
    public static List<Human> humans = new ArrayList<>();
    public static HashMap<String, List<Human>> AllRelations(Human human)
    {
        HashMap<String, List<Human>> AllRelations = new HashMap<>();
        AllRelations.put("бабушки", human.grandMothers());
        AllRelations.put("дедушки", human.grandFathers());
        AllRelations.put("родители", human.parents());
        AllRelations.put("братья и сестры", human.brotherAndSisters());
        AllRelations.put("дети", human.childs());
        AllRelations.put("внуки", human.grandChildrens());
        AllRelations.put("супруг", human.spouse());

        return AllRelations;

    }
}
