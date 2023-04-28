package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean run;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.run = true;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        this.print("Добро пожаловать в Фамильное Древо!");
        this.print("************************************");
        this.print("");
        this.print("Вы можете наполнить друво вручную или загрузить из файла MyFamilyTree.sfmt,\n" +
                "прилагаемого к проекту.");
        this.printHelp();

        while (run) {
            String userInput = inputString("Введите команду: ");
            switch (userInput.toLowerCase()) {
                case "?" -> this.printHelp();
                case "q" -> this.exit();
                case "1" -> this.getTreeInfo();
                case "1-1" -> this.printSortByAge();
                case "1-2" -> this.printSortByFirstName();
                case "1-3" -> this.printSortByLastName();
                case "2" -> this.addNewPerson();
                case "2-1" -> this.addNewPersonAs();
                case "3" -> this.getInfo();
                case "3-1" -> this.getInfoRelation();
                case "4-1" -> this.saveFamilyTree();
                case "4-2" -> this.loadFamilyTree();
                default -> this.print("Команда введена неверно.");
            }
        }
    }

    private void printHelp() {
        this.print("-----------------------------------");
        this.print("? - Вывод списка команд;");
        this.print("q - Завершение работы;");
        this.print("1 - Вывод полной информации по дереву;");
        this.print("1-1 - Вывод персон, отсортированных по возрасту;");
        this.print("1-2 - Вывод персон, отсортированных по имени;");
        this.print("1-3 - персон, отсортированных по фамилии;");
        this.print("2 - Добавить новую персону;");
        this.print("2-1 - Добавить нового родного;");
        this.print("3 - Вывод информации по персоне;");
        this.print("3-1 - Вывод информации по родственнику персоны;");
        this.print("4-1 - Сохранение древа в файл;");
        this.print("4-2 - Загрузка древа из файла;");
        this.print("-----------------------------------");
    }

    private void exit() {
        run = false;
        System.out.println("Завершение работы.");
    }

    private void getTreeInfo() {
        presenter.getTreeInfo();
    }

    private void printSortByAge() {
        presenter.printSortByAge();
    }

    private void printSortByFirstName() {
        presenter.printSortByFirstName();
    }

    private void printSortByLastName() {
        presenter.printSortByLastName();
    }

    private void addNewPerson() {
        this.print("Собираем информацию о новой персоне...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        int age = this.inputInt("Введите возраст: ");
        String gender = this.inputString("Введите пол (м/ж): ");
        presenter.addPerson(firstName, lastName, age, gender);
        this.print("Персона добавлена в дерево.");
    }

    private void addNewPersonAs() {
        this.print("Собираем информацию о новой персоне...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        int age = this.inputInt("Введите возраст: ");
        String gender = this.inputString("Введите пол (м/ж): ");
        this.print("Кому приходится родней...");
        String targetFirstName = this.inputString("Введите имя: ");
        String targetLastName = this.inputString("Введите фамилию: ");
        this.print("Доступные степени родства: м - мать, o - отец, cп - супруг/супруга, б - брат, ст - сестра, сн - сын, д - дочь.");
        // todo: сделать проверку на введенную степень родства
        String relation = this.inputString("Введите родство: ");
        presenter.addPersonAs(firstName, lastName, age, gender, targetFirstName, targetLastName, relation);
        this.print("Персона добавлена в дерево.");
    }

    private void getInfo() {
        this.print("Ищем...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        presenter.getInfo(firstName, lastName);
    }

    private void getInfoRelation() {
        this.print("Ищем...");
        String firstName = this.inputString("Введите имя: ");
        String lastName = this.inputString("Введите фамилию: ");
        this.print("Доступные степени родства: м - мать, o - отец, cп - супруг/супруга, б - брат, ст - сестра, сн - сын, д - дочь.");
        String relation = this.inputString("Введите степень родства: ");
        presenter.getInfo(firstName, lastName, relation);
    }

    private void saveFamilyTree() throws IOException {
        this.print("Сохраняем древо...");
        String path = this.inputString("Введите имя файла (без расширения): ") + ".sfmt";
        presenter.saveFamilyTree(path);
    }

    private void loadFamilyTree() throws IOException, ClassNotFoundException {
        this.print("Загружаем древо...");
        String path = this.inputString("Введите имя файла (без расширения): ") + ".sfmt";
        presenter.loadFamilyTree(path);
    }

    private String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int inputInt(String message) {
        int number = 0;
        boolean run = true;
        while (run) {
            try
            {
                number = Integer.parseInt(this.inputString(message).trim());
                run = false;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Введено некорректное значение.");
            }
        }
        return number;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
