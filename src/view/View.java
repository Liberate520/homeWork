package view;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void answer(String answer);
    void sortByAge();
    void sortByName();
    void getFamilyTree();
    void addElement();
    void save() throws IOException, ClassNotFoundException;
    void read() throws IOException, ClassNotFoundException;
    void saveAndExit() throws IOException, ClassNotFoundException;
    void exit();
}