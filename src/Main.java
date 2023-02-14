

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        fillTree(tree);
        Person testSub = tree.getPersonByID(21); //ожидаемый результат см. tree.jpg
        System.out.println(testSub);
        System.out.println("\n====================TEST ShowChildren====================\n");
        tree.showChildren(testSub);
        System.out.println("\n====================TEST ShowParents====================\n");
        tree.showParents(testSub);
        System.out.println("\n====================TEST ShowGrandParents====================\n");
        tree.showGrandParents(testSub);
    
    }

    public static void fillTree(FamilyTree tree){
        tree.addPerson(new Person("Frederick", "Harrington", Sex.MALE));
        tree.addPerson(new Person("Bruce", "Baker", Sex.MALE));
        tree.addPerson(new Person("Wilson", "Rogers", Sex.MALE));
        tree.addPerson(new Person("Judith", "Brady", Sex.FEMALE));
        tree.addPerson(new Person("Michelle", "Powell", Sex.FEMALE));
        tree.addPerson(new Person("Hannah", "Nichols", Sex.FEMALE));
        tree.addPerson(new Person("Bethany", "Harris", Sex.FEMALE));
        tree.addPerson(new Person("Edith", "Lyons", Sex.FEMALE));
        tree.addPerson(new Person("Dianne", "Brooks", Sex.FEMALE));
        tree.addPerson(new Person("Ron", "Riley", Sex.MALE));
        tree.addPerson(new Person("Trevor", "Drake", Sex.MALE));
        tree.addPerson(new Person("Dean", "Copeland", Sex.MALE));
        tree.addPerson(new Person("Daniel", Sex.MALE), tree.getPersonByID(1), tree.getPersonByID(7));
        tree.addPerson(new Person("Sabrina", Sex.FEMALE), tree.getPersonByID(2), tree.getPersonByID(8));
        tree.addPerson(new Person("Julia", Sex.FEMALE), tree.getPersonByID(2), tree.getPersonByID(8));
        tree.addPerson(new Person("Austin", Sex.MALE), tree.getPersonByID(3), tree.getPersonByID(9));
        tree.addPerson(new Person("Ruby", Sex.FEMALE), tree.getPersonByID(4), tree.getPersonByID(10));
        tree.addPerson(new Person("Erica", Sex.FEMALE), tree.getPersonByID(5), tree.getPersonByID(11));
        tree.addPerson(new Person("Marcos", Sex.MALE), tree.getPersonByID(6), tree.getPersonByID(12));
        tree.addPerson(new Person("Courtney", Sex.FEMALE), tree.getPersonByID(13), tree.getPersonByID(14));
        tree.addPerson(new Person("Cassandra", Sex.FEMALE), tree.getPersonByID(13), tree.getPersonByID(14));
        tree.addPerson(new Person("Paul", Sex.MALE), tree.getPersonByID(16), tree.getPersonByID(17));
        tree.addPerson(new Person("Marie", Sex.FEMALE), tree.getPersonByID(16), tree.getPersonByID(17));
        tree.addPerson(new Person("Colin", Sex.MALE), tree.getPersonByID(18), tree.getPersonByID(19));
        tree.addPerson(new Person("Megan", Sex.FEMALE), tree.getPersonByID(18), tree.getPersonByID(19));
        tree.addPerson(new Person("Garry", "Anderson", Sex.MALE));
        tree.addPerson(new Person("Miranda", Sex.FEMALE), tree.getPersonByID(21), tree.getPersonByID(22));
        tree.addPerson(new Person("Shaun", Sex.MALE), tree.getPersonByID(21), tree.getPersonByID(22));
        tree.addPerson(new Person("Amy", "Summers",Sex.FEMALE));
        tree.addPerson(new Person("Emily", Sex.FEMALE), tree.getPersonByID(23), tree.getPersonByID(24));
        tree.addPerson(new Person("Travis", "Goodwin",Sex.MALE));
        tree.addPerson(new Person("Hannah", Sex.FEMALE), tree.getPersonByID(26), tree.getPersonByID(27));
        tree.addPerson(new Person("Dean", Sex.MALE), tree.getPersonByID(28), tree.getPersonByID(29));
        tree.addPerson(new Person("Marty", Sex.MALE), tree.getPersonByID(28), tree.getPersonByID(29));
        tree.addPerson(new Person("Jon", Sex.MALE), tree.getPersonByID(30), tree.getPersonByID(31));

    }
}
