import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean workNotebook;
    private Menu menu;
    Model model = new Model();
 public ConsoleView() {
     scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
   @Override
    public void showOutput(String output) {
        System.out.println(output);
    }
    @Override
    public String getInput(){
       scanner.nextLine();
      String line = scanner.nextLine();
     return line;
    }
    @Override
    public void onClick() {
        workNotebook = true;
        menu = new Menu(this);
        do {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            menu.execute(choice-1);
            }
        while (workNotebook);
    }


    public void printMenu() {
        System.out.println(menu.printMenu());
    }

    public void finish() {
        System.out.println("\nБлокнот закрыт");
        workNotebook = false;
    }

    public void addNote() {
        showOutput("Ваша заметка: ");
        presenter.add();
        showOutput("Заметка добавлена");
    }
    public void getNotes() {
        System.out.println(presenter.getNotes());
    }
}