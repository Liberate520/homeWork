public class Main {
    public static void main(String[] args) {
        Human mihailHuman = new Human("Михаил", "1613", "1645");
        Human alexHuman = new Human("Алексей", "1645", "1676");
        Human fyodorHuman = new Human("Фёдор", "1676", "1682");
        Human ivan5Human = new Human("Иван", "1682", "1696");
        mihailHuman.addChildren(alexHuman);
        alexHuman.setFather(mihailHuman);
        alexHuman.addChildren(fyodorHuman);
        fyodorHuman.setFather(alexHuman);
        alexHuman.addChildren(ivan5Human);
        System.out.println(alexHuman.getChildren());

    }
}
