import Humans.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Иван", "Петров", "male");
        Human human2 = new Human("Федор", "Петров","male");
        Human human3 = new Human("Денис", "Иванов","male");
        Human human4 = new Human("Андрей", "Егоров","male");
        Human human5 = new Human("Илья", "Бобров","male");
        Human human6 = new Human("Даша", "Давыдова","female");
        Human human7 = new Human("Матвей", "Игнатьев","male");
        Human human8 = new Human("Вероника", "Остроумова","female");
        Human human9 = new Human("Николай", "Угольнико","male");

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);
        familyTree.addHuman(human9);

        for (Object h: familyTree) {
            System.out.println(h.toString());

        }









    }
}
