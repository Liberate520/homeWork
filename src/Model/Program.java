package Seminars_OOP.HW_5.src.Model;
public class Program {
    @SuppressWarnings("UnresolvedClassReferenceRepair")
    public void Program(String[] args) {

        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler fileHandler = new FileHandler();
        familyTree.setWritable(fileHandler);
        familyTree = familyTree.readFamilyTree();

        familyTree.addHuman(new Human("Мария", 1939, "f", null, null));
        familyTree.addHuman(new Human("Владимир", 1938, "m", null, null));
        familyTree.addHuman(new Human("Людмила", 1961, "f", null, null));
        familyTree.addHuman(new Human("Виктория", 1973, "f"));
        familyTree.addHuman(new Human("Станислав", 1987, "m", null, null));
        familyTree.addHuman(new Human("Вероника", 2013, "f"));
        familyTree.addHuman(new Human("Даниил", 2012, "m", null, null));

//        System.out.println(familyTree.getHumanByName("Вероника"));
//
//        System.out.println(familyTree.getAllHuman());
//
//        for(Human human: familyTree){
//            System.out.println(human);
//        }
//
//        System.out.println();
//
//        familyTree.sortByName();
        
        //for(Human human: familyTree){
        //    System.out.println(human);
        //}

        //System.out.println();
        
        //familyTree.sortByAge();
        
//        for (Human human: familyTree){
//            System.out.println(human);
//        }


    }
}
