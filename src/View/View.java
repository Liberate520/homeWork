package View;

import Controller.Presenter;
import Model.tree.*;
import View.Buttons.*;
import View.Menues.ConsoleMenu;

import java.io.IOException;
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
//        ConsoleMenu saveMenu = new ConsoleMenu("Сохранить", this);
        ConsoleMenu addMenu = new ConsoleMenu("Добавить в древо", this);

        MenuButton createHuman = new CreateHumanButton(this);
        MenuButton createCat = new CreateCatButton(this);
        MenuButton exitButton = new ExitButton(this);
        MenuButton saveButton = new SaveButton(this);
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

        mainMenu.getListCommand().add(exitButton);
        mainMenu.getListCommand().add(createMenu);
        mainMenu.getListCommand().add(addMenu);
//        mainMenu.getListCommand().add(saveMenu);
        mainMenu.getListCommand().add(printContainer);
        mainMenu.getListCommand().add(saveButton);

        this.menu = mainMenu;
    }

    public void callMenu() throws IOException {
        System.out.println("\n----- " + this.menu.getMenuName() + " -----");
        for (int i = 0; i < this.menu.getListCommand().size(); i++) {
            System.out.println("" + i + " - " + menu.getListCommand().get(i));
        }
        System.out.println("----------------\n");
        getUserPointOfMenu();
    }

    public int checkUserChoise(){
        int command = 0;
        String userAnswer = null;
        boolean flag = true;

        while (flag) {
            userAnswer = getInfoFromUser("Введите номер пункта меню");
            if (!userAnswer.isEmpty()) {
                try {
                    command = Integer.parseInt(userAnswer);
                    if (!(command < 0) && command < this.menu.getListCommand().size()) {
                        flag = false;
                    } else {
                        sendUserMessage("Такого пункта нет в меню");
                    }
                } catch (Exception e) {
                    sendUserMessage("Некорректный ввод. Номер пункта должен быть числом");
                }
            } else {
                sendUserMessage("Поле не может быть пустым");
            }
        }

        return command;
    }

    public void getUserPointOfMenu() throws IOException {
        int command = checkUserChoise();
        this.menu.choose(command);
    }

    public String getInfoFromUser(String question) {
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

    public void sendUserMessage(String message){
        System.out.println(message);
    }

    public String getName(){
        String name = null;
        String userAnswer;
        boolean flag = true;

        while (flag){
            userAnswer = getInfoFromUser("Введите имя");
            if (!userAnswer.isEmpty()){
                name = userAnswer;
                flag = false;
            } else {
                sendUserMessage("Поле не может быть пустым");
            }
        }

        return name;
    }

    public Gender getGender(){
        Gender gender = null;
        String userAnswer;
        boolean flag = true;

        while (flag){
            userAnswer = getInfoFromUser("Введите пол (М / Ж)");
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

    public Integer getAge(){
        Integer age = null;
        String userAnswer;
        boolean flag = true;

        while(flag){
            userAnswer = getInfoFromUser("Введите возраст");
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

    public void callCreateHumanButton() {
        sendUserMessage("\nЧеловек '" + presenter.createHumanButtonOnClick(getName(), getGender(), getAge()) + "' создан");
    }

    public void callCreateCatButton() {
        sendUserMessage("\nКот '" + presenter.createCatButtonOnClick(getName(), getGender(), getAge()) + "' создан");
    }

    public void callExitButton() {
        sendUserMessage("Спасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
        presenter.exitButtonOnClick();
    }

    public boolean checkContainerSize(){
        boolean check;
        String containerString = presenter.printContainerButtonClick().toString();
        if (containerString.isEmpty()) {
            check = false;
        } else {
            check = true;
        }
        return check;
    }

    public void callPrintContainer() {
        if (checkContainerSize()){
            sendUserMessage("\nВ хранилище сейчас:");
            System.out.println(presenter.printContainerButtonClick().toString());
        } else {
            sendUserMessage("\nВ хранилище пока пусто.");
        }
    }

    public void callAddCatButton() {
        Cat cat;
        FamilyTree<Cat> tree;
        Container<Cat> catContainer = presenter.getCatContainer();
        Container<FamilyTree<Cat>> treeCatContainer = presenter.getCatTreeContainer();
        if (catContainer.getContainer().size() == 0){
            sendUserMessage("\nНет ни одного кота вне древа");
        } else if (treeCatContainer.getContainer().size() == 0) {
            sendUserMessage("\nНет ни одного древа для добавления котов");
        } else {
            for (int i = 0; i < catContainer.getContainer().size(); i++) {
                System.out.println("" + i + " - " + catContainer.getContainer().get(i));
            }
            cat = (Cat)catContainer.choose(Integer.parseInt(getInfoFromUser("Введите номер кота")));

            for (int i = 0; i < treeCatContainer.getContainer().size(); i++) {
                tree = (FamilyTree<Cat>) treeCatContainer.getContainer().get(i);
                System.out.println("" + i + " - " + ((FamilyTree<Cat>) treeCatContainer.getContainer().get(i)).getName());
            }
            tree = (FamilyTree<Cat>) treeCatContainer.choose(Integer.parseInt(getInfoFromUser("Введите номер дерева")));
            presenter.addCatButtonOnClick(tree, cat);
        }
    }

    public void callAddHumanButton() {
        Human human;
        FamilyTree<Human> tree;

        Container<Human> humanContainer = presenter.getHumanContainer();
        Container<FamilyTree<Human>> treeHumanContainer = presenter.getHumanTreeContainer();

        if (humanContainer.getContainer().size() == 0){
            sendUserMessage("\nНет ни одного человека вне древа");
        } else if (treeHumanContainer.getContainer().size() == 0) {
            sendUserMessage("\nНет ни одного древа для добавления людей");
        } else {
            for (int i = 0; i < humanContainer.getContainer().size(); i++) {
                System.out.println("" + i + " - " + humanContainer.getContainer().get(i));
            }
            human = (Human) humanContainer.choose(Integer.parseInt(getInfoFromUser("Введите номер человека")));

            for (int i = 0; i < treeHumanContainer.getContainer().size(); i++) {
                tree = (FamilyTree<Human>) treeHumanContainer.getContainer().get(i);
                System.out.println("" + i + " - " + ((FamilyTree<Human>) treeHumanContainer.getContainer().get(i)).getName());
            }
            tree = (FamilyTree<Human>) treeHumanContainer.choose(Integer.parseInt(getInfoFromUser("Введите номер дерева")));
            presenter.addHumanButtonOnClick(tree, human);
        }
    }

    public void callCreateHumanTreeButton() {
        sendUserMessage("\nДрево людей '" + presenter.createHumanTreeButtonOnClick(getName()) + "' создано");
    }

    public void callCreateCatTreeButton() {
        sendUserMessage("\nДрево котов '" + presenter.createCatTreeButtonOnClick(getName()) + "' создано");
    }

    public void callSaveButton() throws IOException {
        if (checkContainerSize()){
            presenter.saveButtonOnClick();
        } else {
            sendUserMessage("\nВ хранилище пока пусто. Нет данных для сахранения.");
        }
    }
}
