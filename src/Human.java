import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, HumanInterface {
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
        if (parents.isEmpty() || parents.size() == 1) {
            switch (par.gender) {
                case Female:
                    setMother(par);
                    break;
                case Male:
                    setFather(par);
                    break;
            }

        }
    }

    public void setChilds(Human ch) {
        switch (ch.gender) {
            case Female:
                // setSon(ch); // происходит вылет
                break;
            case Male:
                // setDaughter(ch); // происходит вылет
                break;
        }

    }

    public String getNamePerson() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getInfoPerson() {
        return String.format("%s %s %s", firstName, lastName, gender);
    }

    public String getInfoParents() {
        return String.format("%s %s |Parent: %s", firstName, lastName, getParents());
    }

    public String getInfoChilds() {
        return String.format("%s %s |Child: %s", firstName, lastName, getChilds());
    }

    public String getInfoBoth() {
        return String.format("%s %s |Parent: %s |Child: %s", firstName, lastName, getParents(),
                getChilds());
    }

    @Override
    public void setMother(Human par) {
        boolean part = true;
        for (Human human : parents) {
            if (human.gender == Gender.Female) {
                part = false;
                System.out.println(String.format("%s %s уже имеет мать %s", firstName, lastName, human));
                break;
            }
        }
        if (part)
            this.parents.add(par);
    }

    @Override
    public void setFather(Human par) {
        boolean part = true;
        for (Human human : parents) {
            if (human.gender == Gender.Male) {
                part = false;
                System.out.println(String.format("%s %s уже имеет отца %s", firstName, lastName, human));
                break;
            }
        }
        if (part)
            this.parents.add(par);
            
    }

    @Override
    public void setSon(Human per) {
        this.childs.add(per);
        per.setParents(this);
    }

    @Override
    public void setDaughter(Human per) {
        this.childs.add(per);
        per.setParents(this);
    }

    @Override
    public String toString() {
        if (!parents.isEmpty() && !childs.isEmpty()) {
            return getInfoBoth();
        } else if (!parents.isEmpty()) {
            return getInfoParents();
        } else if (!childs.isEmpty()) {
            return getInfoChilds();
        }
        return getNamePerson();
    }

}