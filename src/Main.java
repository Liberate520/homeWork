public class Main {
    public static void main(String[] args) {
        Human n000 = new Human("Даша");
        Human n001 = new Human("Саша");
        Human n002 = new Human("Маша");
        Human n003 = new Human("Вова");
        Human n004 = new Human("Андрей");
        Human n005 = new Human("Игорь");
        Human n006 = new Human("Евдокия");

        FamilyTree ft = new FamilyTree();

        ft.appendParent(n005, n001); //Отец Саши
        ft.appendParent(n000, n001); //Мать Саши

        ft.appendMariage(n001,n006); //Жена Саши
        ft.appendMariage(n006,n001); //Муж Евдокии

        ft.appendParent(n001, n003); //Первый ребенок Саши и Евдокии
        ft.appendParent(n006, n003);
        ft.appendParent(n001, n004); //Второй ребенок Саши и Евдокии
        ft.appendParent(n006, n004);

        System.out.println(n001 + " - дети:");
        System.out.println(ft.search(n001, Relation.Relationship.PARENT));
        System.out.println(n001 + " - родители:");
        System.out.println(ft.search(n001, Relation.Relationship.CHILDREN));
        System.out.println(n001 + " - жена:");
        System.out.println(ft.search(n001, Relation.Relationship.MARIAGE));
        System.out.println(n006 + " - дети:");
        System.out.println(ft.search(n006, Relation.Relationship.PARENT));
        System.out.println(n006 + " - муж:");
        System.out.println(ft.search(n006, Relation.Relationship.MARIAGE));
    }
}