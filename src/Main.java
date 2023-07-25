public class Main {
    public static void main(String[] args) {
        Human n000 = new Human(0, "Даша", "Иванова", Human.Gender.FEMALE);
        Human n001 = new Human(1, "Саша", "Андреев", Human.Gender.MALE);
        Human n002 = new Human(2, "Маша", "Петрова", Human.Gender.FEMALE);
        Human n003 = new Human(3, "Вова", "Андреев", Human.Gender.MALE);
        Human n004 = new Human(4, "Андрей", "Андреев", Human.Gender.MALE);
        Human n005 = new Human(5, "Игорь", "Андреев", Human.Gender.MALE);
        Human n006 = new Human(6, "Евдокия", "Олегова", Human.Gender.FEMALE);
        Human n007 = new Human(7, "Клавдия", "Андреева", Human.Gender.FEMALE);

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