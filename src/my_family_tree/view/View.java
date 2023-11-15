package my_family_tree.view;

public interface View {
    void start();
    void answer(String answer);
    void addHumanToTheFamily();
    void getTreeInfo();
    void sortByAge();
    void sortByName();
    void sortByYear();
    void finish();
}
