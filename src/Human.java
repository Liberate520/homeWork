import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>{
    private String lastname;
    private String firstname;
    private String patronymic;
    private GenderType sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human (String name, String surname, String patronymic, GenderType sex){
        this(name, surname, patronymic, sex, null, null);
    }

    public Human(String firstname, String lastname, String patronymic, GenderType sex, Human father, Human mother )
    {
        this.lastname = lastname;
        this.firstname = firstname;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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
        sb.append(firstname);
        sb.append(", ");
        sb.append("фамилия: ");
        sb.append(lastname);
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
            res += mother.getFirstname();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    private String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res +=father.getFirstname();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    private String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getFirstname());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getFirstname());
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
        return human.getFirstname().equals(getFirstname());
    }

    @Override
    public int compareTo(Human o) {
        return firstname.compareTo(o.getFirstname());
    }





}