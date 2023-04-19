public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Иван", "Петров", "male");
        Human human2 = new Human("Федор", "Петров","male");
        Human human3 = new Human("Денис", "Иванов","male");
        Human human4 = new Human("Андрей", "Егоров","male");
        Human human5 = new Human("Илья", "Бобров","male");
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        System.out.println(human1.toString());
        System.out.println(human1.getMother());
        System.out.println(human2.getChildren());
        human2.addChildren(human1);
        System.out.println("----");
        System.out.println(human1.toString());
        System.out.println(human1.getFather());
        System.out.println(human2.getChildren());

    }
}
