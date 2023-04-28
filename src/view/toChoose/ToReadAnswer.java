package view.toChoose;

import java.util.Scanner;

public class ToReadAnswer {

    private Scanner scanner;

    public ToReadAnswer() {
        scanner = new Scanner(System.in, "cp866");
    }

    public int readAnswer() {
        System.out.println("Введите номер операции: ");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
        return number;
        }
        return 0;
    }
}
