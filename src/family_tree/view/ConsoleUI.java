package family_tree.view;

import family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать! Укажите номер пункта меню:");
        while (work) {
            printMenu();
            choice();
        }
    }

    private void choice() {
        String strChoice = scanner.nextLine();
        if (isNumeric(strChoice)) {
            int choice = Integer.parseInt(strChoice);
            if (choiceInMenu(choice)) {
                menu.execute(choice);
            }
        }
    }

    private boolean choiceInMenu(int choice) {
        if (choice <= menu.size()) {
            return true;
        } else {
            errorText();
            return false;
        }
    }

    public boolean isNumeric(String str) {
        if (str.matches("[0-9]+")) {
            return true;
        } else {
            errorText();
            return false;
        }
    }

    private void errorText() {
        System.out.println("Введено неверное значение");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void finish() {
        System.out.println("Ждем вас снова!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTreeMembers() {
        presenter.getFamilyTreeMembers();
    }

    public void addFamilyMember() {
        System.out.println("Введите пол члена семьи (Male или Female):");
        String gender = scanner.nextLine();
        System.out.println("Введите имя члена семьи:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию члена семьи:");
        String familyName = scanner.nextLine();
        System.out.println("Введите через тире год, месяц и день рождения члена семьи (например, 2000-01-31):");
        String strDate = scanner.nextLine();
        presenter.addFamilyMember(gender, name, familyName, strDate);
    }

    @Override
    public void printAnswer(String answer) {
        if (answer != null) {
            System.out.println(answer);
        } else {
            errorText();
        }
    }

    public void saveTreeToFile() {
        System.out.printf("Данные успешно сохранены в файл? - %b\n", presenter.saveTreeToFile());
    }

    public void getTreeFromFile() {
        presenter.getTreeFromFile();
    }

    public void setWedding() {
        System.out.println("Введите ID первого супруга:");
        String strHumanId1 = scanner.nextLine();
        if (isNumeric(strHumanId1)) {
            long humanId1 = Integer.parseInt(strHumanId1);
            System.out.println("Введите ID второго супруга:");
            String strHumanId2 = scanner.nextLine();
            if (isNumeric(strHumanId1)) {
                long humanId2 = Integer.parseInt(strHumanId2);
                presenter.setWedding(humanId1, humanId2);
            }
        }
    }

    public void setFather() {
        System.out.println("Введите ID ребенка:");
        String strChildId = scanner.nextLine();
        if (isNumeric(strChildId)) {
            long childId = Integer.parseInt(strChildId);
            System.out.println("Введите ID отца:");
            String strFatherId = scanner.nextLine();
            if (isNumeric(strFatherId)) {
                long fatherId = Integer.parseInt(strFatherId);
                presenter.setFather(childId, fatherId);
            }
        }
    }

    public void setMother() {
        System.out.println("Введите ID ребенка:");
        String strChildId = scanner.nextLine();
        if (isNumeric(strChildId)) {
            long childId = Integer.parseInt(strChildId);
            System.out.println("Введите ID матери:");
            String strMotherId = scanner.nextLine();
            if (isNumeric(strMotherId)) {
                long motherId = Integer.parseInt(strMotherId);
                presenter.setMother(childId, motherId);
            }
        }
    }

    public void getChildrenList() {
        System.out.println("Введите ID родителя:");
        String strParent = scanner.nextLine();
        if (isNumeric(strParent)) {
            long parentId = Integer.parseInt(strParent);
            presenter.getChildrenList(parentId);
        }
    }
}