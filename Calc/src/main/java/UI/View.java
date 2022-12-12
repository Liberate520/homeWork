package UI;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    public double getValue(String title) {
        System.out.printf("%s", title);
        return in.nextDouble();
    }

    public String getAction(String title){
        System.out.printf("%s", title);
        return sc.nextLine();
    }


    public void print(double data, String title) {
        System.out.printf("%s %f", title, data);
    }
}
