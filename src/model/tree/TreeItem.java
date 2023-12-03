package model.tree;

public interface TreeItem {
    String getName();
    String getSurname();
    void setId(int i);
    int getId();
    String getParents();
    String getChildren();
}
