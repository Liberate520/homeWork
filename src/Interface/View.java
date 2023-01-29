package Interface;
import java.io.IOException;

import App.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void start() throws IOException, ClassNotFoundException;

}
