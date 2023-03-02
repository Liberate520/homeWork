package presenter;

import java.time.LocalDate;

import model.Model;
import ui.View;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
        model.setPresenter(this);
    }

    public void addTreeEntity(String name, String lastname, String sex, LocalDate dateOfBirth) {
        model.addTreeEntity(name, lastname, sex, dateOfBirth);
    }

    public void showEntityInfo(int num) {
        view.print(model.showEntityInfo(num));

    }

    public void printTree() {
        view.print(model.printTree());
    }

    public void demo() {
        model.demoTree();
    }
}
