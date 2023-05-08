package Package.View;

import Package.Presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
}
