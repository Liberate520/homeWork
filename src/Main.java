public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human human1 = new Human("Panaitov", "Ivan", "Vasilievich", Gender.Male, 1995, 8, 9);
        tree.addPerson(human1);
        tree.addFather("Panaitov", "Vasiliy", "Ivanovich", Gender.Male, 1969, 8, 12, human1);
        tree.addMother("Panaitova", "Zinaida", "Petrovna", Gender.Female, 1971, 8, 11, human1);
        tree.addFather("Panaitov","Ivan", "Stepanovich", Gender.Male,1948, 10, 21, human1.getFather());
        tree.addMother("Panaitova", "Pelageya", "Constantinovna", Gender.Female, 1949, 10, 7, human1.getMother());
        System.out.println(human1);
        System.out.println("Родители " + human1.getName() + "\n" + tree.findParents(human1));
        System.out.println("Дедушка " + human1.getName() + ":\n" + human1.getFather().getFather());
        System.out.println("Бабушка " + human1.getName() + ":\n" + human1.getMother().getMother());
    }
}
