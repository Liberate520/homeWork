package homeWork.src.familyTree.ui;

import homeWork.src.familyTree.FamilyTree;
import homeWork.src.familyTree.FileHandler;
import homeWork.src.familyTree.Human;
import homeWork.src.familyTree.commands.*;
import homeWork.src.familyTree.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI<T extends Human> {

    private FamilyTree familyTree;
    private FileHandler fileHandler;
    private Presenter presenter;
    List<Commands> commandsList;

    public ConsoleUI(FamilyTree familyTree, FileHandler fileHandler, Presenter presenter) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.presenter = presenter;
        //      устанавливаем файловый обработчик для familyTree типа FileHandler
        this.familyTree.setWritable(fileHandler);
        //      читаем FamilyTree из файла. В случае неудачи работаем с новым пустым FamilyTree
        this.familyTree = familyTree.readFamilyTree();
        presenter.setFamilyTree(this.familyTree);
        commandsList = new ArrayList<>();
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public T getHuman(FamilyTree familyTree) {
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
//        заполняем список команд UI
        commandsList.add(new SaveAndFinish(this));
        commandsList.add(new GetAllMembers(this));
        commandsList.add(new AddNewMember(this));
        commandsList.add(new FindByName(this));
        commandsList.add(new GetAllChildren(this));
        commandsList.add(new GetAllSisters(this));
        commandsList.add(new GetAllBrothers(this));
        commandsList.add(new SortByName(this));
        commandsList.add(new SortByAge(this));

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

