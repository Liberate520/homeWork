import java.util.List;

public interface IFamilyTree {
    List<Human> getHumans();

    void addHuman(Human human, Human father, Human mother);
}
