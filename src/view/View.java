package view;

import presenter.Presenter;

public interface View {
    Presenter getPresenter();

    void start();
    void printAnswer(String text);

}
