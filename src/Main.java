import model.TreeService;
import model.handler.FileHandler;
import model.handler.Loadable;
import model.handler.Saveble;
import presenter.Presenter;
import ui.Console;
import ui.View;

public class Main {
        public static void main(String[] args) {
                View view = new Console();
                Saveble saveble = new FileHandler();
                Loadable loadable = new FileHandler();
                TreeService treeService = new TreeService(saveble, loadable);
                new Presenter(view, treeService);
                view.start();
        }
}
