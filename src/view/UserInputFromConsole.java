package view;
import java.util.Scanner;


public class UserInputFromConsole {

    Scanner input = new Scanner(System.in);
   
    public String inputKey(String input){

        String key;

        System.out.print(input);
        key = this.input.nextLine();

        return key;
    }
}

