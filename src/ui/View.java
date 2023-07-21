package Tree.homeWork.src.ui;

import Tree.homeWork.src.Presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addHuman();
    void getHumanList();
    void finish();
}
