package family_tree.family_tree.view;

public interface View {


    void start();
    void answer(String answer);
    void addHuman();
    void getHumanListInfo();
    void sortByAge();
    void sortByName();
    void finish();
    void printAnswer(String answer);
    void sortById();
    void setParent();
    void readFromFile();
    void saveFromFile();
}
