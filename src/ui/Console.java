package ui;

import java.util.Scanner;
import presenter.Presenter;
import tree.human.Gender;
import tree.human.Human;

public class Console implements View{

    private static final String INPUT_ERROR = "Введенные данные некорректны, попробуйте еще раз";
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;
    private MainMenu mainMenu;

    
    public Console(){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);;
    }

    @Override
    public void start() {
        System.out.println("Доброо времени суток");;
        while (work) {
            printMenu();
            execute();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addHuman(){
        boolean addWork;
        addWork = true;
        root: while (addWork){
            try {
                System.out.println("Выберите пол (Male/Female)");
                Gender gender = Gender.valueOf(scanner.nextLine());
                System.out.println("Введите ФИО");
                String name = scanner.nextLine();
                System.out.println("Введите возраст");
                Integer age = Integer.parseInt(scanner.nextLine());
                presenter.addHuman(gender, name, age);
            } catch (Exception e) {
                System.out.println(INPUT_ERROR);
                continue root;
            }
            addWork = false;
        }
    }

    @Override
    public void addChild(){
        boolean addWork;
        addWork = true;
        root: while (addWork){
            try {
                System.out.println("Введите имя родителя, мы попробуем найти его в базе данных");
                Human human1 = presenter.getHumanByName(scanner.nextLine());
                System.out.println("Введите имя дитя, мы попробуем найти его в базе данных");
                Human human2 = presenter.getHumanByName(scanner.nextLine());
                presenter.addChild(human1, human2);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(INPUT_ERROR);
                continue root;
            }
            addWork = false;
        }
    }

    @Override
    public void getHumanList() {
        presenter.getHumanList();
    }

    @Override
    public void finish() {
        System.out.println("До скорых встреч");
        scanner.close();
        work = false;
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
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

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void saveChanges() {
        presenter.saveChanges();
    }
}
