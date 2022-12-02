package service.tree;

import service.classes.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree implements Serializable {
    private final HashMap<RelationType, ArrayList<Person>> tree;

    public FamilyTree() {
        this.tree = new HashMap<>();
    }


    public void addMember(RelationType type, Person member) {
        if (this.tree.containsKey(type)) {
            this.addToValues(type, member);
        } else {
            ArrayList<Person> values = new ArrayList<>();
            values.add(member);
            this.tree.put(type, values);
        }
    }

    private void addToValues(RelationType type, Person member) {
        ArrayList<Person> values = getMember(type);
        values.add(member);
        this.tree.put(type, values);
    }

    public boolean checkMember(RelationType type) {
        return this.tree.containsKey(type);
    }

    public void showMember(RelationType type) {
        for (Person person : this.tree.get(type)) {
            System.out.printf("%s:\n", type);
            person.getInfo();
        }
    }

    public void showTree() {
        for (Map.Entry<RelationType, ArrayList<Person>> item : this.tree.entrySet()) {
            System.out.printf("%s:\n", item.getKey());
            item.getValue().get(0).getInfo();
        }
    }

    public HashMap<RelationType, ArrayList<Person>> getTree() {
        return this.tree;
    }

    public ArrayList<Person> getMember(RelationType type) {
        return this.tree.get(type);
    }
}
