package ui;

import presenter.Presenter;

public interface View {
    void print(String text);

    void start();

    void serPresenter(Presenter presenter);

    void addRecord();

    void exit();

    void search();

    void saveTree();

    void readTree();

    void sortByName();

    void sortBirthDate();

    void printTree();
}
