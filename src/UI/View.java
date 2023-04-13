package UI;

import Presenter.Presenter;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
    void print(String text);


}
