package ThreeFamily;
import Human.Human;

public interface IThree {

    void addTreeFamily(Human human);
    Human searchHuman(String name);
    void addChildren(Human baby, Human father, Human mother);
    void LoopHuman(String name);
    void allHuman();

}
