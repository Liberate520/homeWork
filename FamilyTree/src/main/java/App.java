import java.util.ArrayList;
import java.util.Scanner;;

public class App {
    public void showList(ArrayList<Person> list) {
        System.out.println(list);
    }
    public void searchById(ArrayList<Person> list, String id) {
        int intId = Integer.parseInt(id);
        var result = new ArrayList<>();
        for (Person p : list) {
            if (intId == (Integer) p.getId()) {
                result.add(p);
                System.out.println(result);
            }
        }
    }

    public void start(ArrayList<Person> list) {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("Нажмите: 1 - Найти человека по ID,  2 - Показать весь список, 3 - Выход");
                String key = in.next();
                switch (key) {
                    case "1":
                        System.out.println("Введите ID человека");
                        String num = in.next();
                        searchById(list, num);
                        System.out.println();
                        break;
                    case "2":
                        showList(list);
                        System.out.println();
                        break;
                    case "3":
                        System.exit(0);

                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
}