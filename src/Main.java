import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        FamilyTree familyTree = new FamilyTree();//TODO настроить формат даты
        Human human1 = new Human(id++, "Адам", Gender.Male, LocalDate.of(1, 1, 1));
        Human human2 = new Human(id++, "Ева", Gender.Female, LocalDate.of(1, 1, 2));
        Human human3 = new Human(id++, "Ольга", Gender.Female, LocalDate.of(1997, 5, 13));
        Human human4 = new Human(id++, "Вика", Gender.Female, LocalDate.of(1998, 3, 19));
        Human human5 = new Human(id++, "Надя", Gender.Female, LocalDate.of(1976, 12, 21));
        Human human6 = new Human(id++, "Ваня", Gender.Male, LocalDate.of(2014, 1, 19), human5, human1);
        Human human7 = new Human(id++, "Нина Михайловна", Gender.Female, LocalDate.of(1955, 8, 31));
        Human human8 = new Human(id++, "Андрей", Gender.Male, LocalDate.of(1977, 8, 13), human2, human1);




        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);

//        human8.setChildren(human4);

        familyTree.addChild(human8, human4); //TODO настроить вывод только имён детей
        //TODO настроить


        System.out.println(familyTree.getFamilyTree());

    }
}
