package View;

import Controller.Presenter;
import Model.tree.*;
import View.Buttons.*;
import View.Menues.ConsoleMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    List<CreateHumanButton> list;
    Presenter presenter;
    Scanner scanner;
    ConsoleMenu menu;
    ConsoleMenu lastMenu;

    public View(Presenter presenter) {
        this.presenter = presenter;
        this.list = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void init(){
        ConsoleMenu mainMenu = new ConsoleMenu("Главное меню", this);
        ConsoleMenu createMenu = new ConsoleMenu("Создать", this);
        ConsoleMenu saveMenu = new ConsoleMenu("Сохранить", this);
        ConsoleMenu addMenu = new ConsoleMenu("Добавить в древо", this);

        MenuButton createHuman = new CreateHumanButton(this);
        MenuButton createCat = new CreateCatButton(this);
        MenuButton exitButton = new ExitButton(this);
        MenuButton saveXLS = new SaveXlsButton(this);
        MenuButton savePDF = new SavePdfButton(this);
        MenuButton upButton = new UpButton(this);
        MenuButton printContainer = new PrintContainer(this);
        MenuButton createCatTree = new CreateCatTreeButton(this);
        MenuButton createHumanTree = new CreateHumanTreeButton(this);
        MenuButton addCat = new AddCatButton(this);
        MenuButton addHuman = new AddHumanButton(this);

        addMenu.getListCommand().add(upButton);
        addMenu.getListCommand().add(addCat);
        addMenu.getListCommand().add(addHuman);


        createMenu.getListCommand().add(upButton);
        createMenu.getListCommand().add(createCat);
        createMenu.getListCommand().add(createHuman);
        createMenu.getListCommand().add(createCatTree);
        createMenu.getListCommand().add(createHumanTree);

        saveMenu.getListCommand().add(upButton);
        saveMenu.getListCommand().add(saveXLS);
        saveMenu.getListCommand().add(savePDF);

        mainMenu.getListCommand().add(exitButton);
        mainMenu.getListCommand().add(createMenu);
        mainMenu.getListCommand().add(addMenu);
        mainMenu.getListCommand().add(saveMenu);
        mainMenu.getListCommand().add(printContainer);

        this.menu = mainMenu;
    }

    public void CallMenu(){
        System.out.println("\n----- " + this.menu.getMenuName() + " -----");
        for (int i = 0; i < this.menu.getListCommand().size(); i++) {
            System.out.println("" + i + " - " + menu.getListCommand().get(i));
        }
        System.out.println("----------------\n");
        GetUserPointOfMenu();
    }

    public void GetUserPointOfMenu() {
        int command;
        command = Integer.parseInt(GetInfoFromUser("Введите номер пункта меню"));
        this.menu.Choose(command);
    }

    public String GetInfoFromUser(String question) {
        System.out.print(question + ": ");
        return scanner.nextLine();
    }

    public void setMenu(ConsoleMenu menu) {
        this.menu = menu;
    }

    public void setLastMenu(ConsoleMenu lastMenu) {
        this.lastMenu = lastMenu;
    }

    public ConsoleMenu getMenu() {
        return menu;
    }

    public ConsoleMenu getLastMenu() {
        return lastMenu;
    }

    public void CallCommandButton() {
        presenter.CreateButtonOnClick(GetInfoFromUser("Введите имя"));
    }

    public void sendUserMessage(String message){
        System.out.println(message);
    }

    public String GetName(){
        String name = null;
        String userAnswer;
        boolean flag = true;

        while (flag){
            userAnswer = GetInfoFromUser("Введите имя");
            if (!userAnswer.isEmpty()){
                name = userAnswer;
                flag = false;
            } else {
                sendUserMessage("Поле не может быть пустым");
            }
        }

        return name;
    }

    public Gender GetGender(){
        Gender gender = null;
        String userAnswer;
        boolean flag = true;

        while (flag){
            userAnswer = GetInfoFromUser("Введите пол (М / Ж)");
            if (!userAnswer.isEmpty()){
                if (userAnswer.equalsIgnoreCase("м")){
                    gender = Gender.Male;
                    flag = false;
                } else if (userAnswer.equalsIgnoreCase("ж")) {
                    gender = Gender.Female;
                    flag = false;
                } else {
                    sendUserMessage("Некорректный ввод. Необходимо ввести М или Ж");
                }
            } else {
                sendUserMessage("Поле не может быть пустым");
            }
        }

        return gender;
    }

    public Integer GetAge(){
        Integer age = null;
        String userAnswer;
        boolean flag = true;

        while(flag){
            userAnswer = GetInfoFromUser("Введите возраст");
            if (!userAnswer.isEmpty()){
                try {
                    age = Integer.parseInt(userAnswer);
                    flag = false;
                } catch (Exception e){
                    sendUserMessage("Некорректный ввод. Возраст может быть только целым положительным числом");
                }
            } else {
                sendUserMessage("Поле не может быть пустым");
            }
        }

        return age;
    }

    public void CallCreateHumanButton() {
        presenter.CreateHumanButtonOnClick(GetName(), GetGender(), GetAge());
    }

    public void CallCreateCatButton() {
        presenter.CreateCatButtonOnClick(GetName(), GetGender(), GetAge());
    }

    public void CallExitButton() {
        sendUserMessage("Спасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
        presenter.ExitButtonOnClick();
    }

    public void CallPrintContainer() {
        String containerString = presenter.PrintContainerButtonClick().toString();
        if (containerString.isEmpty()){
            sendUserMessage("\nВ хранилище пока пусто.");
        } else {
            sendUserMessage("\nВ хранилище сейчас:");
            System.out.println(containerString);
        }

    }

    public void CallAddCatButton() {
        Cat cat;
        FamilyTree<Cat> tree;
        Container<Cat> catContainer = presenter.GetCatContainer();
        Container<FamilyTree<Cat>> treeCatContainer = presenter.GetCatTreeContainer();
        if (catContainer.getContainer().size() == 0){
            sendUserMessage("\nНет ни одного кота вне древа");
        } else if (treeCatContainer.getContainer().size() == 0) {
            sendUserMessage("\nНет ни одного древа для добавления котов");
        } else {
            for (int i = 0; i < catContainer.getContainer().size(); i++) {
                System.out.println("" + i + " - " + catContainer.getContainer().get(i));
            }
            cat = (Cat)catContainer.choose(Integer.parseInt(GetInfoFromUser("Введите номер кота")));

            for (int i = 0; i < treeCatContainer.getContainer().size(); i++) {
                tree = (FamilyTree<Cat>) treeCatContainer.getContainer().get(i);
                System.out.println("" + i + " - " + ((FamilyTree<Cat>) treeCatContainer.getContainer().get(i)).getName());
            }
            tree = (FamilyTree<Cat>) treeCatContainer.choose(Integer.parseInt(GetInfoFromUser("Введите номер дерева")));
            presenter.AddCatButtonOnClick(tree, cat);
        }
    }

    public void CallAddHumanButton() {
        Human human;
        FamilyTree<Human> tree;

        Container<Human> humanContainer = presenter.GetHumanContainer();
        Container<FamilyTree<Human>> treeHumanContainer = presenter.GetHumanTreeContainer();

        if (humanContainer.getContainer().size() == 0){
            sendUserMessage("\nНет ни одного человека вне древа");
        } else if (treeHumanContainer.getContainer().size() == 0) {
            sendUserMessage("\nНет ни одного древа для добавления людей");
        } else {
            for (int i = 0; i < humanContainer.getContainer().size(); i++) {
                System.out.println("" + i + " - " + humanContainer.getContainer().get(i));
            }
            human = (Human) humanContainer.choose(Integer.parseInt(GetInfoFromUser("Введите номер человека")));

            for (int i = 0; i < treeHumanContainer.getContainer().size(); i++) {
                tree = (FamilyTree<Human>) treeHumanContainer.getContainer().get(i);
                System.out.println("" + i + " - " + ((FamilyTree<Human>) treeHumanContainer.getContainer().get(i)).getName());
            }
            tree = (FamilyTree<Human>) treeHumanContainer.choose(Integer.parseInt(GetInfoFromUser("Введите номер дерева")));
            presenter.AddHumanButtonOnClick(tree, human);
        }
    }

    public void CallCreateHumanTreeButton() {
        presenter.CreateHumanTreeButtonOnClick(GetName());
    }

    public void CallCreateCatTreeButton() {
        presenter.CreateCatTreeButtonOnClick(GetName());
    }
}
