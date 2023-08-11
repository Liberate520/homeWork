package homeWork.family_tree.view;

import homeWork.family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private final Scanner scanner;
    private boolean work;
    private final MainMenu menu;

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
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
            }

        }

    public void addHuman(){
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст человека");
        String birthDateString = scanner.nextLine();
        int birthDate = Integer.parseInt(birthDateString);
        presenter.addHuman(name, String.valueOf(birthDate));
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
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
    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
