package HW01.ui;

import HW01.presenter.Presenter;

import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);
    void start() throws IOException, ClassNotFoundException;
}
