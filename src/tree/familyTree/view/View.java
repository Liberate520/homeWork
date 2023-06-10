package tree.familyTree.view;

import tree.familyTree.presenter.Presenter;

public interface View {

    void setPresenter(Presenter presenter);
    void start();
}
