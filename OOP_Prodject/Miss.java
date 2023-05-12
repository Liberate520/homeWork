package OOP_Prodject;

import java.util.Random;

public class Miss {
    public static void miss() {
        Random r = new Random();
        int phrase_number = r.nextInt(0, 2);
        if (phrase_number == 1) {
            System.out.println("Промах");
        } else {
            System.out.println("Заблокировано");
        }

    }

}
