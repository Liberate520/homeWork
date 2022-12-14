package View;

import Presenter.Presenter;

public interface View {
    String scanString(String str);
    int scanInt(String str);
    void setPresenter(Presenter presenter);
    void start();
}
