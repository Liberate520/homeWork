package DZ1.UI;

import java.io.IOException;

import DZ1.app.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void start() throws IOException, ClassNotFoundException;

}
