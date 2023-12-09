import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
                Human cat = new Human("Cat", "Smith",
                                null, null, null,
                                Gender.Female, LocalDate.of(1970, 7, 28), LocalDate.of(1993, 4, 21));
                Human tom = new Human("Tom", "Smith",
                                null, null, null,
                                Gender.Male, LocalDate.of(1973, 4, 21), LocalDate.of(1999, 4, 21));
                Human sam = new Human("Sam", "Smith",
                                null, null, null,
                                Gender.Male, LocalDate.of(1990, 4, 23));
                cat.addChildren(sam);
                tom.addChildren(sam);
                sam.setMather(cat);
                sam.setFather(tom);
                FamilyTree f = new FamilyTree<>();
                f.add(sam);
                f.add(cat);
                f.add(tom);

                HumanPrint.printHumanFLA((Human) f.findMather(sam));
                HumanPrint.printHumanFLA((Human) f.findFather(sam));

                FamilyTreeGUI.getChildren(f, cat);
                FamilyTreeGUI.getParents(f, sam);
                System.out.println("До сериализации:");
                FamilyTreeGUI.PrintAll(f);
                FamilyTreeGUI.SaveObject("test.dat", f);
                FamilyTree ff = FamilyTreeGUI.LoadObject("test.dat");
                System.out.println("После сериализации:");
                FamilyTreeGUI.PrintAll(ff);
                // Проверяем работу итератора
                FamilyTree<Human> familyTree = new FamilyTree<>();
                familyTree.add(tom);
                familyTree.add(sam);
                familyTree.add(cat);
                System.out.println("Печатаем всех людей");
                for (Human human : familyTree) {
                        HumanPrint.printHumanFLA(human);
                }
                System.out.println("Печатаем всех людей после сортировки по имени");
                familyTree.sortByFirstName();
                for (Human human : familyTree) {
                        HumanPrint.printHumanFLA(human);
                }
                System.out.println("Печатаем всех людей после сортировки по дате рождения");
                familyTree.sortByBirthDate();
                for (Human human : familyTree) {
                        HumanPrint.printHumanFLA(human);
                }

        }
}
