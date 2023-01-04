import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human extends Mammal {

    public Human(String name, String gender, Mammal father, Mammal mother) {
        super(name, gender, father, mother);
        setType("human");
    }

    public Human(String name, String gender) {
        super(name, gender);
        setType("human");
    }


//    @Override
//    public String toString() {
//        String s = "name: " + name + "; gender: " + gender;
//
//        if (father != null)
//            s += "; father: " + father.name;
//
//        if (mother != null)
//            s += "; mother: " + mother.name;
//
//        if (children.size() > 0) {
//            s += "; ";
//            for (int i = 0; i < children.size(); i++) {
//                if (children.get(i).gender.equals("male"))
//                    s += "son: " + children.get(i).name;
//                else
//                    s += "daughter: " + children.get(i).name;
//                s += (i < children.size() - 1 ? "; " : "");
//            }
//        }
//
//        List<Human>  brothersSistersList = getBrothersSisters();
//        if (brothersSistersList.size() > 0) {
//            s += "; ";
//            for (int i = 0; i < brothersSistersList.size(); i++) {
//                if (brothersSistersList.get(i).gender.equals("male"))
//                    s += "brother: " + brothersSistersList.get(i).name;
//                else
//                    s += "sister: " + brothersSistersList.get(i).name;
//                s += (i < brothersSistersList.size() - 1 ? "; " : "");
//            }
//        }
//        return s;
//    }

}
