package ru.medved_sa.tree_family.view;

public interface View {
    void start();

    void print(String answer);

    void addHuman();

    void getHumanList();

    void sortByName();

    void sortByAge();

    void finish();
}
