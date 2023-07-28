package homeWork;

import homeWork.Tree;

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

    public Human getMember(String name) {
        return members.get(name);
    }

    public List<Human> findChildren(String name) {
        Human person = members.get(name);
        return (person != null) ? person.getChildren() : null;
    }
}
