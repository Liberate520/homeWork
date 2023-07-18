package View;

import java.util.Scanner;

import Presenter.Presenter;

public class ConsoleUI {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in, "cp866");
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void work() {
        hello();
        loadTree();
        while (work) {
            printMenu();
            execute();
        }
    }

    private void hello() {
        System.out.println("Добро пожаловать!\nРабота с генеалогическим древом.");
    }

    public void goodbye() {
        System.out.println("До новых встреч!");
        work = false;
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public boolean checkDate(String[] dateArray) {
        if (Integer.parseInt(dateArray[0]) < 32 & Integer.parseInt(dateArray[1]) < 13) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.print(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public void addItem() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        String[] birthDateArray = {};
        do {
            System.out.print("Укажите дату рождения в формате dd.MM.yyyy: ");
            String birthDateString = scanner.nextLine();
            birthDateArray = birthDateString.split("\\.");
        } while (!checkDate(birthDateArray));
        int genderScanner;
        String genderString = "Male";
        System.out.print("Укажите пол\n [1] - Мужской\n [2] - Женский\n --> ");
        genderScanner = Integer.parseInt(scanner.nextLine());
        if (genderScanner == 1) {
            genderString = "Male";
        } else if (genderScanner == 2) {
            genderString = "Female";
        } else
            inputError();
        if (presenter.addItem(name, birthDateArray, genderString)) {
            System.out.println("Добавление прошло успешно!");
        } else {
            System.out.println("Такая запись уже присутсвует в дереве.");
        }
    }

    public void setDeathDate() {
        System.out.print("Введите имя, кому надо добавить дату смерти: ");
        String name = scanner.nextLine();
        String[] deathDateArray = {};
        do {
            do {
                System.out.print("Укажите дату смерти в формате dd.MM.yyyy: ");
                String deathDateString = scanner.nextLine();
                deathDateArray = deathDateString.split("\\.");
            } while (!checkDate(deathDateArray));
            if (presenter.setDeathDate(name, deathDateArray)) {
                System.out.println("Добавление даты смерти прошло успешно!");
            } else {
                System.out.println("Добавление не удалось.\nДата смерти меньше даты рождения.");
            }
        } while (!presenter.setDeathDate(name, deathDateArray));
    }

    public void addFamily() {
        System.out.print("Введите имя первого родителя: ");
        String nameParent1 = scanner.nextLine();
        System.out.print("Введите имя второго родителя: ");
        String nameParent2 = scanner.nextLine();
        System.out.print("Введите имя ребенка: ");
        String nameChild = scanner.nextLine();
        if (presenter.createFamily(nameParent1, nameParent2, nameChild)) {
            System.out.println("Создание связей прошло успешно!");
        } else {
            System.out.println("При создании связей произошла ошибка.");
        }
    }

    public void addChild() {
        System.out.print("Введите имя родителя: ");
        String nameParent = scanner.nextLine();
        System.out.print("Введите имя ребенка: ");
        String nameChild = scanner.nextLine();
        if (presenter.addChild(nameParent, nameChild)) {
            System.out.println("Добавление ребенка прошло успешно!");
        } else {
            System.out.println("Этот ребенок уже добавлен.");
        }
    }

    public void addParents() {
        System.out.print("Введите имя ребенка: ");
        String nameChild = scanner.nextLine();
        System.out.print("Введите имя первого родителя: ");
        String nameParent1 = scanner.nextLine();
        System.out.print("Введите имя второго родителя: ");
        String nameParent2 = scanner.nextLine();
        if (presenter.addParents(nameChild, nameParent1, nameParent2)) {
            System.out.println("Добавление родителей прошло успешно!");
        } else {
            System.out.println("При добавлении родителей произошла ошибка.");
        }
    }

    public void findItem() {
        System.out.print("Введите имя, кого ищем: ");
        String name = scanner.nextLine();
        System.out.println(presenter.findItem(name));
    }

    public void showAllTree() {
        System.out.print(
                "По какойму принципу отсортировать вывод: \n [1] - по имени\n [2] - по дате рождения\n [3] - по возрасту\n [ ] - не сортировать\n-->");
        String sortBy = scanner.nextLine();
        System.out.println(presenter.getFamilyTreeInfo(sortBy));
    }

    public void deleteItem() {
        System.out.print("Введите имя, кого надо удалить: ");
        String name = scanner.nextLine();
        if (presenter.deleteItem(name)) {
            System.out.println("Удаление прошло успешно!");
        } else {
            System.out.println("Такой записи в дереве нет.");
        }
    }

    public void saveTree() {
        if (presenter.saveTree("Projects_OOP/Projects_OOP_HomeWork/src/FamilyTree.out")) {
            System.out.println("Сохранение дерева прошло успешно!");
        } else {
            System.out.println("При сохранении дерева произошла ошибка!");
        }
    }

    public void loadTree() {
        if (presenter.loadTree("Projects_OOP/Projects_OOP_HomeWork/src/FamilyTree.out")) {
            System.out.println("Загрузка дерева прошла успешно!");
        } else {
            System.out.println("При загрузке дерева произошла ошибка!");
        }
    }
}
