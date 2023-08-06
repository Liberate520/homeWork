package src.view;

import src.presenter.Presenter;

public interface View {
    void printAnswer(String text);
    void start();
    void setPresenter(Presenter presenter);
    String scan();
}
