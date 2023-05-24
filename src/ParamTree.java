import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParamTree <T extends Human> implements Serializable, Iterable<T> {
    List<T> people;

    public ParamTree(List<T> people)
    {
        this.people = people;
    }

    public T find(String name)
    {
        for (T human : people)
            if(human.name.equals(name))
                return human;
        
        return null;
    }

    public List getChildren(T parentHuman)
    {
        for (T human : people) {
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
    public Iterator<T> iterator() {
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
