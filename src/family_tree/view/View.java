package family_tree.view;

import family_tree.presenter.Presenter;

public interface View {
    void start();
    void answer(String answer);
    void addHuman();
    void printFamilyTree();
    void sortByName();
    void sortByAge();
    void exit();
    void setPresenter(Presenter presenter);
    void loadFamilyTree();
    void saveFamilyTree();
    void addParentGlobal();
}
