package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    // #region fields
    private final Presenter presenter;
    private final Scanner scanner;
    private boolean isWork;
    private final MainMenu mainMenu;
    private final DateTimeFormatter formatter;
    // #endregion

    public ConsoleUI() {
        isWork = true;
        presenter = new Presenter();
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    // #region implements
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        do {
            print(mainMenu.getMenu());
            Integer input = getIntegerInput(1, mainMenu.getSize());
            mainMenu.execute(input);
        } while (isWork);
    }

    public void printDetail() {
        print("Введите номер человека чтобы увидеть информацию\n");
        print(presenter.getMembersNames());
        int input = getIntegerInput(1, presenter.getAllMembersAmount()) - 1;
        print("Detail: \n");
        print(presenter.getMemberDetail(input));
    }

    public void printAll() {
        print(presenter.getMembersNames());
    }

    public void quit() {
        isWork = false;
    }

    public void addNewMember() {
        presenter.addNewMember(getName(), getDate(), getGender(), getFatherIndex(), getMotherIndex());
    }

    public void editMember() {
        print("Введите номер человека, чтобы внести изменения \n");
        print(presenter.getMembersNames());
        Integer input = getIntegerInput(1, presenter.getAllMembersAmount()) - 1;
        presenter.updateMember(input, getName(), getDate(), getGender(), getFatherIndex(), getMotherIndex());
        print("Изменение прошло успешно \n");
    }

    public void save() {
        presenter.save();
    }
    // #endregion

    // #region inputs
    private LocalDate getDateInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception ignored) {}
        } while (true);
    }

    private Integer getIntegerInput(int min, int max) {
        do {
            print("> ");
            String input = scanner.nextLine();
            if(input.equals("")) {
                return null;
            }
            if (input.matches("[0-9]+")) {
                int parsed = Integer.parseInt(input);
                if (parsed >= min && parsed <= max)
                    return parsed;
            }
        } while (true);
    }

    private String getStringInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if(!input.equals(""))
                return input;
        } while (true);
    }
    // #endregion

    // #region helpers

    private int getMotherIndex() {
        print("Выберете мать(0 чтобы оставить поле пустым): \n");
        print(presenter.getFemalesNames());
        int mother = getIntegerInput(0, presenter.getFemaleAmount()) - 1;
        if (mother == -1) {
            print("вы ввели: 'неизвестно'\n");
        } else {
            print("Вы ввели: " + presenter.getFemaleName(mother) + "/n");
        }
        return mother;
    }

    private int getFatherIndex() {
        print("Выберете отца(0 чтобы оставить поле пустым): \n");
        print(presenter.getMalesNames());
        int father = getIntegerInput(0, presenter.getMaleAmount()) - 1;
        if (father == -1) {
            print("Вы ввели: 'неизвестно'\n");
        } else {
            print("Вы ввели: " + presenter.getMaleName(father) + "\n");
        }
        return father;
    }

    private int getGender() {
        print("Введите пол ('m' или 'f'):\n");
        print(presenter.getGendersList());
        int gender = getIntegerInput(1, 2) - 1;
        print("Вы ввели: " + presenter.getGender(gender) + "\n");
        return gender;
    }

    private LocalDate getDate() {
        print("Введите дату рождения (\"dd.MM.YYYY\"):\n");
        LocalDate date = getDateInput();
        print("Вы ввели: " + formatter.format(date) + "\n");
        return date;
    }

    private String getName() {
        print("Введите полное имя:\n");
        String fullName = getStringInput();
        print("Вы ввели: " + fullName + "\n");
        return fullName;
    }
}

