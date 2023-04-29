package ui;

import presenter.Presenter;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
    void addChild();
    void addHuman();
    void getMarried();
    void finishWork();
    void getInfo();
    void save();
    void upload();
}
