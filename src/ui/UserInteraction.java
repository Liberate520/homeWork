package ui;

import mvp.Presenter;

public interface UserInteraction {
    void start();

    void setPresenter(Presenter presenter);

}