package Seminars_OOP.HW_1;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        familyTree.addHuman(new Human("Мария", 1939, "f", null, null));
        familyTree.addHuman(new Human("Владимир", 1938, "m", null, null));
        familyTree.addHuman(new Human("Людмила", 1961, "f", "Владимир", "Мария"));
        familyTree.addHuman(new Human("Виктория", 1973, "f", "Владимир", "Мария"));
        familyTree.addHuman(new Human("Станислав", 1987, "m", "Юрий", "Людмила"));
        familyTree.addHuman(new Human("Вероника", 2013, "f", "Станислав", "Юлия"));
        familyTree.addHuman(new Human("Даниил", 2012, "m", "Игорь", "Виктория"));

        System.out.println(familyTree.getHumanByName("Даниил"));
        System.out.println(familyTree.getAllHuman());
    }

}
