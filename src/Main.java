public class Main {

    public static void main(String[] args)  {

        // Human family tree
        FamilyTree<Human> humanFamilyTree = new FamilyTree();

        Human human1 = new Human("Vitaliy", "male");
        Human human2 = new Human("Natalia", "female");
        Human human3 = new Human("Lidia", "female", human1, human2);
        Human human4 = new Human("Ilya", "male");
        Human human5 = new Human("Roman", "male", human4, human3);
        Human human6 = new Human("Victor", "male", human4, human3);
        Human human7 = new Human("Ivan", "male", human4, human3);

        humanFamilyTree.addMember(human1);
        humanFamilyTree.addMember(human2);
        humanFamilyTree.addMember(human3);
        humanFamilyTree.addMember(human4);
        humanFamilyTree.addMember(human5);
        humanFamilyTree.addMember(human6);
        humanFamilyTree.addMember(human7);

        // Cat family tree
        FamilyTree<Cat> catFamilyTree = new FamilyTree();

        Cat cat1 = new Cat("Barsik", "male");
        Cat cat2 = new Cat("Murka", "female");
        Cat cat3 = new Cat("Mashka", "female", cat1, cat2);
        Cat cat4 = new Cat("Murzik", "male");
        Cat cat5 = new Cat("Vaska", "male", cat4, cat3);
        Cat cat6 = new Cat("Mishka", "male", cat4, cat3);
        Cat cat7 = new Cat("Luska", "female", cat4, cat3);
        Cat cat8 = new Cat("Belka", "female", cat4, cat3);

        catFamilyTree.addMember(cat1);
        catFamilyTree.addMember(cat2);
        catFamilyTree.addMember(cat3);
        catFamilyTree.addMember(cat4);
        catFamilyTree.addMember(cat5);
        catFamilyTree.addMember(cat6);
        catFamilyTree.addMember(cat7);
        catFamilyTree.addMember(cat8);

        // Save and restore family tree by stream writer
//        Writable StreamHandler = new StreamHandler("HumanFamilyTree.ser");
//        humanFamilyTree.setWriter(StreamHandler);
//        humanFamilyTree.save();
//
//        humanFamilyTree.load();
//        System.out.println("");
//        System.out.println("Human family tree from stream: ");
//        System.out.println(humanFamilyTree);

        // Save and restore family tree by file writer
//        Writable FileHandler = new FileHandler("HumanFamilyTree.txt");
//        humanFamilyTree.setWriter(FileHandler);
//        humanFamilyTree.save();
//
//        humanFamilyTree.load();
//        System.out.println("");
//        System.out.println("Human family tree from file: ");
//        System.out.println(humanFamilyTree);

//        System.out.println("Iterable humans from family tree: ");
//        for (Human human: humanFamilyTree)
//            System.out.println(human);
//        System.out.println();
//
//        System.out.println("Iterable cats from family tree: ");
//        for (Mammal member: catFamilyTree)
//            System.out.println(member);
//        System.out.println();
//
//        System.out.println("Sort humans by name from family tree: ");
//        humanFamilyTree.sortByName();
//        for (Human human: humanFamilyTree)
//            System.out.println(human);
//        System.out.println();
//
//        System.out.println("Sort humans by children count desc from family tree: ");
//        humanFamilyTree.sortByChildrenCountDesc();
//        for (Human human: humanFamilyTree)
//            System.out.printf("%s%s %d\n", human, "; children count:", human.getChildren().size());
//        System.out.println();

//        FamilyTree userFamilyTree = humanFamilyTree;
        FamilyTree userFamilyTree = catFamilyTree;

        View view = new ConsoleUI();
        Service service = new FamilyTreeService(userFamilyTree);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
