package ui;

import presenter.Presenter;

import java.util.Date;
import java.util.Scanner;

public class Console implements View {
    private Scanner iScan;
    private Presenter presenter;
    private boolean work;

    @Override
    public void start() {
        this.iScan = new Scanner(System.in);

        this.work = true;
        while (this.work) {
            printMenu();
            System.out.print("Введите команду: ");
            String command = iScan.nextLine();
            if (checkInput(command)) {
                int com = Integer.parseInt(command);
                switch (com) {
                    case 0 -> {
                        System.out.println("Выход");
                        finish();
                    }
                    case 1 -> {
                        addNewPerson();
                    }
                    case 2 -> {
                        System.out.print("Введите ID персоны для удаления: ");
                        String idStr = this.iScan.nextLine();
                        if (checkInput(idStr)) {
                            int id = Integer.parseInt(idStr);
                            System.out.println(this.presenter.deletePerson(id));
                        } else {
                            System.out.println("Необходимо ввести ID");
                        }
                    }
                    case 3 -> {
                        System.out.print("Относительно какого ID построить дерево: ");
                        String idStr = this.iScan.nextLine();
                        if (checkInput(idStr)) {
                            int id = Integer.parseInt(idStr);
                            System.out.println(presenter.showTree(id));
                        } else {
                            System.out.println("Необходимо ввести ID");
                        }
                    }
                    case 4 -> {
                        System.out.println("Список: ");
                        System.out.println(this.presenter.getListPerson());
                    }
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                                    
                Команды:
                1. Добавить персону в дерево
                2. Удалить персону
                3. Построить дерево
                4. Список всех персон
                ================================
                0. Выход
                """);
    }

    private void addNewPerson() {
        System.out.println("Добавление персоны.");
        System.out.print("Введите имя: ");
        String nameNewPerson = this.iScan.nextLine();
        System.out.print("Введите фамилию: ");
        String surnameNewPerson = this.iScan.nextLine();

        System.out.print("Дата рождения в формате дд-мм-гггг: ");
        Date birthDate = parseStrToDate(this.iScan.nextLine());

        System.out.print("Дата смерти в формате дд-мм-гггг: ");
        Date deathDate = parseStrToDate(this.iScan.nextLine());

        System.out.print("id матери: ");
        Integer idMother = parseStrToID(iScan.nextLine());
        System.out.print("id отца: ");
        Integer idFather = parseStrToID(iScan.nextLine());
        System.out.print("id супруга(и): ");
        Integer idPartner = parseStrToID(iScan.nextLine());

        System.out.println(presenter.addPerson(nameNewPerson, surnameNewPerson,
                birthDate, deathDate,
                idMother, idFather, idPartner));
    }

    private Integer parseStrToID (String str) {
        return checkInput(str) ? Integer.parseInt(str) : null;
    }

    private Date parseStrToDate (String str) {
        boolean correct = true;
        String[] strArr = str.split("-");
        for (String e:strArr) {
            if (!checkInput(e)) {
                correct = false;
                break;
            }
        }
        return correct ? new Date(Integer.parseInt(strArr[2]) - 1900,
                Integer.parseInt(strArr[1]) - 1, Integer.parseInt(strArr[0])) : null;
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    public void finish() {
        this.iScan.close();
        this.work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
