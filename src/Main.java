
import familystructure.familycomparator.FamilyGroup;
import familystructure.FamilyTree;
import writeAndread.Filehandler;
import writeAndread.Writable;
import human.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


//        Human person1  = new human.Human("ivan", "ivanov", null, null);
//        Human person2 = new human.Human("olga", "ivanova", null, null);
//        Human person3 = new human.Human("oleg","ivanov", person2, person1);
//        Human person4 = new human.Human("ludmila", "ivanova", person2, person1);
//        Human person5 = new human.Human("Igor", "Smirnov", null, null);
//        Human person6 = new human.Human("Dmitry", "Smirnov", person4, person5);

        FamilyTree tree = new FamilyTree();
//        tree.addHuman(person1);
//        tree.addHuman(person2);
//        tree.addHuman(person3);
//        tree.addHuman(person4);
//        tree.addHuman(person5);
//        tree.addHuman(person6);

        Writable writable = new Filehandler();
        String filePath = "src/writeAndread/person.txt";
//        writable.write(tree, filePath);
        FamilyTree familyThree = (FamilyTree) writable.read(filePath);

        System.out.println("Без сортировки: " + familyThree.getHumans());
        familyThree.sortByName();
        System.out.println("Сортировка по фамилии: " + familyThree.getHumans());
        familyThree.sortByChild();
        System.out.println("Сортировка по кол-ву детей в порядке возрастания: ");
        for (Object human: familyThree.getHumans()
             )
            tree.printTree((FamilyGroup) human);

    }
}
