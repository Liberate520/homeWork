package FT.UI;

import FT.Tree;
import FT.FileHandler;
import FT.Human;
import FT.commands.*;
import FT.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI<T extends Human> {

    private Tree familyTree;
    private FileHandler fileHandler;
    private Presenter presenter;
    List<Commands> commandsList;

    public ConsoleUI(Tree familyTree, FileHandler fileHandler, Presenter presenter) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.presenter = presenter;
        this.familyTree.setWritable(fileHandler);
        this.familyTree = familyTree.readFamilyTree();
        presenter.setFamilyTree(this.familyTree);
        commandsList = new ArrayList<>();
    }

    public Tree getFamilyTree() {
        return familyTree;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public T getHuman(Tree familyTree) {
        Human human = new Human();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String str = iScanner.nextLine();
        human.setName(str);
        System.out.print("Введите пол: ");
        str = iScanner.nextLine();
        human.setGender(str);
        System.out.print("Введите возраст: ");
        try {
            str = iScanner.nextLine();
            human.setAge(Integer.parseInt(str));
        } catch (Exception exception) {
            System.out.println("Не корректный ввод! Записываю возраст 0.");
            human.setAge(0);
        }
        System.out.print("Введите имя отца (может быть пустым): ");
        str = iScanner.nextLine();
        human.setFather(familyTree.getByName(str));
        System.out.print("Введите имя матери (может быть пустым): ");
        str = iScanner.nextLine();
        human.setMother(familyTree.getByName(str));
        return (T) human;
    }

    public String getName() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        return iScanner.nextLine();
    }

    public void start() {
        Scanner iScanner = new Scanner(System.in);
        T human;
        commandsList.add(new Command_0(this));
        commandsList.add(new Command_1(this));
        commandsList.add(new Command_2(this));
        commandsList.add(new Command_3(this));
        commandsList.add(new Command_4(this));
        commandsList.add(new Command_5(this));
        commandsList.add(new Command_6(this));
        commandsList.add(new Command_7(this));
        commandsList.add(new Command_8(this));

        while (true) {
            System.out.println("Выберите действие:");
            for (int i = 0; i < commandsList.size(); i++) {
                System.out.println(i + " - " + commandsList.get(i).description());
            }
            System.out.print("-->\t");
            String str = iScanner.nextLine();
            try {
                int choice = Integer.parseInt(str);
                if ((choice >= 0) & (choice < commandsList.size())) {
                    commandsList.get(Integer.parseInt(str)).execute();
                } else {
                    System.out.println("Такой команды нет! Повторите ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Попробуйте ещё раз.");
            }
        }
    }
}