package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Comands.ComandAddNewHuman;
import Comands.ComandExit;
import Comands.ComandPrintConsoleTree;
import Comands.ComandRead;
import Comands.ComandSave;
import Comands.ComandSearchByName;
import Comands.ComandSortByBirth;
import Comands.ComandSortByName;
import Comands.Option;

public class View {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<Option> comandList = new ArrayList<>();

        comandList.add(new ComandExit());
        comandList.add(new ComandSortByName());
        comandList.add(new ComandSortByBirth());
        comandList.add(new ComandSave());
        comandList.add(new ComandRead());
        comandList.add(new ComandAddNewHuman());
        comandList.add(new ComandPrintConsoleTree());
        comandList.add(new ComandSearchByName());
        while (true) {
            for (int i = 0; i < comandList.size(); i++) {
                System.out.println(i + ": " + comandList.get(i).dicription());
            }
            int chooze = scanner.nextInt();
            if (chooze > 0 && chooze < comandList.size()) {
                comandList.get(chooze);
            } else {
                if (chooze == 0) {
                    break;
                }
                System.out.println("Вы промахнулись , попробуйте ещё");
            }
        }
        scanner.close();
    }

}
