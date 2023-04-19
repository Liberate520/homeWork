package view;

import presenter.Presenter;

public interface iView {

    void print(String text);

    void start();

    void setPresenter(Presenter presenter);

    Presenter getPresenter();
}
