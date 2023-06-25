package mvp.ui;

import mvp.presenter.Presenter;

// ГОТОВО
public interface View {
    void print(String text);
    void setPresenter(Presenter presenter);
    void start();
}
