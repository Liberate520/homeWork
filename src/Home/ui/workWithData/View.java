package Home.ui.workWithData;

import Home.presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);

    void addHuman();
    void getHumanInfo();
    void finish();
}
