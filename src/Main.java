import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Human> treeBook = new ArrayList<>();

        Human hum_5 = new Human("Srebrova", "Ekaterina", 1929, 0, null, null, new ArrayList<Human>(), "W");
        Human hum_6 = new Human("Grechina", "Galina", 1953, 0, null, hum_5, new ArrayList<Human>(), "W");
        Human hum_7 = new Human("Makogonova", "Aleksandra", 1977, 0, null, hum_6, new ArrayList<Human>(), "W");
        Human hum_3 = new Human("Smolin", "Andrey", 1981, 0, null, hum_6, new ArrayList<Human>(), "M");
        Human hum_4 = new Human("Smolina", "Antonina", 1985, 0, null, null, new ArrayList<Human>(), "W");
        Human hum_2 = new Human("Smolin", "Egor", 2015, 0, hum_3, hum_4, new ArrayList<Human>(), "M");
        Human hum_1 = new Human("Smolin", "Timur", 2020, 0, hum_3, hum_4, new ArrayList<Human>(), "M");

        treeBook.add(hum_1);
        treeBook.add(hum_2);
        treeBook.add(hum_3);
        treeBook.add(hum_4);
        treeBook.add(hum_5);
        treeBook.add(hum_6);
        treeBook.add(hum_7);

        Tree treeGenetic = new Tree<>(treeBook);

        hum_6.addChild(hum_7);
        hum_6.addChild(hum_3);
        hum_5.addChild(hum_6);
        hum_3.addChild(hum_1);
        hum_3.addChild(hum_2);
        hum_4.addChild(hum_2);
        hum_4.addChild(hum_1);

        View view = new View(treeGenetic);
        view.start();

    }

}
