package ui;

import presenter.Presenter;

import java.util.ArrayList;
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
                            print(this.presenter.deletePerson(id));
                        } else {
                            System.out.print("Необходимо ввести ID");
                        }
                    }
                    case 3 -> {
                        System.out.print("Относительно какого ID построить дерево: ");
                        String idStr = this.iScan.nextLine();
                        if (checkInput(idStr)) {
                            int id = Integer.parseInt(idStr);
                            print(presenter.showTree(id));
                        } else {
                            System.out.print("Необходимо ввести ID");
                        }
                    }
                    case 4 -> {
                        System.out.println("Список: ");
                        print(this.presenter.getListPerson());
                    }
                    case 5 -> {
                        System.out.print("Имя файла для сохранения: ");
                        String fNameForSave = this.iScan.nextLine();
                        print(presenter.saveToFile(fNameForSave));
                    }
                    case 6 -> {
                        System.out.println("Загрузить из файла: ");
                        ArrayList<String> filesForLoad = presenter.loadFiles();
                        print(filesForLoad.get(1));
                        if (filesForLoad.get(0).equals("OK")) {
                            System.out.print("Введите номер файла из которого загрузить дерево (0 - для отмены): ");
                            String numberFile = this.iScan.nextLine();
                            if (checkInput(numberFile)) {
                                int id = Integer.parseInt(numberFile);
                                if (id == 0) System.out.println("Отмена.");
                                else print(presenter.loadFromFile(id));
                            } else {
                                System.out.print("Необходимо ввести номер файла из списка");
                            }
                        }
                    }
                    case 7 -> {
                        print(presenter.generateSampleTree());
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
                                
                5. Сохранить дерево в файл
                6. Загрузить дерево из файла
                                
                7. Сгенерировать дерево
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

    private Integer parseStrToID(String str) {
        return checkInput(str) ? Integer.parseInt(str) : null;
    }

    private Date parseStrToDate(String str) {
        boolean correct = true;
        String[] strArr = str.split("-");
        for (String e : strArr) {
            if (!checkInput(e)) {
                correct = false;
                break;
            }
        }
        if (strArr.length != 3) correct = false;
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

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
