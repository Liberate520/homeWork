import java.util.Scanner;
import java.lang.System;

public class View {
    Scanner scn = new Scanner(System.in);

    public int getChoice(String title) {
        System.out.printf("%s", title);
        return scn.nextInt();
    }

    public double getValue(String title) {
        System.out.printf("%s", title);
        return scn.nextDouble();
    }

    public void print(double data, String title) {
        System.out.printf("%s %.2f\n", title, data);
    }
}
