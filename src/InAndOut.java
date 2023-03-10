import java.util.Scanner;

public class InAndOut {
    public InAndOut() {
    }

    public void print(String msg){
        System.out.println(msg);
    }

    public String input(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}