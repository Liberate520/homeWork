package view;

import presenter.Presenter;
public interface View {
    void setPresenter(Presenter presenter);
    void start();
    void printText(String text);
}