package presenter;

import model.*;
import view.View;

public class Presenter {
    private Repository repository;
    private View view;

    public Presenter(Repository repository, View view) {
        this.view = view;
        this.repository = repository;
        view.setPresenter(this);
    }

    public void newTree(){
        repository.newTree();
    }
    public void printElement(String name) {
        repository.printElement(name);
    }
    public void printTree(){
        repository.printTree();
    }
}
