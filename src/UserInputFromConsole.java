import java.util.Scanner;

public class UserInputFromConsole {

   
    public static String inputKey(String invate){

        Scanner input = new Scanner(System.in);
        String key;

        System.out.print(invate);
        key = input.nextLine();
        input.close();

        return key;
    }
}
