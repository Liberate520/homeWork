import java.util.ArrayList;
import java.util.List;

/** human */
public class Human {
    private String name;
    private int yearBirth;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    /** return human name */
    public String getName() {
        return this.name;
    }

    /** return human year birth */
    public int getYearBirth() {
        return this.yearBirth;
    }

    /** return human gender */
    public Gender getGender() {
        return gender;
    }


    public Human(String name, int yearBirth, Gender gender, Human mother, Human father) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.gender = gender;
        children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        if(mother != null){
            mother.children.add(this);
        }
        if(father != null){
            father.children.add(this);
        }
    }


    public Human(String name, int yearBirth, Gender gender) {
        this(name, yearBirth, gender, null, null);
    }

    /** checked contains child in children list */
    public Boolean ContainsChild(Human child){
        for (Human human : children) {
            if(human.equals(child)){
                return true;
            }
        }
        return false;
    }

    /** returned mother */
    public Human getMother(int number) {
        return mother;
    }

    /** returned father */
    public Human getFather(int number) {
        return father;
    }

    /** added child in children list */
    public Boolean addChild(Human child) {

        if(!ContainsChild(child)){
            children.add(child);
            if(gender == Gender.male){
                child.father = this;
            }
            if(gender == Gender.female){
                child.mother = this;
            }
            return true;
        }
        return false;
    }

    /** returned string representation of children list */
    public String getStringPresentationChildren() {
        StringBuilder builder = new StringBuilder();
        for (Human child : children) {
            builder.append(child);
            builder.append("\n");
        }
        return builder.toString();
    }

    /** representation */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + " ");
        builder.append("(" + yearBirth + ") ");
        builder.append("[" + gender + "] ");
        builder.append(children.size() + " children, ");
        if(father != null){
            builder.append(" father: " + father.name + " ");
        }
        if(mother != null){
            builder.append(" mother: " + mother.name + " ");
        }
        return builder.toString();
    }
}
