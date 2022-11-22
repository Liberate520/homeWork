package tree;

import classes.Parent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static tree.RelationType.*;

public class FamilyTree {
    private final HashMap<RelationType, ArrayList<Parent>> tree;

    public FamilyTree() {
        this.tree = new HashMap<>();
    }


    public void addMember(RelationType type, Parent member) {
        if (this.tree.containsKey(type)) {
            this.addToValues(type, member);
        } else {
            ArrayList<Parent> values = new ArrayList<>();
            values.add(member);
            this.tree.put(type, values);
        }
    }

    private void addToValues(RelationType type, Parent member) {
        ArrayList<Parent> values = getMember(type);
        values.add(member);
        this.tree.put(type, values);
    }

    public boolean checkMember(RelationType type){
        return this.tree.containsKey(type);
    }

    public void showMember(RelationType type){
        for (Parent person: this.tree.get(type)) {
            System.out.printf("%s:\n", type);
            person.getInfo();
        }
    }

    public void showTree() {
        for (Map.Entry<RelationType, ArrayList<Parent>> item : this.tree.entrySet()) {
            System.out.printf("%s:\n", item.getKey());
            item.getValue().get(0).getInfo();
        }
    }

    public ArrayList<Parent> getMember(RelationType type) {
        return this.tree.get(type);
    }
}
