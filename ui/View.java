package homeWork.ui;

import homeWork.presenter.Presenter;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
    void print(String text);
}