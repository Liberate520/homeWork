import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        
        Human gen1Human1 = new Human("humanA1_1", LocalDate.of(1935, 8, 20), LocalDate.of(2010, 7,2), Gender.Female); 
        Human gen1Human2 = new Human("humanB1_1", LocalDate.of(1936, 5, 11), LocalDate.of(2008, 9, 14), Gender.Male); 
        Human gen2Human1 = new Human("humanA2_1", LocalDate.of(1960, 2, 11), null, Gender.Female, gen1Human1, gen1Human2);
        Human gen2Human2 = new Human("humanA2_2", LocalDate.of(1962, 9, 5), null, Gender.Female, gen1Human1, gen1Human2);
        Human gen2Human3 = new Human("humanB2_1", LocalDate.of(1961, 1, 30), null, Gender.Male);
        Human gen2Human4 = new Human("humanB2_2", LocalDate.of(1962, 10, 2), null, Gender.Male, gen1Human1, gen1Human2);
        Human gen3Human1 = new Human("humanB3_1", LocalDate.of(1990, 4, 23),null, Gender.Male, gen2Human2, gen2Human3);
        Human gen3Human2 = new Human("humanA3_1", LocalDate.of(1997, 9, 4), null, Gender.Female, gen2Human2, gen2Human3);
        Human gen3Human3 = new Human("humanA3_2", LocalDate.of(1986, 5, 19), null, Gender.Female, gen2Human1,null);


        familyTree.addHuman(gen1Human1);
        familyTree.addHuman(gen1Human2);
        familyTree.addHuman(gen2Human1);
        familyTree.addHuman(gen2Human2);
        familyTree.addHuman(gen2Human3);
        familyTree.addHuman(gen2Human4);
        familyTree.addHuman(gen3Human1);
        familyTree.addHuman(gen3Human2);
        familyTree.addHuman(gen3Human3);


        System.out.println(familyTree.printFamilyTree());
        System.out.println(familyTree.getParentName(gen3Human3));
        System.out.println(familyTree.getSiblingName(gen2Human1));
        System.out.println(familyTree.getChildName(gen1Human1));
        System.out.println(familyTree.findHumanByName());
    }
}
