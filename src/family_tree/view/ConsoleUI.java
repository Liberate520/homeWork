package family_tree.view;
import family_tree.presenter.Presenter;

import java.util.Scanner;
public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;



    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("СЕМЕЙНОЕ ДРЕВО.");
        }
    public void finish() {
        System.out.println("СЕМЕЙНОЕ ДРЕВО. Программа закрыта.");
    }


    public void getFamilyTreeInfo(String sort_by) {
        presenter.getFamilyTreeInfo(sort_by);
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
        System.out.print("Загрузка данных из файла. Текущий список будет удален.\n" +
                "Для подтверждения введите \"Yes\": ");
        String str2 = scanner.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            System.out.println("Загружено семейное древо:");
            presenter.setFamily_tree();
            getFamilyTreeInfo("1");
        } else {
            System.out.println("Действие отменено.");
        }
    }

    public void clearFamilyTree() {
        System.out.print("Семейное древо будет очищено.\n" +
                "Для подтверждения введите \"Yes\": ");
        String str2 = scanner.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            presenter.clearFamilyTree();
            System.out.println("Семейное древо успешно очищено");
        } else {
            System.out.println("Действие отменено.");
        }
    }

    public void saveFamilyTree() {
        System.out.println("Сохранение в файл.\nЗагружаю ");
        getFamilyTreeInfo("1");
        if (presenter.saveFamily_tree()){
            System.out.println("Семейное древо успешно сохранено в файл.");
        } else {
            System.out.println("Что-то пошло не так.");
        }
    }

    public void set_relatives(String str) {
        presenter.set_relatives(str);
    }

    public String get_reply(String string_request) {
        System.out.print(string_request);
        return scanner.nextLine();
    }
}
