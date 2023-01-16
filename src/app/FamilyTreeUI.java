package DZ1.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DZ1.command.Command_ClearTree;
import DZ1.command.Command_Exit;
import DZ1.command.Command_LoadTree;
import DZ1.command.Command_SaveTree;
import DZ1.command.Command_SearchByName;
import DZ1.command.Command_ShowAllTree;
import DZ1.command.Command_TreeSort;
import DZ1.command.Option;

public class FamilyTreeUI implements View, Serializable {

    Presenter presenter = new Presenter<>();
    private Scanner scanner;
    FileHandler fileHandler = new FileHandler();
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

        // int flagOutofMainLoop = 0;

        while (flagOutofMainLoop == 0) {

            // System.out.println(
            // "\n1 - Вывести всех людей из дерева\n2 - Поиск по имени\n3 - Очистить дерево
            // \n4 - Выгрузить в файл \n5 - Загрузить из файла\n6 - Сортировка дерева \n7 -
            // Выход\nВведите цифру, соответствующую необходимому критерию:");

            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i + ": " + commandList.get(i).discription());
            }

            System.out.println("Введите цифру, соответствующую пункту меню: ");

            int userChoiceStartMenu = scanner.nextInt();

            if (userChoiceStartMenu <= commandList.size() && userChoiceStartMenu >= 0) {
                commandList.get(userChoiceStartMenu).execute();
            } else {
                System.out.println("Неправильный ввод, попробуй еще раз внимательно ");
            }

        }
        scanner.close();
    }

    public void showAllTree() {
        System.out.println(presenter.getAllHumans());
    }

    public void exit() {
        flagOutofMainLoop = 1;
    }

    public void loadTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        Human newHuman1 = new Human();
        newHuman1.setWritable(fileHandler);
        presenter.addList(newHuman1.read());

    }

    public void saveTree() throws IOException {
        Human humantemp = new Human();
        humantemp.setWritable(fileHandler);
        humantemp.save(presenter.getHumans());
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
