package mvp.ui;

import java.time.LocalDate;
import java.util.Scanner;
import mvp.presenter.Presenter;
import mvp.ui.menu.MainMenu;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flagWork;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        flagWork = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    /**
     * ЗАПУСК ПРИЛОЖЕНИЯ
     */
    @Override
    public void start() {
        while (flagWork) {
            System.out.println("\n\n>>>>>>>>>>>>Семейное дерево<<<<<<<<<<<<<");
            System.out.println(mainMenu.printMenu());
            // ПРОВЕРКА НА КОРРЕКТНОСТЬ ВВОДА:
            int choice = inputNumMenu();

            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }

            mainMenu.execute(choice);
        }
    }

    /**
     * ДОБАВЛЕНИЕ ЛИЧНОСТЕЙ В СЕМЕЙНОЕ ДЕРЕВО
     */
    @Override
    public void addNote() {
        LocalDate timeWrite = inputDate("Дата совершения операции");

        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ
        String del1 = scanner.nextLine();
        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ

        String name = inputStringText("Имя: ");
        String surname = inputStringText("Фамилия: ");
        String patronymic = inputStringText("Отчество: ");

        LocalDate dateOfBirth = inputDate("Дата рождения:");

        System.out.println("Добавить родственников отца и мать, введите 1:");
        int answer = scanner.nextInt();

        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ
        String del2 = scanner.nextLine();
        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ

        if (answer == 1) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>Отец<<<<<<<<<<<<<<<<<<<<");

            String nameF = inputStringText("Имя: ");
            String surnameF = inputStringText("Фамилия: ");
            String patronymicF = inputStringText("Отчество: ");

            System.out.println(">>>>>>>>>>>>>>>>>>>>Мать<<<<<<<<<<<<<<<<<<<<");

            String nameM = inputStringText("Имя: ");
            String surnameM = inputStringText("Фамилия: ");
            String patronymicM = inputStringText("Отчество: ");

            presenter.addNote(
                    name,
                    surname,
                    patronymic,
                    dateOfBirth,
                    nameF,
                    surnameF,
                    patronymicF,
                    nameM,
                    surnameM,
                    patronymicM);
        } else {
            presenter.addNote(
                    name,
                    surname,
                    patronymic,
                    dateOfBirth);
        }

        // System.out.println(presenter.getInfo()); //ТЕСТ(УДАЛИТЬ ПОТОМ)
    }

    /**
     * Ввод данных
     * 
     * @param textInfo - информация об операции
     * @return - возвращение строки
     */
    private String inputStringText(String textInfo) {
        System.out.println(textInfo);
        String textUser = scanner.nextLine();
        return textUser;
    }

    /**
     * Ввод данных
     * 
     * @param textInfo - информация об операции
     * @return - возвращение даты: (год, месяц, день), (int-int-int).
     */
    private LocalDate inputDate(String textInfo) {
        System.out.println(textInfo);
        System.out.println("Год:");
        int year = scanner.nextInt();
        System.out.println("Месяц:");
        int month = scanner.nextInt();
        System.out.println("День:");
        int day = scanner.nextInt();

        LocalDate date = LocalDate.of(year, month, day);

        return date;
    }

    /**
     * ПОЛУЧЕНИЕ ДАННЫХ ЛИЧНОСТИ
     */
    @Override
    public void getNote() {
        String text = inputStringText("Укажите событие: ");
        presenter.getNote(text);
    }

    /**
     * ПОЛУЧЕНИЕ ДАННЫХ ВСЕХ ЛИЧНОСТЕЙ
     */
    @Override
    public void getAllNote() {
        presenter.getAllNote();
    }

    /**
     * ВЫКЛЮЧЕНИЕ ПРИЛОЖЕНИЯ
     */
    @Override
    public void end() {
        System.out.println("Хорошего дня;)");
        flagWork = false;
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            System.out.println("Такого действия нет в меню");
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }

        int choice = Integer.parseInt(line);

        return choice > 0 && choice <= mainMenu.size();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
