package DZ1.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DZ1.app.Presenter;
import DZ1.mainMenuCommands.Command_ClearTree;
import DZ1.mainMenuCommands.Command_Exit;
import DZ1.mainMenuCommands.Command_LoadTree;
import DZ1.mainMenuCommands.Command_SaveTree;
import DZ1.mainMenuCommands.Command_SearchByName;
import DZ1.mainMenuCommands.Command_ShowAllTree;
import DZ1.mainMenuCommands.Command_TreeSort;
import DZ1.mainMenuCommands.Option;

public class FamilyTreeUI implements View, Serializable {

    Presenter presenter;
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

        List<Option> commandList = new ArrayList<>();
        commandList.add(new Command_ShowAllTree(this));
        commandList.add(new Command_ClearTree(this));
        commandList.add(new Command_LoadTree(this));
        commandList.add(new Command_SaveTree(this));
        commandList.add(new Command_SearchByName(this));
        commandList.add(new Command_TreeSort(this));
        commandList.add(new Command_Exit(this));

        while (flagOutofMainLoop == 0) {

            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i + ": " + commandList.get(i).discription());
            }

            System.out.println("Введите цифру, соответствующую пункту меню: ");

            int userChoiceStartMenu = scanner.nextInt();

            if (userChoiceStartMenu < commandList.size() && userChoiceStartMenu >= 0) {
                commandList.get(userChoiceStartMenu).execute();
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
        System.out.println("Введите имя: ");
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
