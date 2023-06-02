import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/** human */
public class Human implements Serializable{
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    /** return human name */
    public String getName() {
        return this.name;
    }

    /** return human year birth */
    public LocalDate getBirthday() {
        return this.birthday;
    }

    /** return human gender */
    public Gender getGender() {
        return gender;
    }

    public Human(String name, LocalDate birthday, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        children = new ArrayList<>();
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, LocalDate birthday, Gender gender) {
        this(name, birthday, gender, null, null);
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
    public Human getMother() {
        return mother;
    }

    /** returned father */
    public Human getFather() {
        return father;
    }

    /** set father */
    public void setFather(Human father) {
        this.father = father;
    }

    /** set mother */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /** added child in children list */
    public Boolean addChild(Human child) {

        if(!ContainsChild(child)){
            children.add(child);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(name + " ");
        builder.append("(" + formatter.format(birthday) + ") ");
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
