package WorkSeminar.model.Persona.Builder;

import java.util.Scanner;

public class Input {

    public static String inputs(){
        System.out.println("Введите данные:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
