package family_tree.view;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void printAnswer(String text);
    void error();
    void sortByAge();
    void sortByName();
    void GetHumanListInfo();
    void addHuman();
    void addMather();
    void finish();

    void addFather();

    void SaveFamily() throws IOException, ClassNotFoundException;

    void LoadFamily() throws IOException, ClassNotFoundException;
}
