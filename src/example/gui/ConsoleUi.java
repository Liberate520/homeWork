package org.example.gui;

import org.example.presenter.Presenter;
import java.util.Scanner;

public class ConsoleUi implements View{
    private String navigationMenu; // показывает в каком меню находится пользователь
    private final Scanner scanner;
    private Menu menu;

    public ConsoleUi() {
        this.navigationMenu = "0";
        this.scanner = new Scanner(System.in);
    }

    public void setNavigationMenu(String navigationMenu) {
        this.navigationMenu = navigationMenu;
    }

    private void print(String text) {
        System.out.println(text);
    }


    @Override
    public void start(){
        boolean flag = false;
            while (!flag) {
                try {
                    if (navigationMenu.equals("0")) {
                        print(menu.getMainMenu());
                    }
                    String input = scanner.nextLine();
                    menu.mainMenu(input, navigationMenu);
                    if (input.equals("5") && navigationMenu.equals("0")) {
                        flag = true;
                    }
                }catch (Exception exception){
                    print("error..");
                    navigationMenu = "0";
        }
        }
        }


    @Override
    public void setPresenter(Presenter presenter) {
        this.menu = new Menu(presenter);
        menu.setConsoleUi(this);
    }
}
