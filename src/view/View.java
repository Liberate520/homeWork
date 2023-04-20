package view;
import java.io.IOException;
import presenter.Presenter;

public interface View<T, E> {
    void start() throws ClassNotFoundException, IOException;
    void print(T t);
    void setPresenter(Presenter presenter);
    String getInput();
}
