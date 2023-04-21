
import ui.View;

import ui.Console;
import model.ServiceFamilyTree;
import presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        ServiceFamilyTree serviceFamilyTree = new ServiceFamilyTree();
        View view = new Console();
        Presenter presenter = new Presenter(view, serviceFamilyTree);
        view.setPresenter(presenter);
        view.start();

        // Human dad = new Human("Петр", "Осетров", Gender.Male, LocalDate.of(1986, 7,
        // 21));
        // Human mom = new Human("Лариса", "Осетрова", Gender.Female, LocalDate.of(1988,
        // 2, 1));
        // Human son = new Human("Дмитрий", "Осетров", Gender.Male, LocalDate.of(2000,
        // 5, 4));
        // Human dah = new Human("Олеся", "Осетрова", Gender.Female, LocalDate.of(2005,
        // 11, 27));

        // dad.addChild(son);
        // dad.addChild(dah);
        // mom.addChild(son);
        // mom.addChild(dah);

        // tree.addHuman(dad);
        // tree.addHuman(mom);
        // tree.addHuman(son);
        // tree.addHuman(dah);

        // HandlerWriter hw = new HandlerWriter();
        // hw.saveToFile(tree);

        // FamilyTree<Human> testTree = new FamilyTree();

        // HandlerReader hr = new HandlerReader();
        // testTree = (FamilyTree) hr.readFromFile();
        // for (Human human : testTree.getPeopleList()) {
        // System.out.println(human);
        // }

        // пробовал итератор + записи в файлы
        // Service service = new Service(tree);

        // service.saveToFile(tree);
        // FamilyTree<Human> testTree = (FamilyTree<Human>) service.readFromFile();

        // for (Human human : testTree.getPeopleList()) {
        // System.out.println(human.getInfo());
        // }
        // System.out.println();

        // System.out.println("сортировка по именам в алфавитном порядке");
        // service.sortByFirstName();
        // for (Human human : tree) {
        // System.out.println(human.getInfo());
        // }
        // System.out.println();

        // System.out.println("сортировка по датам в обратном порядке");
        // service.SortByDateBirth();
        // for (Human human : tree) {
        // System.out.println(human.getInfo());
        // }

    }
}
