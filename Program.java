
import human.Human;
import model.service.Service;
import model.tree.FamilyTree;
import presenter.Presenter;
import ui.Console;
import ui.StartCommand;
import ui.User;
import ui.View;

public class Program {

  public static void main(String[] args) {

    FamilyTree<Human> tree = new FamilyTree<>();
    View view = new Console();
    User user = new User(new StartCommand(view));
    Service service = new Service(tree);
    Presenter presenter = new Presenter(view, service);
    user.startCommand();

  }
}