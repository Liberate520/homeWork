package Interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import App.Presenter;
import Menu.Structure_clearTree;
import Menu.Structure_exit;
import Menu.Structure_loadTree;
import Menu.Structure_saveTree;
import Menu.Structure_searchByName;
import Menu.Structure_showAllTree;
import Menu.Structure_sortTree;
import Menu.Select;

public class FamilyTreeUI implements View, Serializable {

    private Presenter presenter;
    private Scanner scanner;
    int flagOutofMainLoop = 0;

    public FamilyTreeUI() {
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in, "Cp866");

        List<Select> menuList = new ArrayList<>();
        menuList.add(new Structure_showAllTree(this));
        menuList.add(new Structure_clearTree(this));
        menuList.add(new Structure_loadTree(this));
        menuList.add(new Structure_saveTree(this));
        menuList.add(new Structure_searchByName(this));
        menuList.add(new Structure_sortTree(this));
        menuList.add(new Structure_exit(this));

        while (flagOutofMainLoop == 0) {

            for (int i = 0; i < menuList.size(); i++) {
                System.out.println(i + ": " + menuList.get(i).discription());
            }

            System.out.println("Введите цифру, соответствующую пункту меню: ");

            int userChoiceStartMenu = scanner.nextInt();

            if (userChoiceStartMenu < menuList.size() && userChoiceStartMenu >= 0) {
                menuList.get(userChoiceStartMenu).execute();
            } else {
                System.out.println("Неправильный ввод, попробуй еще раз внимательно ");
            }

        }
        scanner.close();
    }

    public void showAllTree() {
        System.out.println(presenter.getHumans());
    }

    public void exit() {
        flagOutofMainLoop = 1;
    }

    public void loadTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        presenter.loadTree();
    }

    public void saveTree() throws IOException {

        presenter.saveTree();
    }

    public void searchByName() {
        scanner.nextLine();
        System.out.println("Ввод имени: ");
        String userInputName = scanner.nextLine();
        System.out.println(presenter.getHumanByNameAndRelatives(userInputName));
    }

    public void treeSort() {
        System.out.println(
                "\n1 - Сортировка по имени\n2 - сортировка по полу\nУкажите параметр сортировки: ");
        int userChoiceSortMenu = scanner.nextInt();
        switch (userChoiceSortMenu) {
            case 1:
                presenter.sortByName();
                System.out.println("Отсортировано по имени");
                break;
            case 2:
                presenter.sortByGender();
                System.out.println("Отсортировано по полу");
        }

    }

    public void clearTree() {
        presenter.clearTree();
    }
}
