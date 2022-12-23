import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public Float getValue(String title) {
        System.out.printf("%s", title);
        return in.nextFloat();
    }

    public void print(Float data, String title) {
        System.out.printf("%s %.3f\n", title, data);
    }
}