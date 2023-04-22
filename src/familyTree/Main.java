package familyTree;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();

        newTree.addNewHuman(new Human("Петров Пётр Петрович", Gender.male,
                "31.03.1973", "",
                "Петрова Ольга Александровна", "Петров Пётр Иванович",
                "Петрова Анастасия Валерьевна",
                "Петров Константин Петрович"));

        newTree.addNewHuman(new Human("Петров Константин Петрович", Gender.male,
                "04.11.1994", "",
                "Петрова Лидия Константиновна", "Петров Пётр Петрович",
                "Петрова Мария Фёдоровна",
                ""));

        System.out.println(newTree.showAll());
        newTree.savingTree("familyTree.ser");
    }
}
