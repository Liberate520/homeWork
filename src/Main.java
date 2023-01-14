public class Main {

    public static void main(String[] args)  {

        // Human family tree
        FamilyTree<Human> humanFamilyTree = new FamilyTree("Family tree of Lidia Andriyanova");

        Human human1 = new Human(1, "Vitaliy", "male");
        Human human2 = new Human(2, "Natalia", "female");
        Human human3 = new Human(3, "Lidia", "female", human1, human2);
        Human human4 = new Human(4,"Ilya", "male");
        Human human5 = new Human(5, "Roman", "male", human4, human3);
        Human human6 = new Human(6, "Victor", "male", human4, human3);
        Human human7 = new Human(7,"Ivan", "male", human4, human3);

        humanFamilyTree.addMember(human1);
        humanFamilyTree.addMember(human2);
        humanFamilyTree.addMember(human3);
        humanFamilyTree.addMember(human4);
        humanFamilyTree.addMember(human5);
        humanFamilyTree.addMember(human6);
        humanFamilyTree.addMember(human7);

        // Cat family tree
        FamilyTree<Cat> catFamilyTree = new FamilyTree("Family tree of Leopold british cat");

        Cat cat1 = new Cat(1,"Leopold", "male");
        Cat cat2 = new Cat(2,"Murka", "female");
        Cat cat3 = new Cat(3,"Mashka", "female", cat1, cat2);
        Cat cat4 = new Cat(4,"Murzik", "male");
        Cat cat5 = new Cat(5,"Vaska", "male", cat4, cat3);
        Cat cat6 = new Cat(6,"Barsik", "male", cat4, cat3);
        Cat cat7 = new Cat(7,"Luska", "female", cat4, cat3);
        Cat cat8 = new Cat(8,"Belka", "female", cat4, cat3);

        catFamilyTree.addMember(cat1);
        catFamilyTree.addMember(cat2);
        catFamilyTree.addMember(cat3);
        catFamilyTree.addMember(cat4);
        catFamilyTree.addMember(cat5);
        catFamilyTree.addMember(cat6);
        catFamilyTree.addMember(cat7);
        catFamilyTree.addMember(cat8);

        View view = new ConsoleUI();
        Service service = new FamilyTreeService(humanFamilyTree);
        service.addFamilyTree(catFamilyTree);
        Presenter presenter = new Presenter(view, service);
        view.start();

    }
}
