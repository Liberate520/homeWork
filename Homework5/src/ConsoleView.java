import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;
   public ConsoleView() {
       scanner = new Scanner(System.in);
   }
   @Override
    public void showOutput(String output) {
        System.out.println(output);
    }
    @Override
    public String getInput(){
        return scanner.nextLine();
    }
}