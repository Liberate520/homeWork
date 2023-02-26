package Tree;

import UserInterface.Console;
import UserInterface.View;


public class Main {
    public static void main(String[] args) {

        Family family = new Family();
        Human igor = new Human("Igor", 34, "male");
        Human aleks = new Human("Aleks", 30, "Female");
        Human vova = new Human("Vladimir", 8, "Male", igor, aleks);
        Human grisha = new Human("Grisha", 5, "Male", igor, aleks);

        family.addHuman(igor);
        family.addHuman(aleks);
        family.addHuman(vova);
        family.addHuman(grisha);

        View view = new Console();
        view.start();

//        Serializator ser = new Serializator();
//        ser.serialization(family);


        //        for (Human human: family) {
        //            System.out.println(human);
        //
        //        }
        //        family.sort();
        //        System.out.println("=============================");
        //        System.out.println("----------------Семейное древо------------------------");
        //
        //        for (Human human: family) {
        //            System.out.println(human);
        //
        //        }





    }
}