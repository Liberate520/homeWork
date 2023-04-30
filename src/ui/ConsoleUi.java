package ui;

import Presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUi implements View{
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean flag;

public ConsoleUi(){
    scanner = new Scanner(System.in);
    flag = true;
    menu = new Menu(this);
}

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void LoadTree() throws IOException, ClassNotFoundException {
        System.out.println("Загружено дерево из файла. ");
        presenter.LoadTree();
    }

    @Override
    public void SaveTree() throws IOException {
        System.out.println("Дерево сохранено в файл. ");
    presenter.SaveTree();
    }

    @Override
    public void PrintTree() {
            System.out.println("распечатать дерево:");
            presenter.PrintTree();
    }

    @Override
    public void sortByBirthYear() {
        System.out.println("Сортировка дерева по году рождения:");
    presenter.sortByBirthYear();
    }

    @Override
    public void SortBySecondName() {
    presenter.SortBySecondName();


    }

    @Override
    public void SortBySex() {
    presenter.SortBySex();

    }

    @Override
    public void Finish() {
        System.out.println("Работа завершена");
        flag = false;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Проект семейное дерево");
        while (flag) {
            printMenu();
            System.out.print("Введите пункт меню:");
            execute();
        }
    }
        public void printMenu(){
            System.out.println(menu.print());
        }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void execute() throws IOException, ClassNotFoundException {
        String inputLine = scanner.nextLine();
        if (checkInput(inputLine)){
            int choice = Integer.parseInt(inputLine);
            if (checkChoice(choice)){
                menu.execute(choice);
            }
        }
    }

    private boolean checkInput(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            System.out.println("Неверный ввод команды");
            return false;
        }
    }

    private boolean checkChoice(int choice){
        if (choice <= menu.size()){
            return true;
        } else {
            System.out.print("Неверный ввод команды");
            return false;
        }
    }


}
