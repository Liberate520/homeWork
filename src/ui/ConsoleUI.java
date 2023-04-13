package ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            mainRequests();
        }
    }

    public void mainRequests() {
        System.out.println("Введите что хотите сделать:\n" +
                "1 - Создать генеалогическое древо\n" +
                "2 - Редактировать существующее генеалогическое древо\n" +
                "3 - Загрузить существующие генеалогические деревья\n" +
                "4 - Сохранить существующие генеалогические деревья\n" +
                "5 - Вывести на экран информацию по всем существующим генеалогическим деревьям");
        switch (scanner.nextLine()) {
            case "1":
                do {
                    newFTree();
                } while (goToUpRequest());
                break;
            case "2":
                do {
                    requestEdit();
                } while (goToUpRequest());
                break;
            case "3":
                requestLoad();
                break;
            case "4":
                requestSave();
                break;
            case "5":
                requestPrint();
                break;
            default:
                System.out.println("Введено что-то отличное от 1, 2, 3, 4 или 5.");
                break;
        }
    }

    public boolean goToUpRequest() {
        System.out.println("Для поднятия выше по меню введите 1:");
        switch (scanner.nextLine()) {
            case "1":
                return false;
            default:
                return true;
        }
    }

    private void newFTree() {
        String typeFTree = requestType();
        String fTreeName = requestName();
        if (presenter.addFamilyTree(typeFTree, fTreeName)){
            editTree();
        }
    }

    private void requestEdit() {
        String fTreeName = requestName();
        if (presenter.isFindFamilyTree(fTreeName)) {
            editTree();
        } else {
            System.out.println("Генеалогическое древо с таким именем не найдено.");
        }
    }

    private void editTree() {
        do {
            requests();
            presenter.editFTree();
        } while (goToUpRequest());
    }

    private void requests(){
        System.out.println("Введите что хотите сделать c генеалогическим древом:\n" +
                "1 - Создать нового члена семьи\n" +
                "2 - Добавить одному члену семьи в качестве ребенка другого члена семьи\n" +
                "3 - Связать в качестве мужа/жены одного члена семьи с другим членом семьи (для людей)");
        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Введите имя нового члена семьи:");
                presenter.addMember();
                break;
            case "2":

                break;
            case "3":

                break;
            default:
                System.out.println("Введено что-то отличное от 1 или 2.");
                break;
        }
    }

    private void requestLoad() {
        System.out.println("Введите имя файла:");
        presenter.load(scanner.nextLine());
    }

    private void requestSave() {
        System.out.println("Введите имя файла:");
        presenter.save(scanner.nextLine());
    }

    private String requestName() {
        System.out.println("Введите имя генеалогического древа:");
        return scanner.nextLine();
    }

    private String requestType() {
        System.out.println("Введите тип генеалогического древа (1 - для людей или 2 - для собак):");
        switch (scanner.nextLine()) {
            case "1":
                return "person";
            case "2":
                return "dog";
            default:
                System.out.println("Введено отличное от 1 или 2.");
                return requestType();
        }
    }

    private void requestPrint() {
        System.out.println("В каком виде вывести информацию на экран (1 - список или 2 - древо):");
        switch (scanner.nextLine()) {
            case "1":
                presenter.printInfo();
                break;
            case "2":
                presenter.printFTrees();
                break;
            default:
                System.out.println("Введено отличное от 1 или 2.");
                requestPrint();
                break;
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
