public class Main {

    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Виталий", "мужской");
        Human human2 = new Human("Наталья", "женский");
        Human human3 = new Human("Лидия", "женский", human1, human2);
        Human human4 = new Human("Илья", "мужской");
        Human human5 = new Human("Роман", "мужской", human4, human3);
        Human human6 = new Human("Виктор", "мужской", human4, human3);
        Human human7 = new Human("Иван", "мужской", human4, human3);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        System.out.println("Все генеалогическое дерево: ");
        System.out.println(familyTree);

        System.out.println("Поиск по имени Лидия: ");
        System.out.println(familyTree.getHumanByName("Лидия"));
    }
}
