import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender){this(name, gender,  null,  null);}
    public Human(String name, Gender gender, Human father, Human mother){
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();

    }
    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
    public Human getFather(){
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }
    public void setFather(Human father){
        this.father = father;
    }
    public void setMother(Human mother){
        this.mother = mother;
    }

    public Gender getGender() {
        return gender;
    }


    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getCHildernInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        if(mother != null){
            res += mother.getName();
        }else{
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if(mother != null){
            res += father.getName();
        }else{
            res += "неизвестен";
        }
        return res;
    }
    public String getCHildernInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }

        }else{
            res.append("нет детей");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
        return true;
    }
        if (!(obj instanceof Human)){
        return false;
    }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
