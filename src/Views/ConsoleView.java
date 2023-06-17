package Views;

import java.util.Scanner;

public class ConsoleView implements View, Executable {

    private boolean isWork;
    private Menu menu;
    private Scanner scanner;

    public ConsoleView() {
        isWork = true;
        menu = new Menu(this);
        scanner = new Scanner(System.in);
    }

    // #region implements view
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        
        do {
            Dialog();
        } while (isWork);
    }
    // #endregion

    private void Dialog() {
        print(this.menu.toString());
        print("> ");
        int input = Integer.parseInt(scanner.nextLine()) - 1;
        clearScreen();
        menu.execute(input);
        
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    // #region implements executable
    @Override
    public void get() {
        print("TODO: show");
    }

    @Override
    public void create() {
        print("TODO: add");
    }

    @Override
    public void remove() {
        print("TODO: remove");
    }

    @Override
    public void update() {
        print("TODO: update");
    }

    @Override
    public void save() {
        print("TODO: save");
    }

    @Override
    public void quit() {
        print("TODO: quit");
        isWork = false;
    }
    // #endregion
}