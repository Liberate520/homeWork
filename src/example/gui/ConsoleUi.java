package org.example.gui;


import org.example.gui.load_menu.menu.LoadMenu;
import org.example.gui.main_menu.menu.MainMenu;
import org.example.presenter.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI implements View{

    private ArrayList<Map<String,String>> printList;
    private Presenter presenter;
    private final Scanner scanner = new Scanner(System.in);
    private LoadMenu menu;

    public ArrayList<Map<String, String>> getPrintList() {
        return printList;
    }

    public void setPrintList(ArrayList<Map<String, String>> printList) {
        this.printList = printList;
    }

    public LoadMenu getMenu() {
        return menu;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void start() throws IOException {
        print(menu.toString());
        String input = scanner.nextLine();
        menu.getButtons().get(Integer.parseInt(input) - 1).action();

        }


    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
        this.printList = presenter.getPrintList();
        this.menu = new LoadMenu(this);
    }


}
