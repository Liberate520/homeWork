package view;
import presenter.Presenter;
public interface UI {
    void start();

    void print(String s);

    void setPresenter(Presenter presenter);
}
