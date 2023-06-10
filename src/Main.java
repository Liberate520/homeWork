import human.Human;
import presenter.Presenter;
import serializer.TreeSerializer;
import tree.FamilyTree;
import tree.Service;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args) {

        FamilyTree<Human> familyTree = new FamilyTree<>();
        View view = new Console();
        Service service = new Service(familyTree);
      
        service.sortByFirstName();
        //service.sortByAge();

        service.setWritable(new TreeSerializer());

        new Presenter(view, service);
        view.start();
    }
}
