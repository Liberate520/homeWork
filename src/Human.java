import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable {
    private static int humanIdCounter = 0;
    private int id;
    private String name;
    private String gender;
    private Human father;
    private Human mother;
//    private String loner;
    private LocalDate dateOfBirth;
    private LocalDate deathDate;

    private List<Human> children;

    public Human(String name, String gender, LocalDate dateOfBirth, LocalDate deathDate) {
        this.id = humanIdCounter++;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.deathDate = null;
        this.children = new ArrayList<>();
    }

    public Human(String name, String gender, Human father, Human mother, LocalDate dateOfBirth, LocalDate deathDate) {
        this.id = humanIdCounter++;
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.dateOfBirth = dateOfBirth;
        this.deathDate = deathDate;
        children = new ArrayList<>();
    }

    public Human() {

    }



    public String getName() {
        return name;
    }

    public String getGender(){
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDeathDate() {
        return deathDate;
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

    public void setFather(Human father) {
        this.father = father;

    }

    public void setMother(Human mother){
        this.mother = mother;
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }

    public boolean addChild(Human child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }


    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("Дата рождения: ");
        sb.append(dateOfBirth);
        sb.append(", ");
        sb.append("Дата смерти: ");
        sb.append(deathDate);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();

    }

    public String getMotherInfo(){
        String res = "Мать: ";
        if(mother != null){
            res += mother.getName();
        }
        else{
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "Отец: ";
        if(father != null){
            res += father.getName();
        }
        else{
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size() ; i++) {
                res.append(" ,");
                res.append(children.get(i).getName());

            }

        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }



//    @Override
//    public boolean equals(Objects obj){
//        if (this == obj){
//            return true;
//        }
//        if(!(obj instanceof Human)){
//            return false;
//        }
//        Human human = (Human) obj;
//        return human.getName().equals(getName());
//    }
}