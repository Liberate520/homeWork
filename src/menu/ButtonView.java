package menu;

import java.util.Scanner;

public class ButtonView {

    public String getInfo(String question){
        System.out.print(question + ": ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return answer;
    }
}
