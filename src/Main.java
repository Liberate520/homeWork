import FamalyTree.FamilyTree;
import FamalyTree.Gender;
import FamalyTree.Human;
import SaveAs.*;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        Human ivan = new Human(Gender.Male, "Ivan", "Ivanov", null, null);
        Human olga = new Human(Gender.Female, "Olga", "Ivanova", null, null);
        familyTree.addMember(ivan);
        familyTree.getMarried(ivan, olga);
        Human masha = new Human(Gender.Female, "Masha");
        familyTree.addChild(ivan, masha);
        Human kolya = new Human(Gender.Male, "Kolya");
        familyTree.addChild(olga, kolya);
        System.out.println(familyTree.getInfoByMember(ivan));
        System.out.println(familyTree.getInfoByMember(olga));
        Human sergey = new Human(Gender.Male, "Sergey", "Sergeev", null, null);
        familyTree.getMarried(masha, sergey);
        System.out.println(familyTree.getInfoByMember(sergey));
        System.out.println(familyTree.getInfoByMember(masha));
        System.out.println(familyTree.getParents(masha));
        System.out.println(familyTree.getBrothersAndSisters(kolya));
        System.out.println(familyTree.getPartner(sergey));
        sergey.saveAs("file", new Xml());
        serialOut(sergey);
        Human sergey1 = serialIn();
        System.out.println(sergey1.getFirstName() + " " + sergey1.getLastName());
    }
    public static void serialOut(Human human) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.out"));
        objectOutputStream.writeObject(human);
        objectOutputStream.close();
    }

    public static Human serialIn() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.out"));
        Human restored = (Human) objectInputStream.readObject();
        objectInputStream.close();
        return restored;
    }
}
