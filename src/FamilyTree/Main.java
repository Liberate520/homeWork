package FamilyTree;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TreeLoader fl = new TreeLoader();

        // 1 часть

        Human human1 = new Human("Vasilij M.", new Date(85,1,1), Gender.Male);
        Human human2 = new Human("Natalia O.", new Date(87,1,1), Gender.Female);
        Human human3 = new Human("Petr V.", new Date(105,1,1), Gender.Male);
        Human human4 = new Human("Polina P.", new Date(125,1,1),Gender.Female);
        FamilyTree tree1 = new FamilyTree("OurFamily", human4);
        tree1.addMember(human3, Arrays.asList(0));
        tree1.addMember(human2, Arrays.asList(1));
        tree1.addMember(human1, Arrays.asList(1));
        fl.Save("Tree1", tree1);

        // 2 часть

//        FamilyTree tree1 = fl.Load("Tree1");
//        System.out.print(tree1.ShowAllTree());
//        System.out.print(tree1.memberFullInfo(1));


    }
}