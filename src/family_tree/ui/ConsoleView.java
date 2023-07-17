package family_tree.ui;

import family_tree.familytree.FamilyTree;
import family_tree.familytree.FamilyTreeItem;
import family_tree.person.Person;
import family_tree.presenter.Presenter;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ConsoleView<T extends FamilyTreeItem<T>> implements View<T>{
    private Presenter<T> presenter;
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);

    }

    @Override
    public void start(FamilyTree<T> tree) {
        System.out.println("Добро пожаловать!");
        String data = "";
        while (true) {
            mainMenu();
            String action = scan();
            switch (action) {
                case "1" -> {
                    printTree();
                    action = action.concat(scan());
                    if (action.equals("14")) {
                        printTreeSort();
                        action = action.concat(scan());
                    }
                }
                case "2" -> data = addToTree();
                case "3" -> data = delFromTree();
                case "4" -> {
                    data = setParameters(tree);
                    action = data.split(",")[0].trim();
                    data = data.split(",")[1].trim();
                }
                case "5" -> {
                    data = setPeak(tree);
                    action = data.split(",")[0].trim();
                    data = data.split(",")[1].trim();
                }
                case "6" -> {
                    saveToFile();
                    action = action.concat(scan());
                    System.out.print("Задайте имя файла без формата -> ");
                    data = scanner.nextLine();
                }
                case "7" -> {
                    LoadFromFile();
                    action = action.concat(scan());
                    System.out.print("Задайте имя файла без формата -> ");
                    data = scanner.nextLine();
                    tree = presenter.getTree(action, data);
                }
                case "8" -> {
                    tree = presenter.getTree(action, data);
                }
                case "9" -> {
                    System.out.println("Завершение!");
                    System.exit(0);
                }
                default -> action = "ERROR";
            }
            if (!action.equals("ERROR")) {
                presenter.getInfo(action, data, tree);
            } else System.out.printf("%s %s\n", action, data);
        }
    }

    private void LoadFromFile() {
        System.out.println("Загрузить путем:\n" +
                "1. Object\n" +
                "2. ByteArray");
    }

    private void saveToFile() {
        System.out.println("Cохранить путем:\n" +
                "1. Object\n" +
                "2. ByteArray");
    }

    private String setPeak(FamilyTree<T> tree) {
        presenter.getInfo("51", "", tree);
        presenter.getInfo("11", "", tree);
        if (tree.getAllUnits().isEmpty()) {
            return "ERROR, дерево пусто";
        } else {
            System.out.print("Выберите \"главу\" дерева -> ");
            String index = scanner.nextLine();
            try {
                if (Integer.parseInt(index) < tree.getSize()) return "52" + "," + index;
                else {
                    return "ERROR, нет такого индекса\n";
                }
            } catch (NumberFormatException e) {
                return "ERROR, нет такого индекса\n";
            }
        }
    }

    private String setParameters(FamilyTree<T> tree) {
        presenter.getInfo("11", "", tree);
        System.out.print("Выберите для изменения -> ");
        String index = scanner.nextLine();
        try {
            if (Integer.parseInt(index) < tree.getSize()) {
                presenter.getInfo("4", index, tree);
                System.out.println("\nПараметры:\n" +
                        "1. Имя\n" +
                        "2. Дата рождения\n" +
                        "3. Дата смерти\n" +
                        "4. Пол\n" +
                        "5. Мама\n" +
                        "6. Папа\n" +
                        "7. Дети\n" +
                        "8. Доп. инфо");
                String action = scan();
                ParametersMenu(action);
    //        presenter.getInfo("4".concat(action), index, tree);
                return "4".concat(action) + "," + index;
            } else { return "ERROR, нет такого индекса\n"; }
        } catch (NumberFormatException e) {
            return "ERROR, нет такого индекса\n";
        }
    }

    private void ParametersMenu(String action) {
        System.out.print("Введите ");
        switch (action) {
            case "1" -> System.out.print("ФИО -> ");
            case "2", "3" -> System.out.print("Введите дату в формате YYYY M D -> ");
            case "4" -> {
                System.out.print("пол цифрой:\n");
                System.out.println("1. Женский\n" +
                                   "2. Мужской");
                System.out.print("-> ");
            }
            case "5" -> System.out.print("ФИО мамы -> ");
            case "6" -> System.out.print("ФИО папы -> ");
            case "7" -> System.out.print("ФИО ребенка -> ");
            case "8" -> System.out.print("доп. инфо -> ");
            default -> System.out.println("ERROR - нет такого действия");
        }
    }

    private String delFromTree() {
        System.out.print("Введите ФИО для удаления -> ");
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private String scan() {
        System.out.print("выберите действие -> ");
        return scanner.nextLine();
    }

    private void mainMenu() {
        repeat(60,"=");
        System.out.println("1. Вывести в консоль\n" +
                           "2. Добавить в дерево\n" +
                           "3. Удалить из дерева\n" +
                           "4. Изменить данные\n" +
                           "5. Установить \"главу\" дерева\n" +
                           "6. Сохранить в файл\n" +
                           "7. Загрузить из файла\n" +
                           "8. Очистить дерево\n" +
                           "9. Выход");
        repeat(60,"=");
    }

    private void printTree() {
        System.out.println("\n" +
                           "1. Всех - коротко (Имя д.р. возраст)\n" +
                           "2. Всех - полный вариант\n" +
                           "3. Найти по имени\n" +
                           "4. Отсортировать и вывести\n");
    }

    private void printTreeSort() {
        System.out.println("\n" +
                           "1. Имени \n" +
                           "2. Имени Reverse\n" +
                           "3. Возрасту\n" +
                           "4. Возрасту Reverse\n" +
                           "5. Дате рождения\n" +
                           "6. Дате рождения Reverse\n" +
                           "7. Количеству детей\n" +
                           "8. Количеству детей Reverse\n");
    }

    private String addToTree() {
        StringBuilder sb = new StringBuilder();
        System.out.print("Введите ФИО -> ");
        sb.append(scanner.nextLine()).append(",");
        System.out.print("Введите дату рождения в формате YYYY M D -> ");
        sb.append(scanner.nextLine()).append(",");
        System.out.println("Выберите пол:\n" +
                            "1. Женский\n" +
                            "2. Мужской");
        sb.append(scanner.nextLine());
        return sb.toString();
    }

    private void repeat(int count, String with) {
        System.out.println(new String(new char[count]).replace("\0", with));
    }
}
