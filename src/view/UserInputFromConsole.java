package view;
import java.util.Scanner;


public class UserInputFromConsole {

    Scanner input = new Scanner(System.in);

    public String inputKey(String invite){
        String key;
        System.out.print(invite);
        key = input.nextLine();
        return key;
    }
}

