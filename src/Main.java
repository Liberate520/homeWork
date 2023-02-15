public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        fillTree(tree);
        Human testSub = tree.getPersonByID(21); //ожидаемый результат см. tree.jpg
        System.out.println(testSub);
        System.out.println("\n====================TEST ShowChildren====================\n");
        tree.showChildren(testSub);
        System.out.println("\n====================TEST ShowParents====================\n");
        tree.showParents(testSub);
        System.out.println("\n====================TEST ShowGrandParents====================\n");
        tree.showGrandParents(testSub);

    }

    public static void fillTree(FamilyTree tree){
        tree.addPerson(new Human("Frederick", "Harrington", Gender.MALE));
        tree.addPerson(new Human("Bruce", "Baker", Gender.MALE));
        tree.addPerson(new Human("Wilson", "Rogers", Gender.MALE));
        tree.addPerson(new Human("Judith", "Brady", Gender.FEMALE));
        tree.addPerson(new Human("Michelle", "Powell", Gender.FEMALE));
        tree.addPerson(new Human("Hannah", "Nichols", Gender.FEMALE));
        tree.addPerson(new Human("Bethany", "Harris", Gender.FEMALE));
        tree.addPerson(new Human("Edith", "Lyons", Gender.FEMALE));
        tree.addPerson(new Human("Dianne", "Brooks", Gender.FEMALE));
        tree.addPerson(new Human("Ron", "Riley", Gender.MALE));
        tree.addPerson(new Human("Trevor", "Drake", Gender.MALE));
        tree.addPerson(new Human("Dean", "Copeland", Gender.MALE));
        tree.addPerson(new Human("Daniel", Gender.MALE), tree.getPersonByID(1), tree.getPersonByID(7));
        tree.addPerson(new Human("Sabrina", Gender.FEMALE), tree.getPersonByID(2), tree.getPersonByID(8));
        tree.addPerson(new Human("Julia", Gender.FEMALE), tree.getPersonByID(2), tree.getPersonByID(8));
        tree.addPerson(new Human("Austin", Gender.MALE), tree.getPersonByID(3), tree.getPersonByID(9));
        tree.addPerson(new Human("Ruby", Gender.FEMALE), tree.getPersonByID(4), tree.getPersonByID(10));
        tree.addPerson(new Human("Erica", Gender.FEMALE), tree.getPersonByID(5), tree.getPersonByID(11));
        tree.addPerson(new Human("Marcos", Gender.MALE), tree.getPersonByID(6), tree.getPersonByID(12));
        tree.addPerson(new Human("Courtney", Gender.FEMALE), tree.getPersonByID(13), tree.getPersonByID(14));
        tree.addPerson(new Human("Cassandra", Gender.FEMALE), tree.getPersonByID(13), tree.getPersonByID(14));
        tree.addPerson(new Human("Paul", Gender.MALE), tree.getPersonByID(16), tree.getPersonByID(17));
        tree.addPerson(new Human("Marie", Gender.FEMALE), tree.getPersonByID(16), tree.getPersonByID(17));
        tree.addPerson(new Human("Colin", Gender.MALE), tree.getPersonByID(18), tree.getPersonByID(19));
        tree.addPerson(new Human("Megan", Gender.FEMALE), tree.getPersonByID(18), tree.getPersonByID(19));
        tree.addPerson(new Human("Garry", "Anderson", Gender.MALE));
        tree.addPerson(new Human("Miranda", Gender.FEMALE), tree.getPersonByID(21), tree.getPersonByID(22));
        tree.addPerson(new Human("Shaun", Gender.MALE), tree.getPersonByID(21), tree.getPersonByID(22));
        tree.addPerson(new Human("Amy", "Summers",Gender.FEMALE));
        tree.addPerson(new Human("Emily", Gender.FEMALE), tree.getPersonByID(23), tree.getPersonByID(24));
        tree.addPerson(new Human("Travis", "Goodwin",Gender.MALE));
        tree.addPerson(new Human("Hannah", Gender.FEMALE), tree.getPersonByID(26), tree.getPersonByID(27));
        tree.addPerson(new Human("Dean", Gender.MALE), tree.getPersonByID(28), tree.getPersonByID(29));
        tree.addPerson(new Human("Marty", Gender.MALE), tree.getPersonByID(28), tree.getPersonByID(29));
        tree.addPerson(new Human("Jon", Gender.MALE), tree.getPersonByID(30), tree.getPersonByID(31));

    }
}