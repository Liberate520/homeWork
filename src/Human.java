import java.util.ArrayList;
import java.util.List;

public class Human {
    public Gender gender;
    public String firstName;
    public String lastName;
    public List<Human> parents;
    public List<Human> childs;

    public Human(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.childs = new ArrayList<>();
    }

    public String getParents() {
        StringBuilder sb = new StringBuilder();
        for (Human human : parents) {
            sb.append(human);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String getChilds() {
        StringBuilder sb = new StringBuilder();
        for (Human human : childs) {
            sb.append(human);
            sb.append(" ");
        }
        return sb.toString();
    }

    public void setParents(Human par) {
        if (parents.isEmpty() || parents.size() == 1){
            this.parents.add(par);
        }
    }

    public void setChilds(Human ch) {
        this.childs.add(ch);
    }

    public String getNamePerson() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString() {
        if (!parents.isEmpty() && !childs.isEmpty()) {
            return String.format("%s %s %s |Parent: %s |Child: %s", firstName, lastName, gender, getParents(),
                    getChilds());
        } else if (!parents.isEmpty()) {
            return String.format("%s %s %s|Parent: %s", firstName, lastName, gender, getParents());
        }else if (!childs.isEmpty()) {
            return String.format("%s %s %s|Child: %s", firstName, lastName, gender, getChilds());
        }
        return String.format("%s %s %s", firstName, lastName, gender);
    }

}