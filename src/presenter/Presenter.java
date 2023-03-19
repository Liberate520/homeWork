package presenter;

import model.Notebook;
//import model.Record;
import view.View;

public class Presenter {

    private View view;
    private Notebook notebook;

    public Presenter(View view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
        view.setPresenter(this);
    }

    public void showAll() {
        view.printText(notebook.toString());
    }

    public void addRec(String[] args) {
        notebook.addRec(args);
    }

    public void delRec(String index) {
        notebook.delRec(index);
    }

    public void load() {
        notebook.load();
    }

    public void save() {
        notebook.save();
    }

}
