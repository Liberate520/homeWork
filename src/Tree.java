import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Tree implements Serializable {
    List<Human> people;

    public Tree() {}

    public Tree(List<Human> people)
    {
        this.people = people;
    }

    public Human find(String name)
    {
        for (Human human : people)
            if(human.name.equals(name))
                return human;
        
        return null;
    }

    public List<Human> getChildren(Human parentHuman)
    {
        for (Human human : people) {
            if(human.equals(parentHuman))
                return human.children;
        }

        return new ArrayList<>();
    }

    @Override
    public String toString()
    {
        String result = "[";

        for(int i = 0; i < people.size(); i++)
        {
            result += people.get(i).toString();

            if(people.size() - 1 != i)
                result += ",";
        }

        result += "]";

        return result;
    }
}
