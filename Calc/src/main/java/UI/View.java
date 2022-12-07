package UI;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public double getValue(String title) {
        System.out.printf("%s", title);
        return in.nextDouble();
    }

    public String getAction(String title){
        System.out.printf("%s", title);
        return in.nextLine();
    }


    public void print(int data, String title) {
        System.out.printf("%s %d\n", title, data);
    }
}
