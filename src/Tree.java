import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Tree implements Serializable, Iterable<Human> {
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

    @Override
    public Iterator<Human> iterator() {
        return people.iterator();
    }

    public String sortedByBirthYear()
    {
        people.sort(new HumanBirthYearComparator());
        return people.toString();
    }

    public String sortedByName()
    {
        people.sort(new HumanNameComparator());
        return people.toString();
    }
}
