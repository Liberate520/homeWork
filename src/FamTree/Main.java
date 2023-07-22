package FamTree;

public class Main {
    public static void main(String[] args) {
        Human Mary = new Human("Mary", 35);
        Human Jack = new Human("Jack", 34);
        Human Jane = new Human("Jane", 36);
        Human Alex = new Human("Alex", 45);
        Human Ted = new Human("Ted", 10);
        Human Bred = new Human("Bred", 5);

        FamilyTree ft = new FamilyTree();

        ft.ChildrenParent(Ted, Jack);
        ft.ChildrenParent(Bred, Jane);
        ft.ChildrenParent(Bred, Alex);
        ft.ChildrenParent(Ted, Mary);
        ft.ManWoman(Mary, Jack);
        ft.ManWoman(Alex, Jane);


        System.out.println("Mary child's: ");
        System.out.println(new Searching(ft).spend(Mary, Family.parent));

        System.out.println("Jack child's: ");
        System.out.println(new Searching(ft).spend(Jack, Family.parent));

        System.out.println("Jane child's: ");
        System.out.println(new Searching(ft).spend(Jane, Family.parent));

        System.out.println("Alex child's: ");
        System.out.println(new Searching(ft).spend(Alex, Family.parent));

        System.out.println("Mary husbent: ");
        System.out.println(new Searching(ft).spend(Mary, Family.vife));

        System.out.println("Alex vife: ");
        System.out.println(new Searching(ft).spend(Alex, Family.vife));

        System.out.println(new Searching(ft).searchAge());
    }

}
