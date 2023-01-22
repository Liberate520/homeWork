package View;

import Controller.Presenter;
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

        createMenu.getListCommand().add(upButton);
        createMenu.getListCommand().add(createCat);
        createMenu.getListCommand().add(createHuman);

        saveMenu.getListCommand().add(upButton);
        saveMenu.getListCommand().add(saveXLS);
        saveMenu.getListCommand().add(savePDF);

        mainMenu.getListCommand().add(exitButton);
        mainMenu.getListCommand().add(createMenu);
        mainMenu.getListCommand().add(saveMenu);

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

    public void UserMessage(String message){
        System.out.println(message);
    }

    public void CallCommandButton() {
        presenter.CreateButtonOnClick(GetInfoFromUser("Введите имя"));
    }

    public void CallCreateCatButton() {
        presenter.CreateCatButtonOnClick(GetInfoFromUser("Введите имя"),
                GetInfoFromUser("Введите пол (М / Ж)"), GetInfoFromUser("Введите возраст"));
    }

    public void CallCreateHumanButton() {
        presenter.CreateHumanButtonOnClick(GetInfoFromUser("Введите имя"),
                GetInfoFromUser("Введите пол (М / Ж)"), GetInfoFromUser("Введите возраст"));
    }

    public void CallExitButton() {
        UserMessage("Спасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
        presenter.ExitButtonOnClick();
    }

    public void CreateButtonOnClick() {
        presenter.ExitButtonOnClick();
    }
}
