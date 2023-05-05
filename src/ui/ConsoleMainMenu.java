package ui;

import presenter.Presenter;
import service.Service;
import ui.commands.mainMenu.WorkWithTree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ConsoleMainMenu implements ViewMainMenu{
    private static final String INPUT_ERROR = "Вы ввели неверное значение, повторите ввод";
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu mainMenu;
    private WorkWithTree workWithTree;
    private boolean start;
    private String family;

    public ConsoleMainMenu(){
        scanner = new Scanner(System.in);
        start = true;
        mainMenu = new MainMenu(this);
        this.family = "";
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (start){
            if (!family.equals("")){
                System.out.println("Дерево: " + family);
            }
            printMainMenu();
            execute();
        }
    }

    @Override
    public void addFamilyTree() {
        System.out.println("Создать новое дерево");
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        Path path = Path.of(fileName + ".txt");
        if (Files.exists(path)){
            System.out.println("Такое дерево уже существует.\n");
        } else {
            this.presenter = new Presenter(this, new Service());
            this.family = fileName;
        }
    }

    @Override
    public void readFamilyTree() {
        System.out.println("Загрузить дерево");
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        try {
            presenter.readFamilyTree(fileName + ".txt");
            family = fileName;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeFamilyTree() {
        if (!this.family.equals("")) {
            System.out.println("Сохранить дерево");
            try {
                presenter.writeFamilyTree(this.family + ".txt");
                System.out.println("Данные записаны в файл " + this.family + ".txt");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Сначала надо создать дерево.\n");
        }
    }

    @Override
    public void workWithTree() {
        if (!this.family.equals("")) {
            ViewWorkMenu viewWorkMenu = new ConsoleWorkMenu();
            viewWorkMenu.setPresenter(presenter);
            viewWorkMenu.start();
        } else {
            System.out.println("Сначала надо создать или загрузить дерево.\n");
        }
    }

    @Override
    public void finish() {
        System.out.println("Пока!");
        start = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    private void hello(){
        System.out.println("Добро пожаловать!");
    }
    private void printMainMenu(){
        System.out.println(mainMenu.print());
    }
    private void execute(){
        String input = scanner.nextLine();
        if (checkTextForInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
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
        if (numCommand <= mainMenu.size() && numCommand > 0){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
