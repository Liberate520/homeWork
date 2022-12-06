
import java.util.Scanner;

public class Console implements View {
    private Controller controller;
    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }
    @Override
    public void setController(Controller controller){
        this.controller = controller;
    }

    @Override
    public void start() {
        controller.newFamily();;
    }

    @Override
    public String scanOne(String s) {
        System.out.println(s);
       scanner.nextLine();
        return scanner.nextLine();
    }
    @Override
    public String scanOther(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    @Override
    public void printStr(String s) {
        System.out.println(s);
    }

    @Override
    public int printMenu(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }
}

