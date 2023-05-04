import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {


        Human person1  = new Human("ivan", "ivanov", null, null);
        Human person2 = new Human("olga", "ivanova", null, null);
        Human person3 = new Human("oleg","ivanov", person2, person1);
        Human person4 = new Human("ludmila", "ivanova", person2, person1);
        Human person5 = new Human("Igor", "Semenov", null, null);
        Human person6 = new Human("Dmitry", "Semenov", person4, person5);

        FamilyThree tree = new FamilyThree();
        tree.addHuman(person1);
        tree.addHuman(person2);
        tree.addHuman(person3);
        tree.addHuman(person4);
        tree.addHuman(person5);
        tree.addHuman(person6);
        tree.printTree(person1);
        tree.printTree(person2);
        tree.printTree(person3);
        tree.printTree(person4);
        tree.printTree(person5);
        tree.printTree(person6);
    }
}
