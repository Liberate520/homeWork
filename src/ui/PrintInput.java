package ui;

import java.util.Scanner;

public class PrintInput {
    private Scanner scanner;

    public PrintInput() {
        scanner = new Scanner(System.in,"Cp866");
    }

    public String inputLn(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public String  nextLine() {
        return scanner.nextLine();
    }

}
