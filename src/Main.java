import FamilyTree.FamilyTree;
import Human.Human;
import Human.Gender;
import Human.Status;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Василий", 1887, 2, 23, Gender.мужчина, Status.мертв);
        Human human2 = new Human("Евгения", 1893, 6, 23, Gender.женщина, Status.мертв);
        Human human3 = new Human("Святослав", 1922, 8, 17, Gender.мужчина, Status.мертв);
        Human human4 = new Human("Елена", 1900, 12, 22, Gender.женщина, Status.мертв);
        Human human5 = new Human("Михаил", 1894, 3, 12, Gender.мужчина, Status.мертв);
        Human human6 = new Human("Анна", 1930, 2, 5, Gender.женщина, Status.мертв);
        Human human7 = new Human("Софья", 1963, 9, 14, Gender.женщина, Status.жив);
        human3.Parents(human1, human2);
        human6.Parents(human4, human5);
        human7.Parents(human3, human6);
        FamilyTree familyTree = new FamilyTree();
        familyTree.addToList(human1);
        familyTree.addToList(human2);
        familyTree.addToList(human3);
        familyTree.addToList(human4);
        familyTree.addToList(human5);
        familyTree.addToList(human6);
        familyTree.addToList(human7);
//        familyTree.getInfoFamilyTree();
        familyTree.findByName("Василий");
    }
}
