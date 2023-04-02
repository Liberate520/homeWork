import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.addKin(new Human("мать матери ego", "Галина", "Бородихина", LocalDate.of(1932, 1, 23)));
        tree.addKin(new Human("отец матери ego", "Николай", "Мягков", LocalDate.of(1932, 12, 23)));
        tree.addKin(new Human("сын матери матери ego: ", "Юрий", "Мягков", LocalDate.of(1954, 05, 8), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков")));
        tree.addKin(new Human("мать  ego", "Татьяна", "Мягкова", LocalDate.of(1958, 5, 16), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков")));
        tree.addKin(new Human("дочь матери матери ego: ", "Марина", "Мягкова", LocalDate.of(1964, 8, 5), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков")));
        tree.addKin(new Human("ego", "Денис", "Мягков", LocalDate.of(1984, 1, 22), tree.getHuman("Татьяна", "Мягкова"), null));
        tree.addKin(new Human("дочь сына матери матери ego", "Наталья", "Мягкова", LocalDate.of(1978, 9, 23), null, tree.getHuman("Юрий", "Мягков")));
        tree.addKin(new Human("дочь сына матери матери ego", "Лариса", "Мягкова", LocalDate.of(1983, 8, 7), null, tree.getHuman("Юрий", "Мягков")));
        tree.addKin(new Human("дочь дочери матери матери ego", "Юлия", "Констман", LocalDate.of(1988, 4, 12), tree.getHuman("Марина", "Мягкова"), null));
        tree.addKin(new Human("сын ego", "Матвей", "Мягков", LocalDate.of(2021, 10, 5), null, tree.getHuman("Денис", "Мягков")));

        tree.getHuman("сын ego").setMother(new Human("мать сына ego", " Светлана", "Шемякина", LocalDate.of(1988, 04, 02)));

        //System.out.println(tree);
        //System.out.println(tree.getOldest());
        //System.out.println(tree.getYoungest());
        //System.out.println(tree.getHuman("Денис", "Мягков"));
        //System.out.println(tree.getHuman("сын ego"));
        //System.out.println(tree.getAllChildren("Галина", "Бородихина"));
        //System.out.println("=======");
        System.out.println(tree.getHuman("Галина", "Бородихина").getChildren());


    }
}