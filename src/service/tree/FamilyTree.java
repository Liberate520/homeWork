package service.tree;

import service.classes.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Класс предоставляющий объекты семейного дерева
 */
public class FamilyTree implements Serializable {
    private final HashMap<RelationType, ArrayList<Integer>> tree;

    public FamilyTree() {
        this.tree = new HashMap<>();
    }


    public void addMember(RelationType type, Integer memberIndex) {
        if (this.tree.containsKey(type)) {
            this.addToValues(type, memberIndex);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(memberIndex);
            this.tree.put(type, values);
        }
    }

    private void addToValues(RelationType type, Integer member) {
        ArrayList<Integer> values = getMember(type);
        values.add(member);
        this.tree.put(type, values);
    }

    public boolean checkMember(RelationType type) {
        return this.tree.containsKey(type);
    }

    public void showMember(RelationType type) {
        for (Integer personIndex : this.tree.get(type)) {
            System.out.printf("%s:\n", type);
            System.out.println(personIndex.toString());
        }
    }

    public void showTree() {
        for (Map.Entry<RelationType, ArrayList<Integer>> item : this.tree.entrySet()) {
            System.out.printf("%s:\n", item.getKey());
            System.out.println(item.getValue().get(0).toString());;
        }
    }

    public HashMap<RelationType, ArrayList<Integer>> getTree() {
        return this.tree;
    }

    public ArrayList<Integer> getMember(RelationType type) {
        return this.tree.get(type);
    }
}
