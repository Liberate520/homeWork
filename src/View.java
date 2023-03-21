import java.util.Scanner;

public class View {
    private Presenter presenter;
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    // public void output(String outputString) {
    //     print(outputString);
    // }

    public void dialog(String question) {
        print(question);
        String inputString = scan();
        presenter.input(inputString);
    }

    public String scan() {
        return scanner.nextLine();
    }

    public void print(String outputString) {
        System.out.println(outputString);
    }

}
