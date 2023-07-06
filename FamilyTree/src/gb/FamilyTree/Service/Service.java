package gb.FamilyTree.Service;

import gb.FamilyTree.Node.RelativeNode.RelativeNode;
import gb.FamilyTree.Tree.Relations;
import gb.FamilyTree.Tree.Tree;
import gb.FamilyTree.TreeSerializer.TreeSerializer;

public class Service {
    private Tree familyTree;
    private int nodeId;

    public Service() {
        familyTree = new Tree();
    }

    public RelativeNode createNode(
            String lastName,
            String firstName,
            String middleName,
            String birthDate,
            String deathDate) {
        return new RelativeNode(++nodeId, lastName, firstName, middleName, birthDate, deathDate);
    }

    public RelativeNode createNode(
            String lastName,
            String firstName,
            String middleName) {
        return new RelativeNode(++nodeId, lastName, firstName, middleName);
    }

    public void addNodeToTree(RelativeNode node) {
        familyTree.addNode(node);
    }

    public void addNodeToTree(
            RelativeNode addingNode,
            RelativeNode nodeToBeAdded,
            Relations relation) {
        familyTree.addNode(addingNode, nodeToBeAdded, relation);
    }

    public String getTree() {
        return familyTree.toString();
    }

    public RelativeNode getNode(int id) {
        return familyTree.getNode(id);
    }

    public void saveTree(String filePath) {
        TreeSerializer serializer = new TreeSerializer(filePath);
        serializer.writeToFile(familyTree);
    }

    public Tree readTree(String filePath) {
        TreeSerializer deserializer = new TreeSerializer(filePath);
        familyTree = (Tree) deserializer.readFromFile();
        return familyTree;
    }
}
