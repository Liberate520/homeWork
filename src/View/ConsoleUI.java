package View;

import java.util.Scanner;

import Presenter.Presenter;

public class ConsoleUI implements View {
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
        System.out.print(
                "Хотите сохранить изменения в дереве:\n [1] - Да\n [2] - Нет\n--> ");
        String choise = scanner.nextLine();
        if (choise.equals("1")) {
            saveTree();
            System.out.println("До новых встреч!");
            work = false;
        } else if (choise.equals("2")) {
            System.out.println("До новых встреч!");
            work = false;
        } else
            inputError();
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

    public String[] checkDate(String text) {
        String[] dateArray = {};
        do {
            System.out.print(text);
            String dateString = scanner.nextLine();
            dateArray = dateString.split("\\.");
        } while (!(Integer.parseInt(dateArray[0]) < 32 & Integer.parseInt(dateArray[1]) < 13));
        return dateArray;
    }

    public String checkItem(String text) {
        String name = "";
        do {
            System.out.print(text);
            name = scanner.nextLine();
        } while (!presenter.checkItem(name));
        return name;
    }

    private void printMenu() {
        System.out.print(menu.menu());
    }

    @Override
    public void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public void addItem() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        String[] birthDateArray = checkDate("Укажите дату рождения в формате dd.MM.yyyy: ");
        String genderScanner;
        String genderString = "Male";
        System.out.print("Укажите пол\n [1] - Мужской\n [2] - Женский\n --> ");
        genderScanner = scanner.nextLine();
        if (genderScanner.equals("1")) {
            genderString = "Male";
        } else if (genderScanner.equals("2")) {
            genderString = "Female";
        } else {
            inputError();
            System.out.println("Установлено значение по умолчанию.");
        }
        if (presenter.addItem(name, birthDateArray, genderString)) {
            System.out.println("Добавление прошло успешно!");
        } else {
            System.out.println("Такая запись уже присутсвует в дереве.");
        }
    }

    public void setDeathDate() {
        String name = checkItem("Введите имя, кому надо добавить дату смерти: ");
        String[] deathDateArray = {};
        do {
            deathDateArray = checkDate("Укажите дату смерти в формате dd.MM.yyyy: ");
            if (presenter.setDeathDate(name, deathDateArray)) {
                System.out.println("Добавление даты смерти прошло успешно!");
            } else {
                System.out.println("Добавление не удалось.\nДата смерти меньше даты рождения.");
            }
        } while (!presenter.setDeathDate(name, deathDateArray));
    }

    public void addFamily() {
        String nameParent1 = checkItem("Введите имя первого родителя: ");
        String nameParent2 = checkItem("Введите имя второго родителя: ");
        String nameChild = checkItem("Введите имя ребенка: ");
        if (presenter.createFamily(nameParent1, nameParent2, nameChild)) {
            System.out.println("Создание связей прошло успешно!");
        } else {
            System.out.println("При создании связей произошла ошибка.");
        }
    }

    public void addChild() {
        String nameParent = checkItem("Введите имя родителя: ");
        String nameChild = checkItem("Введите имя ребенка: ");
        if (presenter.addChild(nameParent, nameChild)) {
            System.out.println("Добавление ребенка прошло успешно!");
        } else {
            System.out.println("Этот ребенок уже добавлен.");
        }
    }

    public void addParents() {
        String nameChild = checkItem("Введите имя ребенка: ");
        String nameParent1 = checkItem("Введите имя первого родителя: ");
        String nameParent2 = checkItem("Введите имя второго родителя: ");
        if (presenter.addParents(nameChild, nameParent1, nameParent2)) {
            System.out.println("Добавление родителей прошло успешно!");
        } else {
            System.out.println("При добавлении родителей произошла ошибка.");
        }
    }

    public void findItem() {
        String name = checkItem("Введите имя, кого ищем: ");
        System.out.println(presenter.findItem(name));
    }

    public void showAllTree() {
        System.out.print(
                "По какойму принципу отсортировать вывод: \n [1] - по имени\n [2] - по дате рождения\n [3] - по возрасту\n [ ] - не сортировать\n-->");
        String sortBy = scanner.nextLine();
        System.out.println(presenter.getFamilyTreeInfo(sortBy));
    }

    public void deleteItem() {
        String name = checkItem("Введите имя, кого надо удалить: ");
        if (presenter.deleteItem(name)) {
            System.out.println("Удаление прошло успешно!");
        } else {
            System.out.println("Такой записи в дереве нет.");
        }
    }

    public void saveTree() {
        if (presenter.saveTree("FamilyTree.out")) {
            System.out.println("Сохранение дерева прошло успешно!");
        } else {
            System.out.println("При сохранении дерева произошла ошибка!");
        }
    }

    public void loadTree() {
        if (presenter.loadTree("FamilyTree.out")) {
            System.out.println("Загрузка дерева прошла успешно!");
        } else {
            System.out.println("При загрузке дерева произошла ошибка!");
        }
    }
}
