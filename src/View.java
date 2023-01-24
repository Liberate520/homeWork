import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<Option> comandList = new ArrayList<>();

        comandList.add(new ComandExit());
        comandList.add(new ComandSortByName());
        comandList.add(new ComandSave());
        while (true) {
            for (int i = 0; i < comandList.size(); i++) {
                System.out.println(i + ": " + comandList.get(i).dicription());
            }
            int chooze = scanner.nextInt();
            comandList.get(chooze);
            if (chooze == 0) {
                break;
            }
        }
    }

}
