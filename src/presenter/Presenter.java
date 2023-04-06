package presenter;

import java.io.IOException;

import service.Service;
import tree.Tree;
import ui.View;

public class Presenter<E> {
    private View<E> view;
    private Service<E> service;

    public Presenter(View<E> view, Service<E> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public Tree<E> task(int num, String st) throws ClassNotFoundException, IOException {
        Tree<E> answer = service.get(num, st);
        return answer;
    }
}
