package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Input {
    public void printIn() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("src\\tree\\Input.out"));
        FamilyTree dadRestored = (FamilyTree) objectInputStream.readObject();

        // вот тут вопрос - как мне через цикл распечатать dadRestored
        // чтобы члены семьи шли строчка за строчкой друг под другом,
        // а не в одну строку друг за другом? запутался тут
        // for (FamilyTree fam : dadRestored) {

        // }
        System.out.println(dadRestored.getPeopleList());
        objectInputStream.close();
    }
}
