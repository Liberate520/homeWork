package family_tree.view;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;
public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
//    private MainMenu menu;
    private Date_using du = new Date_using();

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
//        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
//        hello();
        while (work){
//            printMenu();
//            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void sortByAge() {
//        presenter.sortByAge();
    }


    public void sortByName() {
//        presenter.sortByName();
    }

    public void getFamilyTreeInfo() {
//        presenter.getFamilyTreeInfo();
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


}
