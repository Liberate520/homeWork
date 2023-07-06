package tree.view;

import tree.presenter.Presenter;

public interface View {
    void start();

    void print(String text);

    void setPresenter(Presenter presenter);

}
