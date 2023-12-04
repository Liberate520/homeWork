package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void getHumanInfo(){
        presenter.getHumanInfo();
    }
    public void addObject(){
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека: ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст студента");
        String ageString = scanner.nextLine();
        //сделать проверку ввода возраста
        int age = Integer.parseInt(ageString);
        presenter.addStudent(name, age);
        presenter.addObject();
    }
    public void sortByAge(){
        presenter.sortByAge();
    }
    public void addChild(){

        presenter.addChild();
    }

        private void hello () {
            System.out.println("Доброго времени суток!");
        }

        private void execute () {
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                int numCommand = Integer.parseInt(line);
                if (checkCommand(numCommand)) {
                    menu.execute(numCommand);
                }
            }
        }

        private boolean checkTextForInt (String text){
            if (text.matches("[0-9]+")) {
                return true;
            } else {
                inputError();
                return false;
            }
        }

        private boolean checkCommand ( int numCommand){
            if (numCommand < menu.getSize()) {
                return true;
            } else {
                inputError();
                return false;
            }
        }

        private void printMenu () {
            System.out.println(menu.menu());
        }

        private void inputError () {
            System.out.println(INPUT_ERROR);
        }


}
