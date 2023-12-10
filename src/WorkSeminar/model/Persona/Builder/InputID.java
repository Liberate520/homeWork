package WorkSeminar.model.Persona.Builder;

import java.util.Scanner;

public class InputID {
    public static long inputsID(Scanner scan){
        try {
            System.out.println("Укажите ID обрабатываемого персонажа: ");
            long ID = Long.parseLong(Input.inputs(scan));
            return ID;
        } catch (Exception ex){
            System.out.println("Не сработал ввод ID");
            ex.printStackTrace();
        }
        return -1;
    }
}
