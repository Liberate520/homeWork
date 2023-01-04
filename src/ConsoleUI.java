import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start() {
        scan();
    }

    private void scan() {
        while (true) {
            System.out.print("1 - просмотр дерева, 2 - поиск в дереве, 0 - выход: ");

            String menuChoice = scanner.nextLine();
            if (menuChoice.equals("1")) {
                presenter.onGetTree();
            }
            else if (menuChoice.equals("2")) {
                System.out.print("Input member name: ");
                String name = scanner.nextLine();
                presenter.onGetMember(name);
                System.out.println();
            }
            else if (menuChoice.equals("0")) {
                break;
            }
            else {
                System.out.println("Incorrect input");
                System.out.println();
            }
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}