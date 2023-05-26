package familyTree.ui;


import familyTree.presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addPerson();
    void getParents();
    void getChildren();
    void getGrandParents();
    void getInfoTree();
    void sortName();
    void sortAge();
    void sortGender();
    void finish();
    void saveFile();
    void readFile();

}

