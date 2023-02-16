import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String sex;
    private String name_father;
    private String name_mother;
    private List<Human> children;
    
    public Human(String name, String sex, String name_father, String name_mother) {
        this.name = name;
        this.sex = sex;
        this.name_father = name_father;
        this.name_mother = name_mother;
        this.children = new ArrayList<>();
    }

    // public Human(String name, String sex, String parent) {
    //     this.name = name;
    //     this.sex = sex;
    //     this.name_father = name_father;
    //     this.name_mother = name_mother;
    // }

    public Human(String name, String sex){
        this(name, sex, "Unkown", "Unkown");
    }

    public String getName() {
        return name;
    }

    public String getFather() {
        return name_father;
    }
    public String getMother() {
        return name_mother;
    }
    public List<Human> getChildren() {
        return children;
    }
    
    private void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        List<Human> children = new ArrayList<>();
        children = getChildren();
        children.add(child);
        setChildren(children); 
    }

    private String getChildrenName(List<Human> children) {
        String [] name_children = new String[children.size()];
        for (int i = 0; i < children.size(); i++) {
            name_children[i] = children.get(i).toString().split(",")[0].split(" = ")[1];
        }
        if (name_children.length < 1) return "Unkown";
        return String.join(", ", name_children);
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Sex = " + sex + ", Father = "
                + name_father + ", Mother = " + name_mother + ", Children = " + getChildrenName(children);
    }
}