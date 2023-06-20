package view;

import model.person.Person;
import model.tree.Tree;
import presenter.Presenter;

import java.io.IOException;
import java.util.List;

public interface View {
    void start() throws IOException, ClassNotFoundException;

    void finish();

    void setPresenter(Presenter presenter);

    void printList(List<Person> someList);


    void printTree(Tree<Person> tree);

    List<String> getNewPersonInfo();

    boolean askToSave();

}
