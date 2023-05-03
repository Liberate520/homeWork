package ui;

import Presenter.Presenter;

import java.io.IOException;

public interface View {
    void print(String text);

    void start() throws IOException, ClassNotFoundException;

    void setPresenter(Presenter presenter);

    void loadTree() throws IOException, ClassNotFoundException;

    void saveTree() throws IOException;

    void printTree();

    void sortByBirthYear();

    void sortBySecondName();

    void sortBySex();

    void finish();

    void addHuman();

}
