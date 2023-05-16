
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


//        Human person1  = new Human("ivan", "ivanov", null, null);
//        Human person2 = new Human("olga", "ivanova", null, null);
//        Human person3 = new Human("oleg","ivanov", person2, person1);
//        Human person4 = new Human("ludmila", "ivanova", person2, person1);
//        Human person5 = new Human("Igor", "Smirnov", null, null);
//        Human person6 = new Human("Dmitry", "Smirnov", person4, person5);

        FamilyTree tree = new FamilyTree();
//        tree.addHuman(person1);
//        tree.addHuman(person2);
//        tree.addHuman(person3);
//        tree.addHuman(person4);
//        tree.addHuman(person5);
//        tree.addHuman(person6);

        Writable writable = new Filehandler();
        String filePath = "src/person.txt";
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
