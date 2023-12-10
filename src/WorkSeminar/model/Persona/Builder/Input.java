package WorkSeminar.model.Persona.Builder;

import java.util.Scanner;

public class Input {

    public static String inputs(Scanner scanner){
        System.out.println("Введите данные:");
        try {
            return scanner.nextLine();
        } catch (RuntimeException ex){
            System.out.println("Ошибка ввода" + ex);
        }
        return null;

    }

}
