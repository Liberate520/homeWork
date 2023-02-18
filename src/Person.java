import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private String name;
    private Gender gender;
    private String years_government;
    private Person father;
    private Person mother;
    private String spouse;

    private List<Person> children;


    public Person(String name, Gender gender, String years_government, Person father, Person mother, String spouse) {

        this.name = name;
        this.gender = gender;
        this.years_government = years_government;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
        this.children = new ArrayList<>();

    }



    public String getName() {
        return name;
    }


    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }


    public boolean addChild(Person child) {
        if (!children.contains(child)){
            this.children.add(child);
            return true;
        }
        return false;
    }
    private String getYearsInfo() {
        String res = "Годы правления: ";
        if (years_government != null) {
            res += years_government;
        }else{
            res += "не правил(а)";
        }
        return res;
    }
    private String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getName();
        }else{
            res += "неизвестен";
        }
        return res;
    }
    private String getMotherInfo() {
        String res = "мать: ";
        if (mother != null) {
            res += mother.getName();
        }else{
            res += "неизвестна";
        }
        return res;
    }
    private String getSpouseInfo() {
        String res = "Супруг(а): ";
        if (spouse != null) {
            res += spouse;
        }else{
            res += "нет";
        }
        return res;
    }
    private  String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() !=0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("нет");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(", ");
        sb.append(getYearsInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }
}