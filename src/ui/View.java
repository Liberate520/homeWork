package ui;

import java.util.ArrayList;

public interface View {
    int choiceMenu();

    void printAll(String text);

    int choiceRemove(int size);

    void removedNote();

    void emptyNotebook();

    ArrayList<String> addNote();

    void addedNote();


}
