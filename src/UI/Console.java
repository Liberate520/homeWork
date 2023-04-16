package UI;

import FamilyTree.FamilyTree;
import Human.Human;
import Presenter.Presenter;
import UI.Commands.ChangeInfo.MenuChangeInfo;
import UI.Commands.GetFamilyTree.MenuGetFamilyTree;
import UI.Commands.GetHumanInfo.MenuGetHumanInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;
    private FamilyTree<Human> tree;
    private MenuChangeInfo menuChangeInfo;
    private MenuGetFamilyTree menuGetFamilyTree;
    private MenuGetHumanInfo menuGetHumanInfo;

    public Console(FamilyTree<Human> tree) {
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
        this.tree = tree;
        this.menuChangeInfo = new MenuChangeInfo(this);
        this.menuGetFamilyTree = new MenuGetFamilyTree(this);
        this.menuGetHumanInfo = new MenuGetHumanInfo(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);

    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)) {
                menu.execute(Integer.parseInt(choice));
            } else {
                fail();
            }

        }
    }

    public void returnToMenu() {
        start();
    }


    private boolean check(String text) {
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0;
    }

    private boolean checkAdd(String text) {
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menuChangeInfo.getSize() && Integer.parseInt(text) > 0;
    }

    private boolean checkGetInfo(String text) {
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menuGetFamilyTree.getSize() && Integer.parseInt(text) > 0;
    }

    private boolean checkHumanInfo(String text) {
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menuGetHumanInfo.getSize() && Integer.parseInt(text) > 0;
    }

    public void fail() {
        System.out.println("Ошибка ввода!");
    }

    public void finish() {
        System.out.println("Работа программы завершена");
        work = false;
    }

    public void addHuman() {
        System.out.println("Введите статус: ");
        String status = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения в формате ГГГГ ММ ДД: ");
        String[] date = scanner.nextLine().split(" ");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                Integer.parseInt(date[2]));
        System.out.println("Введите имя матери: ");
        String motherName = scanner.nextLine();
        System.out.println("Введите фамилию матери: ");
        String motherSurname = scanner.nextLine();
        Human mother = null;
        if ((motherName != null) && (motherSurname != null)) mother = tree.getHuman(motherName, motherSurname);
        System.out.println("Введите имя отца: ");
        String fatherName = scanner.nextLine();
        System.out.println("Введите фамилию отца: ");
        String fatherSurname = scanner.nextLine();
        Human father = null;
        if ((fatherName != null) && (fatherSurname != null)) father = tree.getHuman(fatherName, fatherSurname);
        presenter.addHuman(status, name, surname, birthDate, mother, father);
        System.out.printf("Человек %s %s добавлен\n", name, surname);
    }

    public void getFamilyTree() {
        System.out.println(menuGetFamilyTree.print());
        String choice = scanner.nextLine();
        if (checkGetInfo(choice)) {
            menuGetFamilyTree.execute(Integer.parseInt(choice));
        } else {
            fail();
        }
    }

    public void saveChanges() throws IOException {
        presenter.saveChanges();
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    //   Методы изменения информации

    public String enterName() {
        System.out.println("Введите имя учетной записи: ");
        String name = scanner.nextLine();
        return name;
    }

    public String enterSurname() {
        System.out.println("Введите  фамилию учетной записи: ");
        String surname = scanner.nextLine();
        return surname;
    }

    public void setStatus() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.println("Введите новый статус: ");
            String newStatus = scanner.nextLine();
            presenter.setStatus(name, surname, newStatus);
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void setName() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.println("Введите новое имя: ");
            String newName = scanner.nextLine();
            presenter.setName(name, surname, newName);
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void setSurname() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.println("Введите новую фамилию: ");
            String newSurname = scanner.nextLine();
            presenter.setSurname(name, surname, newSurname);
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void setBirthDate() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.println("Введите новую дату рождения в формате ГГГГ ММ ДД: ");
            String[] date = scanner.nextLine().split(" ");
            presenter.setBirthDate(name, surname, Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                    Integer.parseInt(date[2]));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void setMother() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.println("Введите имя матери: ");
            String motherName = scanner.nextLine();
            System.out.println("Введите фамилию матери: ");
            String motherSurname = scanner.nextLine();
            presenter.setMother(name, surname, motherName, motherSurname);
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void setFather() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.println("Введите имя отца: ");
            String fatherName = scanner.nextLine();
            System.out.println("Введите фамилию отца: ");
            String fatherSurname = scanner.nextLine();
            presenter.setFather(name, surname, fatherName, fatherSurname);
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }


    public void changeInfo() {
        while (work) {
            System.out.println(menuChangeInfo.print());
            String choice = scanner.nextLine();
            if (checkAdd(choice)) {
                menuChangeInfo.execute(Integer.parseInt(choice));
            } else {
                fail();
            }
        }
    }

    public void printByName() {
        presenter.sortByName();
        System.out.println(presenter.getFamilyTree());
        System.out.println();
    }

    public void printByBirthDate() {
        presenter.sortByBirthDate();
        System.out.println(presenter.getFamilyTree());
        System.out.println();
    }

    public void printByID() {
        presenter.sortByID();
        System.out.println(presenter.getFamilyTree());
        System.out.println();
    }

    public void removeHuman() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            presenter.removeHuman(name, surname);
            System.out.printf("Запись %s %s удалена из генеалогического дерева\n", name, surname);
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void getHumanInfo() {
        while (work) {
            System.out.println(menuGetHumanInfo.print());
            String choice = scanner.nextLine();
            if (checkHumanInfo(choice)) {
                menuGetHumanInfo.execute(Integer.parseInt(choice));
            } else {
                fail();
            }
        }
    }

    public void getHuman() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.printf("Общие сведения о %s %s:", surname, name);
            System.out.println(presenter.getHuman(name, surname));
            System.out.print("дети: ");
            System.out.println(presenter.getChildren(name, surname));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void getStatus() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.printf("%s %s. Статус: ", name, surname);
            System.out.println(presenter.getStatus(name, surname));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void getBirthDate() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.printf("%s %s. День рождения: ", name, surname);
            System.out.println(presenter.getBirthDate(name, surname));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void getMother() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.printf("%s %s. Мать: ", name, surname);
            System.out.println(presenter.getMother(name, surname));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void getFather() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.printf("%s %s. Отец: ", name, surname);
            System.out.println(presenter.getFather(name, surname));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }

    public void getChildren() {
        String name = enterName();
        String surname = enterSurname();
        if (tree.containsOf(name, surname)) {
            System.out.printf("%s %s. Дети: ", name, surname);
            System.out.println(presenter.getChildren(name, surname));
        } else {
            System.out.println("Учетная запись с такими данными не существует!");
        }
    }
}

