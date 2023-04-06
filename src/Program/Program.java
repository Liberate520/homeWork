package Program;

import java.io.IOException;

import Class.*;



public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Tree tree = new Tree();
        // 1st gen
        Human mikhailFedorovich = new Human("Михаил",
                "Фёдорович", "Романов", 1596, 1645, (Human) null, (Human) null);
        tree.addPerson(mikhailFedorovich);

        Human evdokiaLukianovna = new Human("Евдокия",
                "Лукьяновна", "Стрешнева", (Integer) 0, 1645, (Human) null, (Human) null);
        tree.addPerson(evdokiaLukianovna);

        // 2nd gen
        Human irinaMikhailovna = new Human("Ирина",
                "Михайловна", "Романова", 1627, 1679, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(irinaMikhailovna);
        mikhailFedorovich.addChild(irinaMikhailovna);

        Human pelageyaMikhailovna = new Human("Пелагея",
                "Михайловна", "Романова", 1628, 1629, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(pelageyaMikhailovna);
        mikhailFedorovich.addChild(pelageyaMikhailovna);

        Human alekseyMikhailovich = new Human("Алексей",
                "Михайлович", "Романов", 1629, 1676, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(alekseyMikhailovich);
        mikhailFedorovich.addChild(alekseyMikhailovich);

        Human annaMikhailovna = new Human("Анна",
                "Михайловна", "Романова", 1630, 1692, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(annaMikhailovna);
        mikhailFedorovich.addChild(annaMikhailovna);

        Human marfaMikhailovna = new Human("Марфа",
                "Михайловна", "Романова", 1631, 1632, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(marfaMikhailovna);
        mikhailFedorovich.addChild(marfaMikhailovna);

        Human sofiaMikhailovna = new Human("Софья",
                "Михайловна", "Романова", 1634, 1636, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(sofiaMikhailovna);
        mikhailFedorovich.addChild(sofiaMikhailovna);

        Human tatianaMikhailovna = new Human("Татьяна",
                "Михайловна", "Романова", 1636, 1706, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(tatianaMikhailovna);
        mikhailFedorovich.addChild(tatianaMikhailovna);

        Human evdokiaMikhailovna = new Human("Евдокия",
                "Михайловна", "Романова", 1637, (Integer) 0, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(evdokiaMikhailovna);
        mikhailFedorovich.addChild(evdokiaMikhailovna);

        Human vasiliyMikhailovich = new Human("Василий",
                "Михайлович", "Романов", 1629, (Integer) 0, mikhailFedorovich, evdokiaLukianovna);
        tree.addPerson(vasiliyMikhailovich);
        mikhailFedorovich.addChild(vasiliyMikhailovich);

        // System.out.println(mikhailFedorovich.toString());
        // System.out.println(mikhailFedorovich.getDescendants());
        // System.out.println(vasiliyMikhailovich.getParents());

        tree.Save(tree, "Seminar_1/homeWork/src/Storage/Test.out");
        Tree loaded = tree.Load("Seminar_1/homeWork/src/Storage/Test.out");

        for (Human person : loaded.getTree()) {
                System.out.println(person.toString());
        }
    }
}
