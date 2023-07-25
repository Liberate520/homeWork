public class Main {
    public static void main(String[] args) {
        Human n000 = new Human("Даша");
        Human n001 = new Human("Саша");
        Human n002 = new Human("Маша");
        Human n003 = new Human("Вова");
        Human n004 = new Human("Андрей");
        Human n005 = new Human("Игорь");
        Human n006 = new Human("Евдокия");
        Human n007 = new Human("Клавдия");

        FamilyTree ft = new FamilyTree();

        ft.appendParent(n005, n000, n001); //Родители Саши

        ft.appendMariage(n001,n006); //Саша и Евдокия

        ft.appendParent(n001, n006, n003); //Первый ребенок Саши и Евдокии
        ft.appendParent(n001, n006, n004); //Второй ребенок Саши и Евдокии

        ft.appendMariage(n003, n002); //Вова и Маша

        ft.appendParent(n003, n002, n007); //Ребенок Вовы и Маши

        System.out.println(n003 + " - дети:");
        System.out.println(ft.search(n003, Relation.Relationship.PARENT));

        System.out.println(n002 + " - дети:");
        System.out.println(ft.search(n002, Relation.Relationship.PARENT));

        System.out.println(n007 + " - родители:");
        System.out.println(ft.search(n007, Relation.Relationship.CHILDREN));

        System.out.println(n001 + " - дети:");
        System.out.println(ft.search(n001, Relation.Relationship.PARENT));

        System.out.println(n003 + " - жена:");
        System.out.println(ft.search(n003, Relation.Relationship.MARIAGE));

        System.out.println(ft.getTree());
    }
}