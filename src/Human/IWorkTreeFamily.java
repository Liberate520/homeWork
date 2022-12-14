package Human;

public interface IWorkTreeFamily {
    void addTreeFamily(Human human);
    void addChildren(Human baby, Human father, Human mother);
    void allHuman();
    Human loopHuman(String name);
}