package Controllers;

import java.util.Random;

public class RandomController {

    public static void FillArray(int[] array, int origin, int bound) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(origin, bound);
        }
    }
}
