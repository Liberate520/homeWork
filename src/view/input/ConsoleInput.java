package view.input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public Integer intInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception ignored) {
            return -1;
        }

    }
}
