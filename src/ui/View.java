package ui;

import java.util.ArrayList;

public interface View {
    void showMenu();
    int userChoice();
    void printAll(String text);
    void choiceRemove();
    int userChoiceRemove();
    void removeNote();
    void emptyNotebook();
    ArrayList<String> addNote();
    void addedNote();


}
