package view;

import presenter.Presenter;
public interface View {
    void print(String text);
    void setPresenter(Presenter presenter);
    void start();
}
