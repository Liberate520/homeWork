import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserUI implements View {

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<Option> comandList = new ArrayList<>();
        comandList.add(new ComandSave());
        comandList.add(new ComandSortByName());
        while (true) {
            for (int i = 0; i < comandList.size(); i++) {
                System.out.println(i + ": " + comandList.get(i).dicription());
            }
            int chooze = scanner.nextInt();
            comandList.get(chooze);
        }
    }

}
