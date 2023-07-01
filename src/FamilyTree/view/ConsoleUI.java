package FamilyTree.view;

import FamilyTree.model.person.Gender;
import FamilyTree.presenter.Presenter;
import FamilyTree.view.commands.SaveTree;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        this.work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        System.out.println("Добрый день! Выберите пункт меню: ");
        while(work) {
            printMenu();
            execute();
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void execute() {
        int input = inputMenuValue();
        if(input != -1) {
            mainMenu.execute(input);
        }
    }

    private void printMenu() {
        mainMenu.printMenu();
    }

    private int inputMenuValue() {
        String input = scanner.nextLine();
        if(checkInputForInt(input)) {
            if(checkInputValue(input)) {
                return Integer.parseInt(input);
            }
        }
        return -1;
    }

    private boolean checkInputForInt(String input) {
        if(input.matches("[0-9]+")) {
            return true;
        } else {
            inputErrorForInt();
            return false;
        }
    }

    private boolean checkInputValue(String input) {
        if(Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= mainMenu.size()) {
            return true;
        } else {
            inputErrorForValue();
            return false;
        }
    }

    private void inputErrorForInt() {
        System.out.println("INPUT_MUST_CONTAIN_ONLY_NUMBERS");
    }

    private void inputErrorForValue() {
        System.out.println("INPUT_VALUE_MUST_BE_FROM_1_TO_" + mainMenu.size());
    }

    public void getFamilyTreeInfo() {
        System.out.println("Вы работаете с деревом: ");
        presenter.getFamilyTreeInfo();
    }

    public void getByName() {
        System.out.println("Введите имя для поиска: ");
        String searchRequest = scanner.nextLine();
        presenter.getByName(searchRequest);
    }

    public void addPerson() {
        System.out.println("Внесите данные для добавления: ");
        System.out.print("ФИО полностью: ");
        String inputName = scanner.nextLine();
        String inputGender = getGender();
        System.out.println("Укажиет дату рождения: ");
        System.out.print("Год рождения: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("Месяц рождения: ");
        int monthOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("День рождения: ");
        int dayOfBirth = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println("Укажите родителей.");
        System.out.print("ФИО отца: ");
        String inputFatherName = scanner.nextLine();
        System.out.print("ФИО матери: ");
        String inputMotherName = scanner.nextLine();
        presenter.addPerson(inputName, inputGender, dateOfBirth, inputMotherName, inputFatherName);
    }

    private String getGender() {
        System.out.print("Выберите пол (1 - male, 2 - female): ");
        int inputGender = Integer.parseInt(scanner.nextLine());
        if(inputGender == 1) {
            return "male";
        }
        return "female";
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void finish() {
        System.out.println("Работа с деревом завершена. До свидания.");
        work = false;
    }

    public void saveTree() {
        String path = "src/FamilyTree/model/file.txt";
        System.out.println("Укажите путь для сохранения дерева. Чтобы оставить путь по умолчению, нажмите ввод.");
        System.out.println("Путь по умолчанию:" + path);
        String input = scanner.nextLine();

        if (!input.isEmpty()) {
            path = input;
        }
        presenter.saveTree(path);
    }

    public void loadTree() {
        String path = "src/FamilyTree/model/file.txt";
        System.out.println("Укажите путь к файлу для загрузки дерева. Чтобы оставить путь по умолчению, нажмите ввод.");
        System.out.println("Путь по умолчанию:" + path);
        String input = scanner.nextLine();

        if (!input.isEmpty()) {
            path = input;
        }
        presenter.loadTree(path);
    }

    public void updatePerson() {
        System.out.print("Укажите ФИО человека, информацию о котором Вы хотите обновить: ");
        String searchRequest = scanner.nextLine();
        System.out.println("Укажите новую информацию: ");
        System.out.print("ФИО полностью: ");
        String inputName = scanner.nextLine();
        String inputGender = getGender();
        System.out.println("Укажиет дату рождения: ");
        System.out.print("Год рождения: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("Месяц рождения: ");
        int monthOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("День рождения: ");
        int dayOfBirth = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println("Укажите родителей.");
        System.out.print("ФИО отца: ");
        String inputFatherName = scanner.nextLine();
        System.out.print("ФИО матери: ");
        String inputMotherName = scanner.nextLine();
        presenter.updatePerson(searchRequest, inputName, inputGender, dateOfBirth, inputMotherName, inputFatherName);
    }

}
