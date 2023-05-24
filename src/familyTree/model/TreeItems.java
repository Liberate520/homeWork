package familyTree.model;

public interface TreeItems<T> {

    String getName();
    int getAge();
    String getInfo();
    int getGender();
    TreeItems getMother();
    TreeItems getFather();
    void addChild (T human);




}
