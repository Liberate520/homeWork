import java.util.ArrayList;
import java.util.List;

public class Human {
    public String name;
    public String surname;
    public int birthYear;
    public Gender gender;

    public Human mother;
    public Human father;

    public List<Human> children;

    public Human(String name, String surname, int birthYear, Human mother, Human father, Gender gender)
    {
        this.mother = mother;
        this.father = father;

        this.gender = gender;

        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;

        children = new ArrayList<>();
    }

    public Human(String name, String surname, int birthYear, Gender gender)
    {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;

        this.gender = gender;

        children = new ArrayList<>();
    }

    public Human addChild(String name, int birthYear, Gender gender, Human otherParent)
    {
        Human child = null;

        if(this.gender == Gender.Female)
            child = new Human(name, otherParent.surname, birthYear, this, otherParent, gender);
        else
            child = new Human(name, this.surname, birthYear, otherParent, this, gender);
        
        children.add(child);
        otherParent.children.add(child);
        return child;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
 
        if (!(o instanceof Human)) 
            return false;
         
        Human human = (Human) o;
         
        return this.name.equals(human.name)
            && this.surname.equals(human.surname)
            && this.birthYear == human.birthYear;
    }
}
