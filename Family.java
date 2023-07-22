import java.util.ArrayList;
import java.util.List;

public class Family {
    private List<Human> family;
    String father;
    String mother;
    String son;
    Human daughter;
    String brother;
    String sister;


//    public String getFamilyMembers(Family family){
//
//    }

    public Family() {
        family = new ArrayList<>();
    }
    public void father(Human human) {

    }
    public void mother(Human human) {

    }
    public void son(Human human) {

    }
    public void daughter(Human human) {
        family.add(human);
    }
    public void brother(Human human) {

    }
    public void sister(Human human) {

    }
}
