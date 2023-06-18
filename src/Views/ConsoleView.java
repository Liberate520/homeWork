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
        showMenu();
        showInputField();
        do {
            Dialog();
        } while (isWork);
    }
    // #endregion

    //#region dialogs
    private void showTitle() {
        print("\u2591\u2591\u2592\u2593\u2588\u001B[47mPOWERFUL NOTE APPLICATION\u001B[0m\u2588\u2593\u2592\u2591\u2591\n");
    }

    private void showMenu() {
        clearScreen();
        showTitle();
        print(this.menu.toString());
        print("\n-----------------------------------------------------\n");
    }

    private void Dialog() {        
        int input = getIntegerInput(1, menu.getSize()) - 1;
        showMenu();
        menu.execute(input);        
        showInputField();
    }

    private void showInputField() {
        print("\n-----------------------------------------------------\n");
        print("> ");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    //#endregion

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

    //#region parsers
    private Integer getIntegerInput(Integer min, Integer max){
        do{
            String input = scanner.nextLine();
            if(input.matches("[0-9]+")){
                Integer value =  Integer.parseInt(input);
                if(value != null && value >= min && value <= max){
                    return value;
                }
            }
            print("> ");
        }while(true);
    }

    
    //#endregion

}