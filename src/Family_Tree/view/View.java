package Family_Tree.view;

public interface View {
    void start();
    void answer(String answer);
    void add();
    String getHumanListInfo();
    void sortByName();
    void sortByBirthday();
    void finish();
}
