package ui;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addHuman();
    void addChild();
    void getHumanList();
    void saveChanges();
    void finish();
}
