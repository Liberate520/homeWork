package FamilyTree.Tree.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private List<Human> children = new ArrayList<>();


    private String name;
    private String patronymic;
    private String dateOfBirth;
    private Gender gender;
    private List<Human> parents;



    public Human(String name, String patronymic, Gender gender, String dateOfBirth, Human father, Human mother) {

        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
    }


    public boolean addParent(Human parent) {
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }
    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public List<Human> getChildren(){
        return children;
    }
    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public List<Human> getParents() {
        return parents;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = String.valueOf(dateOfBirth);
    }
    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(": ");
        sb.append(patronymic);
        sb.append(", : ");
        sb.append(getDateOfBirth());
        sb.append(", : ");
        sb.append(gender);
        sb.append(" Отец: ");
        sb.append(getFather());
        sb.append(" Мать: ");
        sb.append(getMother());
        sb.append(" Дети: ");
        sb.append(getChildren());
        return sb.toString();
    }

}
