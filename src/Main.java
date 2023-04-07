import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        while(true){
            FamilyTree familyTree = new FamilyTree();
            Human human1 = new Human(1, "Стрешнева Евдокия", LocalDate.of(1922, 10, 14), LocalDate.of(2009, 05, 10),
                    null, null, null);
            familyTree.addHuman(human1);

            Human human2 = new Human(2, "Нарышкина Наталья", LocalDate.of(1957, 3, 25), null, human1, null, null);
            familyTree.addHuman(human2);

            Human human3 = new Human(3, "Романов Михаил", LocalDate.of(1957, 8, 02), null, null, null, null);
            familyTree.addHuman(human3);

            Human human4 = new Human(4, "Салтыкова Прасковья", LocalDate.of(1979, 9, 14), null, human2, human3, null);
            familyTree.addHuman(human4);

            Human human5 = new Human(5, "Милославская Мария", LocalDate.of(1987, 04, 02), null, human2, human3, null);
            familyTree.addHuman(human5);

            Human human6 = new Human(6, "Романов Алексей", LocalDate.of(2010, 8, 11), null, human4, null, null);
            familyTree.addHuman(human6);

            Human human7 = new Human(7, "Романов Иоанн", LocalDate.of(2013, 7, 28), null, human4, null, null);
            familyTree.addHuman(human7);

            System.out.println(familyTree.toString());
            familyTree.findHuman();
        }
    }
}