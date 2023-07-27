package family_tree.ui;

import family_tree.familytree.FamilyTree;
import family_tree.familytree.FamilyTreeItem;
import family_tree.person.Person;
import family_tree.presenter.Presenter;

public interface View {
    void start();
    void print(String text);
    void setPresenter(Presenter presenter);
    Presenter getPresenter();
    public void repeatLine();

}
