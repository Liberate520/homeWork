import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Presenter {
    private Tree<Human> tree;
    private FileHandler fileHandler;
    private Presenter presenter;
    private Scanner scanner;

    public Presenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void comandSortByName() {
        tree.sortByName();
    }

    public void comandSortByBirth() {
        tree.sortByBirth();
    }

    public void comandSave() throws IOException {
        fileHandler.save(tree.getHumanlist());
    }

    public void comandRead() throws IOException, ClassNotFoundException {
        try {
            fileHandler.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void comandAddNewHuman() {
        Human human1 = new Human();
        tree.add_human(human1);
    }

    public void comandPrintConsoleTree() {
        System.out.println(tree);
    }

    public void comandSearchByName() {
        System.out.println("Введите имя и я найду человека: ");
        String search = scanner.nextLine();
        for (Human human : tree) {
            if (human.getName().equals(search)) {
                System.out.println(human);
            }
        }
    }

}
