import family_tree.FamilyTree;
import humans.Gender;
import humans.Human;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        int id = 1;

        Human human1 = new Human(id++,
                "Иван Иванов",
                Gender.Male,
                LocalDate.of(1810, 6, 12),
                LocalDate.of(1900, 12, 10));
        Human human2 = new Human(id++,
                "Мария Иванова",
                Gender.Female,
                LocalDate.of(1808, 1, 1),
                LocalDate.of(1900, 12, 10));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);

        Human human3 = new Human(id++,
                "Степан Иванов",
                Gender.Male,
                LocalDate.of(1838, 12, 10),
                LocalDate.of(1920, 4, 22));

        human3.setFather(human1);
        human3.setMother(human2);
        familyTree.addHuman(human3);



        Human human4 = new Human(id++,
                "Петр Петров",
                Gender.Male,
                LocalDate.of(1731, 2, 6),
                LocalDate.of(1787, 4, 22));
        Human human5 = new Human(id++,
                "Марина Петрова",
                Gender.Female,
                LocalDate.of(1736, 9, 8),
                LocalDate.of(1828, 12, 10));
        Human human6 = new Human(id++,
                "Клава Петрова",
                Gender.Female,
                LocalDate.of(1753, 11, 4),
                human4,
                human5);
        Human human7 = new Human(id++,
                "Слава Петров",
                Gender.Male,
                LocalDate.of(1838, 12, 10),
                LocalDate.of(1925, 9, 14),
                human4,
                human5);

        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

//        Human human7 = new Human(id++, "Надежда Иванова", LocalDate.of(1740, 1, 14), LocalDate.of(1808, 8, 21), Gender.Female);
//        Human human8 = new Human(id++, "Варвара Васильева", LocalDate.of(1758, 12, 5), LocalDate.of(1858, 8, 12), Gender.Female);
//        Human human9 = new Human(id++, "Петр Иванов", LocalDate.of(1760, 10, 4), LocalDate.of(1840, 5, 28), Gender.Male);
//        Human human10 = new Human(id++, "Семен Иванов", LocalDate.of(1762, 11, 3), LocalDate.of(1854, 8, 11), Gender.Male);
//        Human human11 = new Human(id++, "Геннадий Васильев", LocalDate.of(1753, 1, 31), LocalDate.of(1844, 2, 22), Gender.Male);
//        Human human12 = new Human(id++, "Василиса Васильева", LocalDate.of(1778, 1, 21), LocalDate.of(1856, 10, 2), Gender.Female);


        System.out.println(familyTree);
    }
}
