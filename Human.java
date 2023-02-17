
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private String surname;
    private String name;
    private String patronymic;
    private GenderType sex;
    private Human father;
    private Human mother;
    private List<Human> children;

public Human (String name, String surname, String patronymic, GenderType sex){
    this(name, surname, patronymic, sex, null, null);
}

public Human(String name, String surname, String patronymic, GenderType sex, Human father, Human mother )
{
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.sex = sex;
    this.father = father;
    this.mother = mother;
    children = new ArrayList<>();
}

public boolean addChild(Human child){
    if(!children.contains(child)){
        children.add(child);
        return true;
    }
    return false;
}

public String getName() {
    return name;
}

public String getSurname() {
    return surname;
}

public GenderType getSex() {
    return sex;
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
public void setFather(Human father){this.father = father;}
public void setMother(Human mother){this.mother = mother;}


public String getInfo(){
    StringBuilder sb = new StringBuilder();
    sb.append("имя: ");
    sb.append(name);
    sb.append(", ");
    sb.append("фамилия: ");
    sb.append(surname);
    sb.append(", ");
    sb.append("отчество: ");
    sb.append(patronymic);
    sb.append(", ");
    sb.append(getMotherInfo());
    sb.append(", ");
    sb.append(getFatherInfo());
    sb.append(", ");
    sb.append(getChildrenInfo());
    return sb.toString();
}

private String getMotherInfo(){
    String res = "мать: ";
    if (mother != null){
        res += mother.getName();
    } else {
        res += "неизвестна";
    }
    return res;
}

private String getFatherInfo(){
    String res = "отец: ";
    if (father != null){
        res +=father.getName();
    } else {
        res += "неизвестен";
    }
    return res;
}

private String getChildrenInfo(){
    StringBuilder res = new StringBuilder();
    res.append("дети: ");
    if (children.size() != 0){
        res.append(children.get(0).getName());
        for (int i = 1; i < children.size(); i++){
            res.append(", ");
            res.append(children.get(i).getName());
        }
} else {
    res.append("отсутствуют");
}
return res.toString();
}

@Override
public boolean equals(Object obj){
    if (this == obj){
        return true;
   }
   if (!(obj instanceof Human)){
    return false;
   }
   Human human = (Human) obj;
   return human.getName().equals(getName());
}
}