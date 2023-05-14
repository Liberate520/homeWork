package UI;

import presenter.Presenter;

public interface View {
    void addElement();
    void findElement();

    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
}

