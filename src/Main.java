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

//        service.addHuman("Иван", "Иванов", Gender.Male, "12.12.1978");
//        service.addHuman("Мария", "Иванова", Gender.Female, "12.11.1981");
//        service.addHuman("Ольга", "Иванова", Gender.Female, "11.11.2001",
//                tree.getByName("Иван"), tree.getByName("Мария"));
//
//        service.addHuman("Петр", "Иванов", Gender.Male, "01.11.1987");
//        service.addHuman("Ирина", "Иванова", Gender.Female, "21.01.1991");
//        service.addHuman("Семен", "Иванов", Gender.Male, "10.01.2016",
//                tree.getByName("Петр"), tree.getByName("Ирина"));
//        service.addHuman("Архип", "Иванов", Gender.Male, "31.03.2019",
//                tree.getByName("Петр"), tree.getByName("Ирина"));






//        System.out.println("дерево перед записью\n");
//        service.printTree();
//
//        service.setHandler(new FileHandler());
//        // организация записи через сервис
//        service.save("src/out.dat");
//        System.out.println("дерево прочитано из файла\n");
//        // организация чтения через сервис
//        service.load("src/out.dat");
//        service.printTree();






    }
}
