import ru.gb.family_tree.FamilyTree;
import ru.gb.human.Decieved;
import ru.gb.human.Gender;
import ru.gb.human.Human;
import ru.gb.human.Parent;

public class Main {
    public static void main(String[] args) throws NullPointerException {

        FamilyTree familyTree = new FamilyTree();

        Human human5 = new Decieved("Саша", Gender.Male, "22.03.1955", "03.04.2001");
        Human human4 = new Parent("Аня", Gender.Female, "03.04.1960");
        Human human3 = new Parent("Света", Gender.Female, "09.11.1984");
        Human human2 = new Parent("Костя", Gender.Male, human5, human3, "09.02.1985");
        Human human6 = new Human("Валя", Gender.Female, human5, human3, "09.02.1985");
        Human human7 = new Human("Галя", Gender.Female, human5, human3, "07.10.1980");
        Human human1 = new Human("Алиса", Gender.Female, human2, human3, "04.03.2016");

        human1.setFather(human2);
        human1.setMother(human3);
        human2.setMother(human4);
        human6.setMother(human4);
        human7.setMother(human4);
        human2.setFather(human5);
        human6.setFather(human5);
        human7.setFather(human5);

        ((Parent) human2).addChild(human1);
        ((Parent) human3).addChild(human1);
        ((Parent) human4).addChild(human2);
        ((Parent) human4).addChild(human6);
        ((Parent) human4).addChild(human7);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        System.out.println(familyTree.getFamilyInfo());
        System.out.println(((Parent) human4).getChildren());
    }
}