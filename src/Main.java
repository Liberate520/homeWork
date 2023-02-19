import java.util.ArrayList;
import java.util.Iterator;

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

//        Serializator ser = new Serializator();
//        System.out.println(ser.deserialization());



        for (Human human: family) {
            System.out.println(human);

        }
        family.sort();
        System.out.println("=============================");

        for (Human human: family) {
            System.out.println(human);

        }













    }




}
