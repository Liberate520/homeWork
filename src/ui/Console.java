package ui;

import familyTree.enums.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class Console implements ConsoleUI {
    private Scanner scanner;
    private Presenter presenter;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
    }

    @Override
    public void start() {
        start:
        {
            System.out.println("Старт программы");
            while (true) {
                //TODO решить проблему с текстовым блоком
                printMenu();
                switch (scan()) {

                    case "1": {
                        addPerson();
                        break;
                    }
                    case "2": {
                        presenter.getTreeInfo();
                        break;
                    }
                    case "3": {
                        presenter.saveTree("./src/familyTree/savedFiles/TreeOfHumans.bin");
                        break;
                    }
                    case "4": {
                        presenter.loadTree("./src/familyTree/savedFiles/TreeOfHumans.bin");
                        break;
                    }
                    case "5": {
                        presenter.sortGender();
                        break;
                    }
                    case "6": {
                        presenter.sortAge();
                        break;
                    }
                    case "7": {
                        presenter.sortName();
                        break;
                    }
                    case "8":{
                        System.out.println("Выберите родителя для ребенка(id)");
                        int idParent;
                        idParent = Integer.parseInt(scan());
                        System.out.println("Выберите ребенка(id)");
                        int idChild;
                        idChild = Integer.parseInt(scan());
                        presenter.addParent(idChild,idParent);
                        break;
                    }
                    case "q": {
                        break start;
                    }
                }
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Для выхода из программы нажмите: q\n\n" +
                           "Выберите пункт меню:\n" +
                           "1. Добавить человека в дерево\n" +
                           "2. Распечатать дерево\n" +
                           "3. Сохранить дерево\n" +
                           "4. Загрузить дерево\n" +
                           "Сортировать дерево по: полу(5), возрасту(6), имени(7)\n" +
                           "8. Добавить ребенка\n"
        );
    }

    private String scan() {
        return scanner.nextLine();
    }
    void addPerson(){
        String name, year, month, day, dYear, dMonth, dDay;
        Gender gender;
        System.out.println("Введите имя:");
        name = scan();
        System.out.println("Введите пол m/f");
        gender = !scan().equalsIgnoreCase("m") ?
                Gender.Female : Gender.Male;
        System.out.println("Введите дату рождения: год, месяц, день");
        year = scan();
        month = scan();
        day = scan();
        System.out.println("Дата смерти известна? e/n");
        if (scan().equals("e")) {
            System.out.println("Введите дату смерти: год, месяц, день");
            dYear = scan();
            dMonth = scan();
            dDay = scan();
            presenter.addPerson(name, gender,
                    LocalDate.of(
                            Integer.parseInt(year),
                            Integer.parseInt(month),
                            Integer.parseInt(day)),
                    LocalDate.of(
                            Integer.parseInt(dYear),
                            Integer.parseInt(dMonth),
                            Integer.parseInt(dDay)));
        } else {
            presenter.addPerson(name, gender,
                    LocalDate.of(
                            Integer.parseInt(year),
                            Integer.parseInt(month),
                            Integer.parseInt(day)),
                    null);
        }
    }
}
