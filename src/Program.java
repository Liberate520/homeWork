public class Program {
    public static void main(String[] args) {

        // 1st gen
        Human mikhailFedorovich = new Human("Михаил",
                "Фёдорович", "Романов", 1596, 1645, (Human) null, (Human) null);
        Human evdokiaLukianovna = new Human("Евдокия",
                "Лукьяновна", "Стрешнева", (Integer) 0, 1645, (Human) null, (Human) null);

        // 2nd gen
        Human irinaMikhailovna = new Human("Ирина",
                "Михайловна", "Романова", 1627, 1679, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(irinaMikhailovna);

        Human pelageyaMikhailovna = new Human("Пелагея",
                "Михайловна", "Романова", 1628, 1629, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(pelageyaMikhailovna);

        Human alekseyMikhailovich = new Human("Алексей",
                "Михайлович", "Романов", 1629, 1676, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(alekseyMikhailovich);

        Human annaMikhailovna = new Human("Анна",
                "Михайловна", "Романова", 1630, 1692, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(annaMikhailovna);

        Human marfaMikhailovna = new Human("Марфа",
                "Михайловна", "Романова", 1631, 1632, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(marfaMikhailovna);

        Human sofiaMikhailovna = new Human("Софья",
                "Михайловна", "Романова", 1634, 1636, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(sofiaMikhailovna);

        Human tatianaMikhailovna = new Human("Татьяна",
                "Михайловна", "Романова", 1636, 1706, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(tatianaMikhailovna);

        Human evdokiaMikhailovna = new Human("Евдокия",
                "Михайловна", "Романова", 1637, (Integer) 0, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(evdokiaMikhailovna);

        Human vasiliyMikhailovich = new Human("Василий",
                "Михайлович", "Романов", 1629, (Integer) 0, mikhailFedorovich, evdokiaLukianovna);
        mikhailFedorovich.children.add(vasiliyMikhailovich);

        System.out.println(mikhailFedorovich.toString());
        System.out.println(mikhailFedorovich.GetDescendants());
        System.out.println(vasiliyMikhailovich.GetParents());

    }
}
