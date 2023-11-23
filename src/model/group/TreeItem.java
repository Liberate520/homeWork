package model.group;

public interface TreeItem<E> {
    String getName();
    int getAge();
    int getHuman_Id();
    int getFirstParent();

    int getParent_Id();

    void setFirstParent(String name);

    void addChild(E l);
}
