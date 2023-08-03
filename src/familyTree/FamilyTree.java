import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

class FamilyTree implements Serializable, Iterable<Map.Entry<Parent, List<Parent>>>{
    private Map<Parent, List<Parent>> familyTree;

    public FamilyTree() {
        this.familyTree = new HashMap<>();
    }

    public void addParent(Parent parent) {
        familyTree.put(parent, new ArrayList<>());
    }

    public void addChild(Parent parent, Parent child) {
        if (familyTree.containsKey(parent)) {
            familyTree.get(parent).add(child);
        }
    }

    public void getFamily(Parent parent) {
        if (familyTree.containsKey(parent) && familyTree.get(parent) != null) {
            Object value = familyTree.get(parent);
            System.out.println("Родитель: " + parent + " -> дети:" + value);
        } else
            System.out.println("У данного человека нет детей!");
    }

    public void getFamilyInfo() {
        Iterable<Map.Entry<Parent, List<Parent>>> iterable = familyTree.entrySet();
        for (Map.Entry<Parent, List<Parent>> entry : iterable) {
            Parent key = entry.getKey();
            List<Parent> value = entry.getValue();
            System.out.println("Родитель: " + key + ", Дети: " + value);
        }
        System.out.println("\n");
    }

public Map<Parent, List<Parent>> sortMapWithComparatorByName() {
        Map<Parent, List<Parent>> sortedMap = new HashMap<>();
        List<Parent> parents = new ArrayList<>();
        Iterable<Map.Entry<Parent, List<Parent>>> iterable = familyTree.entrySet();
        for (Map.Entry<Parent, List<Parent>> entry : iterable) {
            Parent key = entry.getKey();
            parents.add(key);
        }

        parents.sort(new ComparatorByName());

        for (Parent parent : parents) {
            sortedMap.put(parent, new ArrayList<>());
        }
        sortedMap.putAll(familyTree);
        return sortedMap;
    }

public Map<Parent, List<Parent>> sortMapWithComparatorByAge() {
        Map<Parent, List<Parent>> sortedMap = new HashMap<>();
        List<Parent> parents = new ArrayList<>();
        Iterable<Map.Entry<Parent, List<Parent>>> iterable = familyTree.entrySet();
        for (Map.Entry<Parent, List<Parent>> entry : iterable) {
            Parent key = entry.getKey();
            parents.add(key);
        }

        parents.sort(new ComparatorByAge());

        for (Parent parent : parents) {
            sortedMap.put(parent, new ArrayList<>());
        }
        sortedMap.putAll(familyTree);
        return sortedMap;
    }

    @Override
    public Iterator<Entry<Parent, List<Parent>>> iterator() {
        return familyTree.entrySet().iterator();
    }
}