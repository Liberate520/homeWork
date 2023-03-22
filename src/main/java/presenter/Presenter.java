package presenter;

import model.Model;
import model.Notebook;
//import model.Record;
import view.View;

public class Presenter {

    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void showAll() {
        view.printText(this.model.toString());
    }

    public void addRec(String text, String deadline) {
        this.model.addRec(text, deadline);
    }

    public void delRec(Integer index) {
        this.model.delRec(index);
    }

    public void load() {
        this.model.load();
    }

    public void save() {
        this.model.save();
    }

}
