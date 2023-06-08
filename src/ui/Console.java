package ui;
import java.util.Scanner;
import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu mainMenu;
    
    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            presenter.loadFile();
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            mainMenu.execute(numCommand);
        }
    }

    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }

    public void getInfo() {
        presenter.getInfo();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveFile() {
        presenter.saveFile();
    }

    @Override
    public void loadFile() {
        presenter.loadFile();
    }
}
