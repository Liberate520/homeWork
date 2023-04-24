package ui;

import presenter.Presenter;

public interface View {
    void run();

    void setPresenter(Presenter presenter);

    void print(String text);
}
