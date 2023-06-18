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
        int input = Integer.parseInt(scanner.nextLine()) - 1;
        clearScreen();
        print(this.menu.toString());
        print("===================================================\n");
        menu.execute(input);        
        print("\n===================================================\n");
        print("> ");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    // #region implements executable
    @Override
    public void show() {
        print("TODO: show");
    }

    @Override
    public void read() {
        print("TODO: get");
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