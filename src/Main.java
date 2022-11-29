import human.Human;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IThree iThree = new TreeFamily();
        Human human = new Human("Boris",84);
        Human human1 = new Human("Marina",82);
        Human human2 = new Human("Vasya",59);
        Human human3 = new Human("Masha",57);
        Human human4 = new Human("Sofi",37);
        Human human5 = new Human("Petr",45);
        Human human6 = new Human("Yana",25);
        Human human7 = new Human("Den",24);
        Human human8 =new Human("Roma",50);
        iThree.addTreeFamily(human);
        iThree.addTreeFamily(human1);
        iThree.addTreeFamily(human2);
        iThree.addTreeFamily(human3);
        iThree.addTreeFamily(human4);
        iThree.addTreeFamily(human5);
        iThree.addTreeFamily(human6);
        iThree.addTreeFamily(human7);
        iThree.addTreeFamily(human8);

        iThree.addChildren(human2,human,human1);
        iThree.addChildren(human3,human,human1);
        iThree.addChildren(human5,human,human1);
        iThree.addChildren(human6,human5,human4);
        iThree.addChildren(human4,human3,human8);
        iThree.addChildren(human7,human3,human8);

        iThree.searchHuman("Masha");
        iThree.searchHuman("Sofi");
        iThree.searchHuman("Boris");
        iThree.searchHuman("Petr");

    }


}
