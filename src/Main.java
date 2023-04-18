import familyTree.FamilyTree;
import familyTree.Service;
import familyTree.member.Gender;
import familyTree.member.Human;
import presenter.Presenter;
import service.FileHandler;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        FamilyTree<Human> tree = new FamilyTree<>();
        Service service = new Service(tree);
        new Presenter(view, service);
        view.start();




//        System.out.println("дерево перед записью\n");
//        service.printTree();//
//        service.setHandler(new FileHandler());
//        // организация записи через сервис
//        service.save("src/out.dat");
//        System.out.println("дерево прочитано из файла\n");
//        // организация чтения через сервис
//        service.load("src/out.dat");
//        service.printTree();

    }
}
