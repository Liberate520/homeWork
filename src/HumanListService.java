import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HumanListService {
    FamilyTree familyTree;

    public HumanListService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByLastName() {       
        List<Map.Entry<String, Human>> list =
                new LinkedList<Map.Entry<String, Human>>(familyTree.getHumanMap().entrySet());

        Collections.sort(list, new HunamComparatorByLastName());

        Map<String, Human> result = new LinkedHashMap<String, Human>();
        for (Map.Entry<String, Human> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        familyTree.setHumanList(result);
    }

    public void sortByName() {       
        List<Map.Entry<String, Human>> list =
                new LinkedList<Map.Entry<String, Human>>(familyTree.getHumanMap().entrySet());

        Collections.sort(list, new HunamComparatorByName());

        Map<String, Human> result = new LinkedHashMap<String, Human>();
        for (Map.Entry<String, Human> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        familyTree.setHumanList(result);
    }

    public void sortBySecondName() {       
        List<Map.Entry<String, Human>> list =
                new LinkedList<Map.Entry<String, Human>>(familyTree.getHumanMap().entrySet());

        Collections.sort(list, new HunamComparatorBySecondName());

        Map<String, Human> result = new LinkedHashMap<String, Human>();
        for (Map.Entry<String, Human> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        familyTree.setHumanList(result);
    }
}
