package View;

import java.util.Scanner;
import Controller.Controller;

public class View {
    private Controller controller;
    private Scanner scanner;    

    public View() {
        scanner = new Scanner(System.in);
    }

    // public void setController(Controller controller){
    // this.controller = controller;
    // }

    public void start() {
        String action = scan();
        controller.onClick(action);
    }

    private String scan() {
        System.out.println(
                "Что хотите вывести из генеологического дерева (все дерево, первый элемент, последний элемент)?");
        return scanner.nextLine();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    // public void print(String text) {
    // System.out.println(text);
    // }
}
