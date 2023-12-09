package familyTree;

public interface commonParam {
    String getName();
    int getBirthDate();
    int getAge();

    <E> void addChild(E human);
    void getParents();
    void getChildren();
    void addParent();
}
