import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    public String name;
    public int birthYear;
    public Gender gender;

    public List<String> parents;
    public List<Human> children;

    public Human(String name, int birthYear, Gender gender){
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;

        children = new ArrayList<>();
        parents = new ArrayList<>();
    }

    public void AddChild(Human human)
    {
        children.add(human);
        human.parents.add(this.name);
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        else if(!(o instanceof Human))
            return false;
        else{
            Human human = (Human)(o);
            return this.name.equals(human.name)
                && this.birthYear == human.birthYear
                && this.gender == human.gender;
        }
    }

    @Override
    public String toString()
    {
        return "Human {" + 
            "name='" + name + "'" +
            ", birthyear=" + birthYear +
            ", gender=" + gender + 
            ", children=" + children.toString() +
            ", parents=" + parents.toString() +
            "}\n";
    }
}
