package View;

import Controller.Presenter;
import Model.tree.Gender;
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

        MenuButton createHuman = new CreateHumanButton(this);
        MenuButton createCat = new CreateCatButton(this);
        MenuButton exitButton = new ExitButton(this);
        MenuButton saveXLS = new SaveXlsButton(this);
        MenuButton savePDF = new SavePdfButton(this);
        MenuButton upButton = new UpButton(this);
        MenuButton printContainer = new PrintContainer(this);
        MenuButton createTree = new CreateTreeButton(this);

        createMenu.getListCommand().add(upButton);
        createMenu.getListCommand().add(createCat);
        createMenu.getListCommand().add(createHuman);
        createMenu.getListCommand().add(createTree);

        saveMenu.getListCommand().add(upButton);
        saveMenu.getListCommand().add(saveXLS);
        saveMenu.getListCommand().add(savePDF);

        mainMenu.getListCommand().add(exitButton);
        mainMenu.getListCommand().add(createMenu);
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
        this.menu.choose(command);
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
        Boolean flag = true;

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
        Boolean flag = true;

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
        Boolean flag = true;

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

    public void CallCreateTreeButton() {
        presenter.CreateTreeButtonOnClick(GetName());
    }

    public void CallExitButton() {
        sendUserMessage("Спасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
        presenter.ExitButtonOnClick();
    }

    public void CallPrintContainer() {
        presenter.PrintContainerButtonClick();
    }


}
