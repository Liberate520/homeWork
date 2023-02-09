package homeWorkSem1.View;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    /**Получаем выбор пользователя */
    public int getValue(String title) {
        System.out.printf("%s ", title);
        return in.nextInt();
    }


    public void answer(String title) {
        System.out.printf("%s", title);
    }


}
