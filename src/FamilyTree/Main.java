package FamilyTree;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("John", Gender.MALE, "25-08-1965");
        Human human2 = new Human("Sarah", Gender.FEMALE, "12.10.1966");
        Human human3 = new Human("Charlie", Gender.MALE, "05.07.1988");
        Human human4 = new Human("Marie", Gender.FEMALE, "10.09.1987");
        Human human5= new Human("Jack", Gender.MALE, "08.08.2008", human3, human4);

        human1.getChild(human3, human2);

        System.out.println(human1.childList.get(0).fullInfo());

        FamilyTree tree = new FamilyTree("Johnson");
        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.addHuman(human3);
        tree.addHuman(human4);
        tree.addHuman(human5);
        tree.getAllChild(human1);
    }
}
