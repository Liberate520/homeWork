package oop.familyTree.mvp.view.console;

import oop.familyTree.mvp.presenter.Presenter;
import oop.familyTree.mvp.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UiConsole implements View {

    private final Menu menu;
    private final Presenter PRESENTER = new Presenter();
    private static final String INPUT_ERROR = "Ошибка во входных данных";
    private boolean work;
    private final Scanner scan;

    /**
     * Конструктор
     */
    public UiConsole() {
        menu = new Menu(this);
        scan = new Scanner(System.in);
        work = true;
    }

    // #Собственные методы

    /**
     * Старт работы приложения
     */
    public void start() {
        initGreeting();
        while (work){
            showMenu();
            execute();
        }
    }

    /**
     * Вывод текста ошибки
     */
    private void wrongInput(){
        System.out.println(INPUT_ERROR);
    }

    /**
     * Проверка, что в консоль введены цифры или
     * ничего не введено
     * @param text введённый текст
     * @return да или нет
     */
    private boolean checkingTextForInt(String text){
        if (text.matches("[0-9]+") || text.equals("")) return true;
        else {
            wrongInput();
            return false;
        }
    }

    /**
     * Проверка, что введённое число не превышает
     * количество команд меню
     * @param commandNum номер команды
     * @return да или нет
     */
    private boolean checkingCommandsNum(int commandNum){
        if (commandNum <= menu.menuSize()) return true;
        else {
            wrongInput();
            return false;
        }
    }

    /**
     * Проверка, что в консоль что-то введено
     * @param str входящая строка
     * @return да или нет
     */
    private boolean checkingEmptinessConsole(String str){
        if (!str.isEmpty()) return true;
        else {
            wrongInput();
            return false;
        }
    }

    /**
     * Парсинг даты
     * @param dateStr входящая строка
     * @return LocalDate
     */
    private LocalDate dateParsing(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date;
        if (dateStr.length() == 10) {
            date = LocalDate.parse(dateStr, formatter);
            return date;
        }
        return null;
    }

    /**
     * Вывод заголовка
     */
    private void initGreeting(){
        System.out.println("Начинаем работу с древом");
    }

    /**
     * Отображение команд меню
     */
    private void showMenu(){
        System.out.println(menu.show());
    }

    /**
     * Выполнение выбранной команды
     */
    private void execute(){
        String text = scan.nextLine();
        if (checkingTextForInt(text)) {
            int commandNum = Integer.parseInt(text);
            if (checkingCommandsNum(commandNum)){
                System.out.print("**********\n");
                menu.execute(commandNum);
                System.out.print("**********\n");
            }
        }
    }

    // #Конец

    // #Методы интерфейса View

    @Override
    public void showNameFamilyTree() {
        List<String> list = PRESENTER.getNameFamilyTree();
        IntStream.range(0, list.size()).forEach(i -> System.out.printf("%d. %s\n", i + 1, list.get(i)));
    }

    @Override
    public void addNewTree() {
        System.out.print("Введмте имя древа: ");
        String treeName = scan.nextLine();
        if (checkingEmptinessConsole(treeName)) PRESENTER.createNewTree(treeName);
    }

    @Override
    public void infoAboutSelectedTree() {
        System.out.print("Введмте имя древа: ");
        String treeName = scan.nextLine();
        if (checkingEmptinessConsole(treeName)) {
            List<String> list = PRESENTER.showFamilyTree(treeName);
            IntStream.range(0, list.size()).forEach(i -> System.out.printf("%s\n", list.get(i)));
        }
    }

    @Override
    public void addNewHuman() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();

        System.out.print("Введите полное имя: ");
        String fullName = scan.nextLine();

        System.out.print("Введите пол (\"мужской\" или \"женский\"): ");
        String gender = scan.nextLine();

        System.out.print("Введите дату рождения(вида дд.мм.гггг): ");
        LocalDate dateOfBirth = this.dateParsing(scan.nextLine());

        System.out.print("Введите дату смерти или ничего не вводите: ");
        LocalDate dateOfDeath = this.dateParsing(scan.nextLine());

        System.out.print("Введите полное имя матери: ");
        String mother = scan.nextLine();

        System.out.print("Введите полное имя отца: ");
        String father = scan.nextLine();

        System.out.print("Введите имя супрга(и) или ничего не вводите: ");
        String spouse = scan.nextLine();

        System.out.print("Введите имена детей или ничего не вводите: ");
        String children = scan.nextLine();

        PRESENTER.addNewHuman(treeName, fullName, gender, dateOfBirth,
                dateOfDeath, mother, father, spouse, children);
    }

    @Override
    public void deletingHuman() {
        System.out.print("Введите имя древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите имя человека: ");
        String fullName = scan.nextLine();
        PRESENTER.deletingHuman(treeName, fullName);
    }

    @Override
    public void sortByName() {
        System.out.print("Введите имя древа: ");
        String treeName = scan.nextLine();
        PRESENTER.sortByName(treeName);
    }

    @Override
    public void sortByAge() {
        System.out.print("Введите имя древа: ");
        String treeName = scan.nextLine();
        PRESENTER.sortByAge(treeName);
    }

    @Override
    public void fullInfoHuman() {
        System.out.print("Введите имя древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите имя человека: ");
        String fullName = scan.nextLine();
        PRESENTER.fullInfoHuman(treeName, fullName);
    }

    private void showFields(){
        System.out.println("1. Изменение имени");
        System.out.println("2. Изменение пола");
        System.out.println("3. Изменение даты рождения");
        System.out.println("4. Изменение даты смерти");
        System.out.println("5. Изменение имени матери");
        System.out.println("6. Изменение имени отца");
        System.out.println("7. Новый супруг");
        System.out.println("8. Добавление ребёнка");
    }

    @Override
    public void changeField() {
        this.showFields();
        System.out.print("Введите имя древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите имя человека: ");
        String fullName = scan.nextLine();
        System.out.print("Введите номер поля: ");
        int numField = Integer.parseInt(scan.nextLine());
        System.out.print("Введите новое значение: ");
        String newValue = scan.nextLine();
        PRESENTER.changeField(treeName, fullName, numField, newValue);
    }

    @Override
    public void finish() {
        System.out.println("Работа закончена");
        work = false;
    }
    // #Конец
}
