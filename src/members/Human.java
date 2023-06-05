package members;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/** human */
public class Human implements Serializable, Member{
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private Member mother;
    private Member father;
    private List<Member> children;

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

    /** количество детей */
    public int getChildrenAmount(){
        return children.size();
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
    public Boolean ContainsChild(Member child){
        for (Member member : children) {
            if(member.equals(child)){
                return true;
            }
        }
        return false;
    }

    /** returned mother */
    public Member getMother() {
        return mother;
    }

    /** returned father */
    public Member getFather() {
        return father;
    }

    /** added child in children list */
    public Boolean addChild(Member child) {

        if(!ContainsChild(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    /** representation */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(name + " ");
        builder.append("(" + formatter.format(birthday) + ")\n");
        builder.append("[" + gender + "] ");
        builder.append(children.size() + " children,\n");
        if(father != null){
            builder.append("father: " + father.getName() + "\n");
        }
        if(mother != null){
            builder.append("mother: " + mother.getName()  + "\n");
        }
        return builder.toString();
    }
}
