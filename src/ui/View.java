package ui;

import Presenter.Presenter;

import java.io.IOException;

public interface View {
    void print(String text);
    void start() throws IOException, ClassNotFoundException;
    void setPresenter(Presenter presenter);
}
