package UI;

import Presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void scan() throws IOException {
        String line = scanner.next();
        if (checkTextForInt(line)) {
            int command = Integer.parseInt(line);
            if (checkCommand(command)) {
                menu.run(command);
            }
        }
    }

    @Override
    public void run() throws IOException {
        System.out.println("Привет! Выбери действие:");
        while (work) {
            System.out.println(menu.print());
            scan();
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.size()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println("Вы ввели неверное значение");
    }

    @Override
    public void addHuman() {
        try {
            System.out.println("Введите имя: ");
            String firstName = scanner.next();
            System.out.println("Введите фамилию: ");
            String secondName = scanner.next();
            System.out.println("Введите пол (Male или Female): ");
            String gender = scanner.next();
            System.out.println(
                    "Введите дату рождения в формате(дд-мм-гггг): ");
            String[] birthdate = scanner.next().split("-");
            int birthday = Integer.parseInt(birthdate[0]);
            int birthmonth = Integer.parseInt(birthdate[1]);
            int birthyear = Integer.parseInt(birthdate[2]);
            presenter.addHuman(firstName, secondName, gender, birthday,
                               birthmonth, birthyear);

        } catch (Exception e) {
            inputError();
        }

    }

    @Override
    public void getHumanList() {
        presenter.getHumanList();
    }

    @Override
    public void getAllInfo() {
        presenter.getInfo();
    }

    @Override
    public void update() throws IOException {
        System.out.println("Введите название файла: ");
        String path = scanner.next();
        presenter.save(path);
    }

    @Override
    public void finish() {
        System.out.println("Пока!");
        work = false;
    }
}
