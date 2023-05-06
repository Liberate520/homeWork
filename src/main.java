
import java.io.IOException;


public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Human person1  = new Human("ivan", "ivanov", null, null);
        Human person2 = new Human("olga", "ivanova", null, null);
        Human person3 = new Human("oleg","ivanov", person2, person1);
        Human person4 = new Human("ludmila", "ivanova", person2, person1);
        Human person5 = new Human("Igor", "Smirnov", null, null);
        Human person6 = new Human("Dmitry", "Smirnov", person4, person5);

        FamilyThree tree = new FamilyThree();
        tree.addHuman(person1);
        tree.addHuman(person2);
        tree.addHuman(person3);
        tree.addHuman(person4);
        tree.addHuman(person5);
        tree.addHuman(person6);

        Writable writeable = new FileHandler();
        String filePath = "src/person.txt";
        writeable.write(tree, filePath);
        FamilyThree familyThree = (FamilyThree) writeable.read(filePath);
        for (Human human: familyThree.getHumans()
             ) {
            tree.printTree(human);
        }


    }
}
