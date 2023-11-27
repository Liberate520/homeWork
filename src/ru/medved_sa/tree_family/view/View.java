package ru.medved_sa.tree_family.view;

public interface View {
    void start();

    void printAnswer(String answer);

    void addHuman();

    void getHumanList();

    void sortByName();

    void sortByAge();

    void finish();
    void noSortedList();

    void readDataFromFile();
    void saveDataFromFile();
    void setParent();
}

