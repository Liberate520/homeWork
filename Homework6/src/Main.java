public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Model model = new Model();
        Presenter presenter = new Presenter(view, model);
        view.setPresenter(presenter);
        view.onClick();
    }
}