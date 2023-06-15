package FamilyTree.view;

import FamilyTree.presenter.Presenter;

public interface View {
    void print(String text);
    void setPresenter(Presenter presenter);
    void start();
}
