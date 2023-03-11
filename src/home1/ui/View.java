package home1.ui;

import home1.model.FamilyTree;
import home1.model.Human;
import home1.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void start();

    void print(String text);

    void print(Human human);

    void print(FamilyTree<Human> FamilyFree);

    String scan();
}
