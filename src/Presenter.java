public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
        model.setPresenter(this);
    }

    public void input(String inputString) {
        String request = model.putUserInput(inputString);
        view.dialog(request);
    }

    public void message(String request) {
        view.dialog(request);
    }
}
