import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree1 = new FamilyTree();
        
        Human human1 = new Human("Иван", Gender.male);
        Human human2 = new Human("Мария", Gender.female);
        Human human3 = new Human("Анна", Gender.female, human1, human2);
        Human human4 = new Human("Пётр", Gender.male, human1, human2);
        Human human5 = new Human("Владимир", Gender.male, human1, human2);
        Human human6 = new Human("Александр", Gender.male);
        Human human7 = new Human("Николай", Gender.male,human6,human3);
        Human human8 = new Human("Софья", Gender.female);

        familyTree1.addHuman(human1);
        familyTree1.addHuman(human2);
        familyTree1.addHuman(human3);
        familyTree1.addHuman(human4);
        familyTree1.addHuman(human5);
        familyTree1.addHuman(human6);
        familyTree1.addHuman(human7);
        familyTree1.addHuman(human8);
        System.out.println(familyTree1.getAllHumanToString());
        System.out.println(familyTree1.getChildrenToString(human1));
        System.out.println(familyTree1.getByName("Пётр").getInfo());


    }
}
