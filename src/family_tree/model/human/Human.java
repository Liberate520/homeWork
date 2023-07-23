package family_tree.model.human;

import family_tree.model.Gender;
import family_tree.model.Reportable;
import family_tree.model.group.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;

public class Human implements ItemFamilyTree<Human>, Serializable {
    //модификатор доступа полей по умолчанию для InformerHuman:
    int id;
    String name;
    LocalDate dateBirth, dateDeath;
    Gender gender;
    Human mother, father;
    List<Human> children;
    Human spouse;
    private Reportable<Human> reportable;

    private static final int minParentAge = 17;

    public Human(int id, String name, LocalDate dateBirth, Gender gender, Reportable<Human> reportable) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;
        children = new ArrayList<>();
        this.reportable = reportable;
    }
    public int getId(){ return id; }
    public String getName(){ return name; }
    public LocalDate getDateBirth(){ return dateBirth; }
    public Gender getGender(){ return gender; }
    public Human getMother(){ return mother; }    
    public boolean setMother(Human mother){
        if (this.mother != null     //не разрешаем переприсваивать поле
                || mother.getGender() != Gender.Female
                || mother.getDateBirth().plusYears(minParentAge).compareTo(this.dateBirth) > 0) //ограничение возраста родителя
            return false;
        this.mother = mother;
        return true;
    }
    public Human getFather(){ return father; }
    public boolean setFather(Human father){
        if (this.father != null     //не разрешаем переприсваивать поле
                || father.getGender() != Gender.Male
                || father.getDateBirth().plusYears(minParentAge).compareTo(this.dateBirth) > 0) //ограничение возраста родителя
            return false;
        this.father = father;
        return true;
    }
    public List<Human> getChildren() { return children; }
    public boolean addChild(Human child){
        if(this.gender == Gender.Male) {
            if(!child.setFather(this)) return false;
        }else{
            if(!child.setMother(this)) return false;
        }
        children.add(child);
        return true;
    }
    public int getAge(){
        return Period.between(dateBirth, LocalDate.now()).getYears(); //из гугла
    }
    public Human getSpouse() {
        return spouse;
    }
    //public boolean isMarried(){ return spouse != null; }
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public String getInfo(){
        return reportable.getInfo(this);
    }
    @Override
    public String toString() {
        return getInfo();
    }
}
