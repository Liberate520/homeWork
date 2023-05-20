package UI;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void print(String text);
    void start();
    void addElement();
    void findElement();
    void finish();
    void sort();
    void getElementList();
    void addChildren();
    void loadFrom();
    void saveTo();
    void setFather();
    void setMother();
}

