import FamilyTree.FamilyTree;
import FamilyTreeObject.Humans.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTreeHumans = new FamilyTree();
        Human human1 = new Human("Иван", "Петров", "male");
        Human human2 = new Human("Федор", "Петров","male");
        Human human3 = new Human("Денис", "Иванов","male");
        Human human4 = new Human("Андрей", "Егоров","male");
        Human human5 = new Human("Илья", "Бобров","male");
        Human human6 = new Human("Даша", "Давыдова","female");
        Human human7 = new Human("Матвей", "Игнатьев","male");
        Human human8 = new Human("Вероника", "Остроумова","female");
        Human human9 = new Human("Николай", "Угольнико","male");

        familyTreeHumans.addElement(human1);
        familyTreeHumans.addElement(human2);
        familyTreeHumans.addElement(human3);
        familyTreeHumans.addElement(human4);
        familyTreeHumans.addElement(human5);
        familyTreeHumans.addElement(human6);
        familyTreeHumans.addElement(human7);
        familyTreeHumans.addElement(human8);
        familyTreeHumans.addElement(human9);

        for (Object h: familyTreeHumans) {
            System.out.println(h.toString());

        }









    }
}
