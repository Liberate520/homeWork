package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);

    void print(String message);

    void run() throws IOException, ClassNotFoundException;
}
