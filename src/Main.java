import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human hum_5 = new Human("Ekaterina", "Srebrova", 1929, 0, null, null, new ArrayList<Human>(), "W");
        Human hum_6 = new Human("Galina", "Grechina", 1953, 0, null, hum_5, new ArrayList<Human>(), "W");
        Human hum_7 = new Human("Aleksandra", "Makogonova", 1977, 0, null, hum_6, new ArrayList<Human>(), "W");
        Human hum_3 = new Human("Andrey", "Smolin", 1981, 0, null, hum_6, new ArrayList<Human>(), "M");
        Human hum_4 = new Human("Antonina", "Smolina", 1985, 0, null, null, new ArrayList<Human>(), "W");
        Human hum_2 = new Human("Egor", "Smolin", 2015, 0, hum_3, hum_4, new ArrayList<Human>(), "M");
        Human hum_1 = new Human("Timur", "Smolin", 2020, 0, hum_3, hum_4, new ArrayList<Human>(), "M");

        Tree treeGenetic = new Tree();
        treeGenetic.addHuman(hum_1);
        treeGenetic.addHuman(hum_2);
        treeGenetic.addHuman(hum_3);
        treeGenetic.addHuman(hum_4);
        treeGenetic.addHuman(hum_5);
        treeGenetic.addHuman(hum_6);
        treeGenetic.addHuman(hum_7);

        hum_6.addChild(hum_7);
        hum_6.addChild(hum_3);
        hum_5.addChild(hum_6);
        hum_3.addChild(hum_1);
        hum_3.addChild(hum_2);
        hum_4.addChild(hum_2);
        hum_4.addChild(hum_1);

        System.out.println();
        System.out.println("Вывод дерева");
        System.out.println();
        System.out.println(treeGenetic.getTree());
        System.out.println();
        System.out.println("Поиск детей через родителей");
        System.out.println();
        System.out.println(treeGenetic.getChildrens(hum_4));
        System.out.println("Вывод списка детей");
        System.out.println();
        System.out.println(hum_4.getChild());
        System.out.println("Итератор");
        System.out.println();

        for (var human : treeGenetic) {
            System.out.println(human);
        }

        System.out.println();
        System.out.println("Сортировка по имени");

        treeGenetic.sortBySurname();
        for (var human : treeGenetic) {
            System.out.println(human);
        }

        System.out.println();
        System.out.println("Сортировка по дате рождения");

        treeGenetic.sortByDate();
        for (var human : treeGenetic) {
            System.out.println(human);
        }

        SaveAs saveTree = new SaveAs(treeGenetic);
        saveTree.saveAs(treeGenetic);
        saveTree.read();

    }

}
