
package ui;

import java.io.IOException;

import presenter.Presenter;
import tree.Tree;

public interface View<E> {
    int start() throws ClassNotFoundException, IOException;

    void print(Tree<E> answer);

    void setPresenter(Presenter<E> pr);
}
