
import java.util.Scanner;

public class View {

    CommandList cl = new CommandList<>();
    Presenter presenter;
    Tree tree;

    public View(Tree tree) {
        this.tree = tree;
    }

    public void start() {
        System.out.println("Выберите команду для работы с семейным деревом: \n");

        cl.addCommand(new GetTree<>(this));
        cl.addCommand(new GetChildrens<>(this));
        cl.addCommand(new AddHuman<>(this));
        cl.addCommand(new SortByName<>(this));
        cl.addCommand(new SortByYear<>(this));

        for (int index = 0; index < cl.size(); index++) {
            System.out.println(cl.getCommand(index).discription());
        }

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        cl.getCommand(choose - 1).execute();
    }

    void getTree() {
        Presenter presenter = new Presenter(this, tree);
        presenter.getTree(tree);
    }

    void getChildrens(Members member) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Фамилию: \n");
        String surname = scanner.next();

        System.out.println("Введите Имя: \n");
        String name = scanner.next();
        Presenter presenter = new Presenter(this, tree);
        presenter.getChildrens(surname, name);
    }

    void addHuman(Members member) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Фамилию: \n");
        String surname = scanner.next();

        System.out.println("Введите Имя: \n");
        String name = scanner.next();

        System.out.println("Введите год рождения: \n");
        int yearBorn = scanner.nextInt();

        System.out.println("Введите год смерти: \n");
        int yearDead = scanner.nextInt();

        System.out.println("Введите пол: \n");
        String sex = scanner.next();
        Presenter presenter = new Presenter(this, tree);
        presenter.addHumanEnter(surname, name, yearBorn, yearDead, sex);
    }

    void sortByName() {
        Presenter presenter = new Presenter(this, tree);
        presenter.sortBySurname(tree);
    }

    void sortByYear() {
        Presenter presenter = new Presenter(this, tree);
        presenter.sortByYear(tree);
    }

}