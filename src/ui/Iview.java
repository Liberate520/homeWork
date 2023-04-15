package ui;

import presenter.Presenter;

public interface Iview {
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
}
