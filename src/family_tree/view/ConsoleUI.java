package family_tree.view;
import family_tree.presenter.Presenter;

import java.util.Scanner;
public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "\nВы ввели неверное значение\n";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final Menu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("\nСЕМЕЙНОЕ ДРЕВО.\n");
        while (work){
            printMenu();
            execute();
        }
    }

    private void printMenu() {
        System.out.println(menu.printMenu());
    }


    private void execute(){
        System.out.print("Введите цифру соответствующего пункта меню: ");
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }


    private boolean checkTextForInt(String text){
        if (text.matches("[1-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
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

    public void load_file() {
        System.out.print("\nЗагрузка данных из файла. Текущий список будет удален.\n" +
                "Для подтверждения введите \"Yes\": ");
        String str2 = scanner.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            System.out.println("Загружено семейное древо:");
            presenter.setFamily_tree();
            treeInfo_sortByID();
        } else {
            System.out.println("Действие отменено.");
        }
    }

    public void clearFamilyTree() {
        System.out.print("\nСемейное древо будет очищено.\n" +
                "Для подтверждения введите \"Yes\": ");
        String str2 = scanner.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            presenter.clearFamilyTree();
            System.out.println("\nСемейное древо успешно очищено\n");
        } else {
            System.out.println("\nДействие отменено.\n");
        }
    }

    public void saveFamilyTree() {
        System.out.print("\nСохранение в файл. Данные в файле будут заменены.\n" +
                           "Для подтверждения введите \"Yes\": ");
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
