package UI;

import MVP.View;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {

    @Override
    public void showMenu(String menu) {
        System.out.println(menu);
    }

    @Override
    public void printObjects(List objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
