import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        if (father != null)
            father.children.add(this);
        if (mother != null)
            mother.children.add(this);
    }

    public Human(String name, String gender) {
        this(name, gender, null, null);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        String s = "Имя: " + name + ", пол: " + gender;

        if (father != null)
            s += "; отец: " + father.name;

        if (mother != null)
            s += "; мать: " + mother.name;

        if (children.size() > 0) {
            s += "; дети: ";
            for (int i = 0; i < children.size(); i++)
                s += (i < children.size() - 1 ? children.get(i).name + ", " : children.get(i).name);
        }

        List<Human>  brothersSistersList = getBrothersSisters();
        if (brothersSistersList.size() > 0) {
            s += "; ";
            for (int i = 0; i < brothersSistersList.size(); i++) {
                if (brothersSistersList.get(i).gender.equals("мужской"))
                    s += "брат: " + brothersSistersList.get(i).name;
                else
                    s += "сестра: " + brothersSistersList.get(i).name;
                s += (i < brothersSistersList.size() - 1 ? ", " : "");
            }
        }
        return s;
    }

    public List<Human> getBrothersSisters() {
        List<Human> brothersSistersList;

        if (father != null && mother == null)
            brothersSistersList = new ArrayList(father.children);
        else if (father == null && mother != null)
            brothersSistersList = new ArrayList(mother.children);
        else if (father != null && mother != null) {
            brothersSistersList = new ArrayList(father.children);
            List<Human> motherChildren = new ArrayList(mother.children);
            brothersSistersList.removeAll(motherChildren);
            brothersSistersList.addAll(motherChildren);
        }
        else
            brothersSistersList = new ArrayList();

        brothersSistersList.remove(this);
        return brothersSistersList;
    }
}
