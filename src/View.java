import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    }

}
