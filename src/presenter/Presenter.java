package presenter;

import model.Model;
import view.View;

public class Presenter {

    // ПОЛЯ КЛАССА PRESENTER
    private final View view;
    private final Model model;

    // КОНСТРУКТОР КЛАССА PRESENTER
    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    // МЕТОДЫ КЛАССА PRESENTER

    public void showAll() {

        view.printText(this.model.toString());
    }

    public void addRec(String text, String deadline, String notes) {
        this.model.addRec(text, deadline, notes);
    }

    public void delRec(Integer index) {
        this.model.delRec(index);
    }

    public void changeRec(Integer index, String text, String deadline, String notes) {
        this.model.changeRec(index, text, deadline, notes);
    }


    public void load() {
        this.model.load();
    }

    public void save() {
        this.model.save();
    }
}