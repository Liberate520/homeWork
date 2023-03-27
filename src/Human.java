import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private List<Human> children;
    private String gender;

    public Human(String name, String gender) {
        this.name=name;
        this.gender=gender;
        this.children = new ArrayList<>();
    }

    public void addchildren(Human ch) {
        children.add(ch); 
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public List<Human> getChildren() {
        return children;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str.append(this.name+": ");
         if(!this.mother.getName().equals(""))
            str.append("-> мать "+this.mother.getName());
        if(!this.father.getName().equals(""))
            str.append("-> отец "+this.father.getName());
        if(this.children.size()!=0){
            for (Human item : this.children) {
                if(item.getGender().equals("ж"))
                    str.append("-> дочь ");
                if(item.getGender().equals("м"))
                    str.append("-> сын ");
                str.append(item.getName());
            }
        }
        return str.toString();
    } 
}
