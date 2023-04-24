package src.ui;

import src.presenter.Presenter;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
    void print(String text);
}
