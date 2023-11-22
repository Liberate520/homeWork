package family_tree.view;

public interface View {
    void start();
    void printAnswer(String text);
    void error();
    void sortByAge();
    void sortByName();
    void GetHumanListInfo();
    void addHuman();
    void finish();
}
