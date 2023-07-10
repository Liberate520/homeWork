import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Node root;

    public FamilyTree(Node root) {
        this.root = root;
    }

    public void addPerson(Human person, Node parentNode) {
        Node newNode = new Node(person, null, null);
        parentNode.addChild(newNode);
    }

    public List<Human> getAllChildren(Human person) {
        List<Human> allChildren;
        allChildren = new ArrayList<>();
        getAllChildrenRecursive(root, allChildren, person);
        return allChildren;
    }

    private void getAllChildrenRecursive(Node currentNode, List<Human> allChildren, Human person) {
        if (currentNode.getHuman().equals(person)) {
            List<Node> children = currentNode.getChildren();
            for (Node childNode : children) {
                allChildren.add(childNode.getHuman());
                getAllChildrenRecursive(childNode, allChildren, person);
            }
        } else {
            List<Node> children = currentNode.getChildren();
            for (Node childNode : children) {
                getAllChildrenRecursive(childNode, allChildren, person);
            }
        }
    }
}