package familyTree.ui;

import familyTree.presenter.Presenter;

public interface View {

    void show(String text);

    void start();

    void finish();

    void setPresenter(Presenter presenter);

    void addToTree();

    void getAllInfo();

    void getInfoConcreteTree();

    void getInfoHumanFromTree();

    void getInfoGender();

    void getInfoParents();

    void getInfoDateOfBirth();

    void getInfoDateOfDeath();

    void getInfoAge();

    void getInfoSpouse();

    void getInfoChildren();
}
