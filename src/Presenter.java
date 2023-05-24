import java.util.List;

public class Presenter {
    public Presenter() {}

    public Human createHuman(String name, int birthYear, Gender gender)
    {
        return new Human(name, birthYear, gender);
    }

    public String humanToString(Human h)
    {
        return h.toString();
    }

    public Tree createTree(List<Human> people)
    {
        return new Tree(people);
    }

    public ParamTree<Human> createParamTree(List<Human> people)
    {
        return new ParamTree<Human>(people);
    }

    public void saveTree(String path, Tree t)
    {
        FileInteraction fi = new FileInteraction(t);
        fi.Save(path);
    }
}
