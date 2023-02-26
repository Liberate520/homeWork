package HWGT.ui;
import java.io.IOException;
import HWGT.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void start() throws IOException, ClassNotFoundException;
}
