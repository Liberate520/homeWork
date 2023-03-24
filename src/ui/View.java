package ui;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void setFlag(boolean flag);

    int scan();

    String scanRecord();

    void start();

    void print(String text);

    void succeeded(boolean isWork);

    void infoOutput();

    void addRecord();

    void removeRecord();

    void changeRecord();

    void exit();
}
