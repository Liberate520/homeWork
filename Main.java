package three;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Shrack","male",0,null,null);
        Human mother = new Human("Fiona","female",1,null,null);
        Human grandpa = new Human("Max", "male",5,null,null);
        Human grandma = new Human("Mary","female",4,null,null);
        Human father1 = new Human("Mike","male",1,null,null);
        Human mother1 = new Human("Jane","female",3,null,null);

        FamilyThree familyThree = new FamilyThree();
        familyThree.add(father1);
        familyThree.add(father);
        familyThree.add(mother1);
        familyThree.add(mother);
        familyThree.add(grandma);
        familyThree.add(grandpa);

        System.out.println(familyThree.findHumanName("Shrack"));
        System.out.println(familyThree.getInfo());

    }
}
