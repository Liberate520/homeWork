import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HumanListService<T extends Human> {
    FamilyTree<T> familyTree;

    public HumanListService(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByLastName() {       
        List<Map.Entry<String, T>> list =
                new LinkedList<Map.Entry<String, T>>(familyTree.getHumanMap().entrySet());

        Collections.sort(list, new HunamComparatorByLastName<T>());

        Map<String, T> result = new LinkedHashMap<String, T>();
        for (Map.Entry<String, T> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        familyTree.setHumanList(result);
    }

    public void sortByName() {       
        List<Map.Entry<String, T>> list =
                new LinkedList<Map.Entry<String, T>>(familyTree.getHumanMap().entrySet());

        Collections.sort(list, new HunamComparatorByName<T>());

        Map<String, T> result = new LinkedHashMap<String, T>();
        for (Map.Entry<String, T> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        familyTree.setHumanList(result);
    }

    public void sortBySecondName() {       
        List<Map.Entry<String, T>> list =
                new LinkedList<Map.Entry<String, T>>(familyTree.getHumanMap().entrySet());

        Collections.sort(list, new HunamComparatorBySecondName<T>());

        Map<String, T> result = new LinkedHashMap<String, T>();
        for (Map.Entry<String, T> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        familyTree.setHumanList(result);
    }
}
