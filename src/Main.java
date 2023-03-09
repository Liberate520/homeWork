import model.ModelService;
import model.project.Human;
import presenter.Presenter;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new Console();
        ModelService<Human> model = new ModelService<>();
        Presenter presenter = new Presenter(view, model);
        view.start();
    }
}