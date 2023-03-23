package Homework25_2.UI;

import java.util.ArrayList;

public interface View {
    int printMenu();

    void printAll(String text);

    int choiceRemove(int size);

    void removedNote();

    void emptyNotebook();

    ArrayList<String> addNote();

    void addedNote();


}