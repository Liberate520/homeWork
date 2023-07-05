package homeWork_OOP_family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilywTree implements Serializable{
    // private long humanId;
    private List<Node> familyList;

    public FamilywTree(List<Node> familyList) {
        this.familyList = familyList;
    }

    public FamilywTree() {
        this.familyList = new ArrayList<>();
    }

    public void add(Node human) {
        familyList.add(human);
        // human.people.setId(humanId++);
    }

    public List<Node> searchName(String firstName) {
        List<Node> result = new ArrayList<>();
        for (Node node : familyList) {
            if (node.people.getFirstName() == firstName) {
                result.add(node);
            }
        }
        return result;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(familyList.size());
        sb.append(" объектов: \n");
        for (Node node : familyList) {
            sb.append(node.people.getFirstName());
            sb.append("\n");
        }
        return sb.toString();
    }
}