import java.util.Scanner;

public class MyView implements View{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public String getText() {
        return scanner.nextLine();
    }
}
