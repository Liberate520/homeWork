
package ui;

import java.io.IOException;

import human.Human;
import presenter.Presenter;
import tree.Tree;

public interface View {
    void start() throws ClassNotFoundException, IOException;

    void print(Tree<Human> answer);

    void setPresenter(Presenter pr);
}
