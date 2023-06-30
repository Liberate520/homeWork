package faminly_tree;

public class Test {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Darya", Gender.Female, 1996, 10, 17);
        tree.addPerson(human1);
        tree.addFather("Aleksey", 1967, 3, 1, human1);
        tree.addMother("Elena", 1969, 12, 24, human1);
        tree.addMother("Lidia", 1949, 5, 20, human1.getMother());
        tree.addChildren("Lisa", 2004, 10, 8, human1.getFather());
        tree.addChildren("Ivan", 2012, 8, 10, human1.getFather());
        //System.out.println(human1);
        //System.out.println("Бабушка " + human1.getName() + ":\n" + human1.getMother().getMother());
        //System.out.println("Дети " + human1.getFather().getName() + ":\n" + human1.getFather().getChildrenToString());
        //System.out.println("Родители " + human1.getName() + ":\n" + tree.findParents(human1));
        System.out.println("Родители " + human1.getMother().getName() + ":\n" + tree.findParents(human1.getMother()));
    }
}
