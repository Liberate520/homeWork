package DZ5_7;

import java.util.Scanner;
import DZ5_7.Models.Human;
import DZ5_7.Models.TypeGender;
import DZ5_7.MVP.*;

public class Appx {

    public static void start() {
        View view = new View();
        Presenter<Human> presenter = new Presenter<>(view);
        presenter.loadFromFile();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println(
                        " 1 - Вывести дерево  2 - Добавить человека 3 - Добавить род. связь 4 - Удалить человека 5 - Найти по имени 6 - Выход");
                String key = in.next();
                // System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.viewFamilyTree();
                        break;
                    case "2":
                        presenter.add(presenter.create());
                        presenter.saveToFile();
                        break;
                    case "3":
                        presenter.viewFamilyTree();
                        presenter.addCommunication();
                        presenter.saveToFile();
                        break;
                    case "4":
                        presenter.viewFamilyTree();
                        presenter.del(presenter.getHuman());
                        presenter.saveToFile();
                        break;
                    case "5":
                        presenter.find();
                        break;
                    case "6":
                        return;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
}
