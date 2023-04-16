package human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private Calendar birthDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender, Calendar birthDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender, Calendar birthDate) {
        this(name , gender, birthDate,null, null);
    }

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean addChild(Human child){

        if (child != null && !children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public String getName() {return name;}
    public Calendar getBirthDate() {return birthDate;}
    public int getAge(){Calendar currentDate = new GregorianCalendar();
        return currentDate.get(Calendar.YEAR) - this.getBirthDate().get(Calendar.YEAR);
    }
    //public Calendar getbirthDate(){return birthDate;}
    public Human getFather() {return father;}
    public Human getMother() {return mother;}
    public Gender getGender() {return gender;}
    public List<Human> getChildren() {return children;}
    //public void setBirthDate(Calendar birthDate) {this.birthDate = birthDate;}
    public void setFather(Human father) {this.father = father;}
    public void setMother(Human mother) {this.mother = mother;}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("дата рождения: ");
        //sb.append(setBirthDate()+" 555 ");
        sb.append(birthDate.get(Calendar.DAY_OF_MONTH)+".");
        sb.append(birthDate.get(Calendar.MONTH)+".");
        sb.append(birthDate.get(Calendar.YEAR));
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }


    public String getMotherInfo(){
        String res = "мать: ";
        if(mother != null){
            res +=mother.getName();
        }else{
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null) {
            res+=father.getName();
        }else {
            res+="неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for(int i = 0; i< children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + Calendar.DAY_OF_MONTH + "541254125"+Calendar.MONTH+Calendar.YEAR+
                ", father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                '}';
    }
}
