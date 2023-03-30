public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Никита", "Вавилов", "1974-11-21", Sex.male);
        Human human2 = new Human("Ольга", "Павлова", "1975-06-15", Sex.female);
        Human human3 = new Human("Федор", "Никитин", "2000-03-08", Sex.male);
        Human human4 = new Human("Нина", "Антонова", "2003-01-27", Sex.female);
        Human human5 = new Human("Виктор", "Маркин", "2023-08-18", Sex.female);
        Human human6 = new Human("Спиридон", "Кутузов", "1975-08-15", Sex.male);

        FamilyTree familyTree = new FamilyTree();

        familyTree.add(human1);
        familyTree.add(human2);
        familyTree.add(human3);
        familyTree.add(human4);
        familyTree.add(human5);
        familyTree.add(human6);

        // System.out.println(humanThree.getChildrens());w
        // System.out.println(familyTree);
        System.out.println(familyTree.search("Кутузов"));
    }
}
