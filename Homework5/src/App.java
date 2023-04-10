import java.util.Scanner;

public class App {
    public static void start() {
        View view = new ConsoleView();
        Model model = new Model();
        Presenter presenter = new Presenter(view, model);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                view.showOutput("\nВыберите действие:\n1. Добавить заметку\n2. Показать все заметки\n3. Выход");
                String choice = view.getInput();

                switch (choice) {
                    case "1":
                        presenter.add();
                        break;
                    case "2":
                        System.out.println(presenter.getNotes());
                        break;
                    case "3":
                        view.showOutput("Блокнот закрыт");
                        System.exit(0);
                        break;
                    default:
                        view.showOutput("Недопустимый выбор");
                }
            }
        }
    }
}
