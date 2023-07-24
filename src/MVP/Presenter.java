package MVP;

public class Presenter {
    Model model;
    View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }
}
