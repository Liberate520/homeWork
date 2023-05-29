package view;


import Presenter.Presenter;

public interface View {
    void start();
    void changeFlag();
    Presenter getPresenter();
    MainMenu getMainMenu();
}
