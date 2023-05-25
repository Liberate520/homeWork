package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void setPresenter(Presenter presenter);
    void print(String text);

    void printMenu();
    void exit();
    void getTreeInfo();
    void printSortByAge();
    void printSortByFirstName();
    void printSortByLastName();
    void addNewPerson();
    void addNewPersonAs();
    void getInfo();
    void getInfoRelation();
    void saveFamilyTree() throws IOException;
    void loadFamilyTree() throws IOException, ClassNotFoundException;
}
