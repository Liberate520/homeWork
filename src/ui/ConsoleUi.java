package ui;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUi implements View {
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean indicator;

    public ConsoleUi(){
        String encoding = System.getProperty("console.encoding", "cp866");
        this.scanner = new Scanner(System.in, encoding);
        this.indicator = true;
    }

    private void menu(){
        System.out.println("Меню =====\n" + menu.printMenu());
        
    }

    public String receiveString(String string)  {
        System.out.println(string);
        String str = scanner.next();
        return str;
    }

    public int receiveInt(String string) {
        System.out.println(string);
        return scanner.nextInt();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        menu = new Menu(this, presenter);
        hello();
        while (indicator) {
            menu();
            int command = scanner.nextInt();
            print(menu.execute(command));
        }
    }

    private void hello() {
        System.out.printf("=========================\n" + 
                           "Приветствуем вас в родовом дереве!\n" +
                           "ВНИМАНИЕ: программа работает в тестовом режиме!\n" +
                           "=========================\n");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void finish() {
        indicator = false;
    }
}
