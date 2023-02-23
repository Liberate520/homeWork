package ui;

import java.util.Scanner;

public class ConsoleUi {
    Scanner scanner;

    public ConsoleUi(){
        this.scanner = new Scanner(System.in);
    }

    public int menu(){
        System.out.println("Меню =====\n" +
                            "1 - Ввывести на экран всё дерево\n" +
                            "2 - Отсортировать по имени и вывести\n" +
                            "3 - Отсортировать по возрасту и вывести\n" +
                            "4 - Добавить нового человека\n" +
                            "0 - Выход");
        return scanner.nextInt();
    }

    public void print(StringBuilder info) {
        System.out.println(info);
    }

    public String receiveString(String string) {
        System.out.println(string);
        return scanner.next();
    }

    public int receiveInt(String string) {
        System.out.println(string);
        return scanner.nextInt();
    }
}
