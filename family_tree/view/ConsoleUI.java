package homeWork.family_tree.view;

import homeWork.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{

    private Presenter presenter;
    private Scanner scanner;

    private boolean work;
    private MainMenu menu;

    public ConsoleUI(Presenter presenter) {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать на страницу семейного древа!");
        while (work){
            System.out.println("Выберите нужное действие: ");
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            //метод проверки на валидность errorInput;
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
            }

        }

    public void addHuman(){
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст человека");
        String ageString = scanner.nextLine();
        //метод проверки на валидность;
        int age = Integer.parseInt(ageString);
        presenter.addHuman(name, age);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
    public void getHumanInfo(){
        presenter.getHumanInfo();
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByBirthDate(){
        presenter.sortByBirthDate();
    }
    public void errorInput() {
        System.out.println("Вы ввели некорректное значение");
    }
    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }
}
