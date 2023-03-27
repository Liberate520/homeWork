package ui;

import presenter.Presenter;

public interface View {
    boolean start();
    void setPresenter(Presenter presenter);
    void print(String text);
    void newNote();
    void changeFlag();
}
