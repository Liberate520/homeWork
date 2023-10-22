import java.time.LocalDate;
//Константин, это черновик, второе занятие ещё не смотрела. Понимаю, что работы мне ещё очень много
public class Main {
    public static void main(String[] args) {
        int id = -1;
        FamilyTree familyTree = new FamilyTree();//TODO настроить формат даты
        Human human1 = new Human("Адам", Gender.Male, LocalDate.of(1, 1, 1));
        Human human2 = new Human("Ева", Gender.Female, LocalDate.of(1, 1, 2));
        Human human3 = new Human("Ольга", Gender.Female, LocalDate.of(1997, 5, 13));
        Human human4 = new Human("Вика", Gender.Female, LocalDate.of(1998, 3, 19));
        Human human5 = new Human("Надя", Gender.Female, LocalDate.of(1976, 12, 21));
        Human human6 = new Human("Ваня", Gender.Male, LocalDate.of(2014, 1, 19), human5, human1);
        Human human7 = new Human("Нина Михайловна", Gender.Female, LocalDate.of(1955, 8, 31));
        Human human8 = new Human("Андрей", Gender.Male, LocalDate.of(1977, 8, 13), human2, human1);




        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);

        human8.setChildren(human4);

        familyTree.addChild(human8, human4); //TODO настроить вывод только имён детей
        //TODO настроить


        System.out.println(familyTree.getFamilyTree());

    }
}
