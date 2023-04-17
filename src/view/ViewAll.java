package view;

import presenter.Presenter;

public class ViewAll {
    private Presenter presenter;

    public ViewAll(Presenter presenter){
        this.presenter = presenter;
    }
    public void viewAll() {
        presenter.printTree();
    }
}
