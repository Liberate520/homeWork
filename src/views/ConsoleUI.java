package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import presenter.Presenter;

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
    // #endregion

    // #endregion commands 
    /** вывод подробной информации о члене семьи */
    public void printDetail() {
        print("Enter a number of member for print detail\n");
        print(presenter.getMembersNames());
        int input = getIntegerInput(1, presenter.getAllMembersAmount()) - 1;
        print("Detail: \n");
        print(presenter.getMemberDetail(input));
    }

    /** вывод всех членов семьи */
    public void printAll() {
        print(presenter.getMembersNames());
    }

    /** выход */
    public void quit() {
        isWork = false;
    }

    /** добавление нового члена в семью */
    public void addNewMember() {
        presenter.addNewMember(getName(), getDate(), getGender(), getFatherIndex(), getMotherIndex());
    }

    /** редактирование данных члена семьи */
    public void editMember() {
        print("Enter a number of member for edit \n");
        print(presenter.getMembersNames());
        Integer input = getIntegerInput(1, presenter.getAllMembersAmount()) - 1;
        presenter.updateMember(input, getName(), getDate(), getGender(), getFatherIndex(), getMotherIndex());
        print("Changed apply successful \n");
    }

    /** сохранение */
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

    /** получение индекса матери */
    private int getMotherIndex() {
        print("Select mother(0 for keep empty): \n");
        print(presenter.getFemalesNames());
        int mother = getIntegerInput(0, presenter.getFemaleAmount()) - 1;
        if (mother == -1) {
            print("You entered: 'unknown'\n");
        } else {
            print("You entered: " + presenter.getFemaleName(mother) + "/n");
        }
        return mother;
    }

    /** получение индекса отца */
    private int getFatherIndex() {
        print("Select father(0 for keep empty): \n");
        print(presenter.getMalesNames());
        int father = getIntegerInput(0, presenter.getMaleAmount()) - 1;
        if (father == -1) {
            print("You entered: 'unknown'\n");
        } else {
            print("You entered: " + presenter.getMaleName(father) + "\n");
        }
        return father;
    }

    /** получение гендера */
    private int getGender() {
        print("Enter gender ('m' or 'f'):\n");
        print(presenter.getGendersList());
        int gender = getIntegerInput(1, 2) - 1;
        print("You entered: " + presenter.getGender(gender) + "\n");
        return gender;
    }

    /** получение даты рождения */
    private LocalDate getDate() {
        print("Enter birthday (\"dd.MM.YYYY\"):\n");
        LocalDate date = getDateInput();
        print("You entered: " + formatter.format(date) + "\n");
        return date;
    }

    /** получение имени */
    private String getName() {
        print("Enter fullName:\n");
        String fullName = getStringInput();
        print("You entered: " + fullName + "\n");
        return fullName;
    }


    // #endregion
}