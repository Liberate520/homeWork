package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Введено неверное значение";
    public Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    // int num = 0;

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
        System.out.println("Завершение программы");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя члена семьи");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию члена семьи");
        String lastname = scanner.nextLine();
        System.out.println("Укажите возраст члена семьи");
        String ageString = scanner.nextLine();
        // if(scanner.hasNextInt()) { 
        //     num = scanner.nextInt();
        //     System.out.println("Возраст введен верно!");
        //     int age = Integer.parseInt(ageString);
        //     presenter.addHuman(name, age);
        //   } else {
        //     System.out.println("Вы ввели не число");
        //   }
        int age = Integer.parseInt(ageString);
        presenter.addHuman(name,lastname, age);
    }

    private void hello(){
        System.out.println("Добро пожаловать!");
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
        if (text.matches("[1-5]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){  // вот из-за этого у меня не работала команда 5(Finish). Стояло меньше, а надо меньше или равно, так-как команда последняя в списке :)
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
