package ui;
import java.io.IOException;
import presenter.Presenter;

public interface View<T> {
   T start(T t) throws ClassNotFoundException, IOException;
    void print(T t);
    void setPresenter(Presenter presenter);

}
