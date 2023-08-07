package Presenter;

import View.GenealogyTreeView;

public interface GenealogyTreePresenter {
    void attachView(GenealogyTreeView view);

    void addPerson(String parentName, String childName, int childAge);

    void getChildren(String personName);

    void getAncestors(String personName);

    void sortChildrenByName(String personName);

    void sortAncestorsByName(String personName);
}
