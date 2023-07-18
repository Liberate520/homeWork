package family_tree.view;
import family_tree.presenter.Presenter;
import family_tree.view.menu.Menu;
import family_tree.view.menu.Menu_relatives;
import family_tree.view.menu.Menu_sortBy;

import java.util.Scanner;
public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "\nВы ввели неверное значение\n";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final Menu menu;
    private final Menu_sortBy menu_sortBy;
    private final Menu_relatives menu_relatives;
    private String menu_current;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
        menu_sortBy = new Menu_sortBy(this);
        menu_relatives = new Menu_relatives(this);
        menu_current = "menu";
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("\nСЕМЕЙНОЕ ДРЕВО.\n");
        while (work){
            menu_current = "menu";
            menu_choice(menu_current);
        }
    }

    public void menu_choice(String menu_current){
        switch (menu_current) {
            case "menu" -> System.out.println(menu.printMenu());
            case "menu_sortBy" -> System.out.println(menu_sortBy.printMenu());
            case "menu_relatives" -> System.out.println(menu_relatives.printMenu());
        }
        execute(menu_current);
    }

    private void execute(String menu_current){
        System.out.print("Введите цифру соответствующего пункта меню: ");
        String string = scanner.nextLine();
        if (checkTextForInt(string)){
            int numCommand = Integer.parseInt(string);
            if (checkCommand(numCommand, menu_current)){
                switch (menu_current) {
                    case "menu" -> menu.execute(numCommand);
                    case "menu_sortBy" -> menu_sortBy.execute(numCommand);
                    case "menu_relatives" -> menu_relatives.execute(numCommand);

                }
            }
        }
    }


    private boolean checkTextForInt(String string){
        if (string.matches("[1-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, String menu_current){
        int size = 1;
        switch (menu_current) {
            case "menu" -> size = menu.getSize();
            case "menu_sortBy" -> size = menu_sortBy.getSize();
            case "menu_relatives" -> size = menu_relatives.getSize();

        }
        if (numCommand <= size){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void finish() {
        System.out.println("\nСЕМЕЙНОЕ ДРЕВО. Программа закрыта.\n");
    }



    public void treeInfo_sortByID() {
        presenter.treeInfo_sortByID();
    }

    public void treeInfo_sortByAge() {
        presenter.treeInfo_sortByAge();
    }

    public void treeInfo_sortByName() {
        presenter.treeInfo_sortByName();
    }

    public void add_human(){
        System.out.println("\nВвод данных нового человека.");
        System.out.print("Фамилия: ");
        String surname = scanner.nextLine().trim();
        System.out.print("Имя: ");
        String first_name = scanner.nextLine().trim();
        System.out.print("Отчество: ");
        String patronymic = scanner.nextLine().trim();
        System.out.print("Дата рождения (dd.mm.yyyy): ");
        String day_birth = scanner.nextLine().trim();
        System.out.print("Пол (по умолчанию M, для смены пола введите любой символ: ");
        String gender  = scanner.nextLine().trim();
        presenter.add_human(surname, first_name, patronymic, gender, day_birth);
    }

    public void loadFamily_tree() {
        System.out.print("""

                Загрузка данных из файла. Текущий список будет удален.
                Для подтверждения введите "Yes":\s""");
        String str2 = scanner.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            System.out.println("Загружено семейное древо:");
            presenter.loadFamily_tree();
            treeInfo_sortByID();
        } else {
            System.out.println("Действие отменено.");
        }
    }

    public void clearFamilyTree() {
        System.out.print("""

                Семейное древо будет очищено.
                Для подтверждения введите "Yes":\s""");
        String str2 = scanner.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            presenter.clearFamilyTree();
            System.out.println("\nСемейное древо успешно очищено\n");
        } else {
            System.out.println("\nДействие отменено.\n");
        }
    }

    public void saveFamilyTree() {
        System.out.print("""

                Сохранение в файл. Данные в файле будут заменены.
                Для подтверждения введите "Yes":\s""");
        String str = scanner.nextLine();
        if (str.equalsIgnoreCase("Yes")){
            System.out.println("Загружаю в файл следующее семейное древо:\n");
            treeInfo_sortByID();
            if (presenter.saveFamily_tree()){
                System.out.println("\nСемейное древо успешно сохранено в файл.\n");
            } else {
                System.out.println("\nЧто-то пошло не так.\n");
            }
        } else {
            System.out.println("\nДействие отменено.\n");
        }

    }

    public String get_reply(String string_request) {
        System.out.print(string_request);
        return scanner.nextLine();
    }

    public void exit() {
        work = false;
    }

    public void parents_finder() {
        presenter.parents_finder();
    }

    public void adoption() {
        presenter.adoption();
    }

    public void marriage() {
        presenter.marriage();
    }


}
