package UI;

import java.io.IOException;
import java.util.Scanner;
import presenter.Presenter;

public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    @Override
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Ошибка ввода\n");
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

    public void addNewHuman() {
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
        if (presenter.addNewHuman(lastname, firstname, patronymic, gender, fatherName, motherName)) {
            System.out.println("Запись добавлена в дерево\n");
        }
    }

    public void findHuman() {
        System.out.print("Фамилия -> ");
        String lastname = scanner.nextLine();
        System.out.print("Имя -> ");
        String firstname = scanner.nextLine();
        presenter.findHuman(lastname, firstname);
        System.out.println();
        System.out.println();
    }

    public void printTree() {
        presenter.printTree();
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

    public void save() throws IOException {
        presenter.save();
        print("Сохранено\n");
    }

    public void load() throws IOException, ClassNotFoundException {
        presenter.load();
        printTree();
    }
}