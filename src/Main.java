public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Олег", Gender.Male, 1970);
        Human human2 = new Human("Ольга", Gender.Female, 1973);
        Human human3 = new Human("Петя", Gender.Male, 1999);
        Human human4 = new Human("Света", Gender.Female, 2018);
        Human human5 = new Human("Илья", Gender.Male, 2011);

        human3.addFather(human1);
        human3.addMother(human2);
        human4.addFather(human1);
        human4.addMother(human2);

        FamilyTree tree = new FamilyTree();
        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);

        tree.printFamily();
    }
}