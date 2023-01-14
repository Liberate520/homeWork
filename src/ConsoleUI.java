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
            menu();

            String menuChoice = scanner.nextLine();

            if (menuChoice.length() == 1) {
                if (menuChoice.equals("0")) break;
                else presenter.onGetTree(menuChoice);
            }
            else {
                if (menuChoice.equals("20") ||
                    menuChoice.equals("21") ||
                    menuChoice.equals("22")) {
                        int sortType = Integer.parseInt(menuChoice.substring(1, 2));
                        presenter.onSortTree(sortType);
                }
                else if (menuChoice.equals("30")) {
                    System.out.print("Input member name: ");
                    String name = scanner.nextLine();
                    presenter.onGetMember(name);
                    System.out.println("");
                }
                else if (menuChoice.equals("40") ||
                        menuChoice.equals("41")) {
                    int fileType = Integer.parseInt(menuChoice.substring(1, 2));
                    presenter.onSaveTree(fileType);
                    System.out.println("");
                }
                else if (menuChoice.equals("50") ||
                        menuChoice.equals("51")) {
                    int fileType = Integer.parseInt(menuChoice.substring(1, 2));
                    presenter.onLoadTree(fileType);
                    System.out.println("");
                }
                else {
                    System.out.println("Incorrect input");
                    System.out.println("");
                }
            }
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void menu() {
        System.out.println("-----------------------------------------");
        System.out.println("Choose family tree");
        presenter.onGetTreeNames();
        System.out.println("View family tree");
        System.out.println("\t20 - sort by id");
        System.out.println("\t21 - sort by member name");
        System.out.println("\t22 - sort by children count desc");
        System.out.println("30 - Find in family tree");
        System.out.println("Save family tree");
        System.out.println("\t40 - to text file");
        System.out.println("\t41 - to binary file");
        System.out.println("Load family tree");
        System.out.println("\t50 - from text file");
        System.out.println("\t51 - from binary file");
        System.out.println("0 - Exit");
        System.out.println("-----------------------------------------");
    }
}