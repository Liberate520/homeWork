package homeWorkSem1.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homeWorkSem1.Option.Option;

public class View {
    Scanner in = new Scanner(System.in);

    /**Получаем выбор пользователя */
    public int getValue(String title) {
        System.out.printf("%s ", title);
        return in.nextInt();
    }


    /**Демонстрация меню пользователю */
    public void getMenu(List<Option> commandList) {
        for (int index = 0; index < commandList.size(); index++) {
            System.out.println(index+1 + ": " + commandList.get(index).description());
        }
    }

}
