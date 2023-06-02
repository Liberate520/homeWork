public class Main {
    public static void main(String[] args) {
        Human father = new Human(33,"Shrack","male",0);
        Human mother = new Human(28,"Fiona","female",1);
        Human grandpa = new Human(63,"Max", "male",5);
        Human grandma = new Human(59,"Mary","female",4);
        Human father1 = new Human(23,"Mike","male",1);
        Human mother1 = new Human(25,"Jane","female",3);

        FamilyThree familyThree = new FamilyThree();
        familyThree.addFamily(father1);
        familyThree.addFamily(father);
        familyThree.addFamily(mother1);
        familyThree.addFamily(mother);
        familyThree.addFamily(grandma);
        familyThree.addFamily(grandpa);

        System.out.println(familyThree.findHumanName("Shrack"));
        System.out.println(familyThree.findHumanSisterBrother(1));
        System.out.println(familyThree.getFamilyList());

    }
}
