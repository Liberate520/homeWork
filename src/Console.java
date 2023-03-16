import java.text.ParseException;
import java.util.Scanner;

public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Не верный номер команды.");
            }
        }
    }

    private boolean checkInput(String text) {
        if (text.matches("[0-9]+")) {
            return Integer.parseInt(text) <= menu.getCommands().size();
        } else {
            return false;
        }
    }

    private void hello() {
        System.out.print(menu.printMenu());
        print("Выберите команду -> ");
    }

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    public void finish() {
        work = false;
    }

    public void addEntry() {
        System.out.print("Фамилия -> ");
        String lastname = scanner.nextLine();
        System.out.print("Имя -> ");
        String firstname = scanner.nextLine();
        System.out.print("Отчество -> ");
        String patronymic = scanner.nextLine();
        String gender = enterGender();
        System.out.print("Имя отца -> ");
        String fatherName = scanner.nextLine();
        System.out.print("Имя матери -> ");
        String motherName = scanner.nextLine();
        if (presenter.addEntry(lastname, firstname, patronymic, gender, fatherName, motherName)) {
            System.out.println("Добавлено в дерево.");
        }
    }

    public void showEntry() {
        System.out.print("Фамилия -> ");
        String lastname = scanner.nextLine();
        System.out.print("Имя -> ");
        String firstname = scanner.nextLine();
        presenter.showEntry(lastname, firstname);
        System.out.println();
        System.out.println();
    }

    public void showAllEntries() {
        presenter.showAllEntries();
        System.out.println();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public String enterGender() {
        String gender = "";
        boolean validGender = false;
        while (!validGender) {
            System.out.print("Пол (м/ж) -> ");
            gender = scanner.nextLine();
            validGender = gender.equalsIgnoreCase("м") ||
                    gender.equalsIgnoreCase("ж");
        }
        return gender;
    }

    public void save() {
        presenter.save();
        print("Сохранено.");
    }

    public void load() {
        presenter.load();
        showAllEntries();
    }
}