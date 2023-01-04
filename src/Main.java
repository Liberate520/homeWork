import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human hum_5 = new Human("Ekaterina", "Srebrova", 1929, 0, null, null, null, "W");
        Human hum_6 = new Human("Galina", "Grechina", 1953, 0, null, hum_5, null, "W");
        Human hum_7 = new Human("Aleksandra", "Makogonova", 1977, 0, null, hum_6, null, "W");
        Human hum_3 = new Human("Andrey", "Smolin", 1981, 0, null, hum_6, null, "M");
        Human hum_4 = new Human("Antonina", "Smolina", 1985, 0, null, null, null, "W");
        Human hum_2 = new Human("Egor", "Smolin", 2015, 0, hum_3, hum_4, null, "M");
        Human hum_1 = new Human("Timur", "Smolin", 2020, 0, hum_3, hum_4, null, "M");

        Tree treeGenetic = new Tree();
        treeGenetic.addHuman(hum_1);
        treeGenetic.addHuman(hum_2);
        treeGenetic.addHuman(hum_3);
        treeGenetic.addHuman(hum_4);
        treeGenetic.addHuman(hum_5);
        treeGenetic.addHuman(hum_6);
        treeGenetic.addHuman(hum_7);

        System.out.println(treeGenetic.getTree());
        System.out.println("--------------------------------");
        System.out.println(treeGenetic.getChildrens(hum_4));

        SaveAs saveTree = new SaveAs(treeGenetic);
        saveTree.saveAs(treeGenetic);
        saveTree.read();

    }

}
