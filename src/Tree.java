import java.util.ArrayList;
import java.util.List;

public class Tree {
    List<Human> people;

    public Tree(List<Human> people)
    {
        this.people = people;
    }

    public Human Find(String name)
    {
        for (Human human : people)
            if(human.name.equals(name))
                return human;
        
        return null;
    }

    public List<Human> GetChildren(Human parentHuman)
    {
        for (Human human : people) {
            if(human.equals(parentHuman))
                return human.children;
        }

        return new ArrayList<>();
    }
}
