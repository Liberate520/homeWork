import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FamilyTree implements Serializable{
    private Map<Person, List<Person>> familyTree;

    public FamilyTree() {
        this.familyTree = new HashMap<>();
    }

    public void addParent(Person parent) {
        familyTree.put(parent, new ArrayList<>());
    }

    public void addChild(Person parent, Person child) {
        if (familyTree.containsKey(parent)) {
            familyTree.get(parent).add(child);
        }
    }

    public static String getValueByKey(Map<String, String> hashMap, String key) {
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        } else {
            return null;
        }
    }

    public void getFamily(Person parent) {
        if (familyTree.containsKey(parent) && familyTree.get(parent) != null) {
            Object value = familyTree.get(parent);
            System.out.println("Родитель: " + parent + " -> дети:" + value);
        } else
            System.out.println("У данного человека нет детей!");
    }
    
}