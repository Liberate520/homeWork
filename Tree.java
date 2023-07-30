package homeWork;

import homeWork.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {
    private Map<String, Human> members;

    public Tree() {
        members = new HashMap<>();
    }

    public void addMember(Human human) {
        members.put(human.getName(), human);
    }

    public void addChildToParent(String parentName, Human child) {
        Human parent = members.get(parentName);
        if (parent != null) {
            parent.addChild(child);
        } else {
            System.out.println("Parent not found in the family tree.");
        }
    }

    public Human getMember(String name) {
        return members.get(name);
    }

    public List<Human> findChildren(String name) {
        Human person = members.get(name);
        return (person != null) ? person.getChildren() : null;
    }

    // Additional method to get all members
    public List<Human> getAllMembers() {
        return new ArrayList<>(members.values());
    }
}
