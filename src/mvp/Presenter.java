package mvp;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public String allNotes() {
        return model.readData();
    }

    public void writeNote(String note) {
        model.writeData(note);
    }
}
