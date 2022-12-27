package model;

public class FamilyConnection {
    private TreeElement treeElement;
    private FamilyConnectionType connectionType;

    FamilyConnection(TreeElement treeElement, FamilyConnectionType connectionType) {
        this.treeElement = treeElement;
        this.connectionType = connectionType;
    }

    public TreeElement getPerson() {
        return treeElement;
    }

    public FamilyConnectionType getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return "person name = " + treeElement.getName() +
                " - connectionType = " + connectionType;
    }
}
