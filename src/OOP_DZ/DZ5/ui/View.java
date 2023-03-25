package OOP_DZ.DZ5.ui;

import OOP_DZ.DZ5.presenter.Presenter;

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
