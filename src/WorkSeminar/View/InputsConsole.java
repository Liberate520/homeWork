package WorkSeminar.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputsConsole {
    public String in(Scanner scanner){
        try {
            return scanner.nextLine();
        } catch (RuntimeException ex){
            System.out.println("Ошибка ввода" + ex);
        }
        return null;
    }
    public long inID(Scanner scanner){
        try {
            System.out.println("Укажите ID персонажа: ");
            long ID = Long.parseLong(in(scanner));
            return ID;
        } catch (RuntimeException ex){
            System.out.println("Ошибка ввода ID персонажа, попробуйте снова" + ex);
            return inID(scanner);
        }
    }


}
