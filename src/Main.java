import Humans.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Иван", "Петров", "male");
        Human human2 = new Human("Федор", "Петров","male");
        Human human3 = new Human("Денис", "Иванов","male");
        Human human4 = new Human("Андрей", "Егоров","male");
        Human human5 = new Human("Илья", "Бобров","male");
        Human human10 = new Human("Даша", "Давыдова","female");
        Human human11 = new Human("Матвей", "Игнатьев","male");
        Human human12 = new Human("Вероника", "Остроумова","female");
        Human human13 = new Human("Николай", "Угольнико","male");

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human10);
        familyTree.addHuman(human11);
        familyTree.addHuman(human12);
        familyTree.addHuman(human13);
        System.out.println(human1.toString());
        System.out.println(human1.getMother());
        System.out.println(human2.getChildren());
        human2.addChildren(human1);
        System.out.println("----");
        System.out.println(human1.toString());
        System.out.println(human1.getFather());
        System.out.println(human2.getChildren());

        Human human6 = new Human("Захар", "Давыдов","male");
        familyTree.saveHuman(human6);
        Human human7 = familyTree.readHuman("Захар");

        System.out.println("++++++++++");
        System.out.println(human7);
        System.out.println("---------------");

        System.out.println(familyTree.humansPrint());
        System.out.println("///////////");
        System.out.println(familyTree.humanSort());
        System.out.println("---------");
        System.out.println(familyTree.humansPrint());
        System.out.println(familyTree.humanSortByGender());


    }
}
