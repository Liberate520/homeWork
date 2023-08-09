package familytree.model.human;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import familytree.model.family_tree.FamilyTreeItem;

/**
 * Human
 * 
 * 
 * 
 */



public class Human implements FamilyTreeItem<Human>  {
    private String name;
    private Gender gender;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human spouse;
    private List <Human> children;
    private List <Human> parents;

    public Human(String name, String surname, Gender gender,  LocalDate dateOfBirth, LocalDate dateOfDeath, Human spouse,  Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if(father!=null){
            parents.add(father);
            
        }

        if(mother!=null){
            parents.add(mother);           
        }

        this.spouse = spouse;
        children = new ArrayList<>();

    }



    public Human(String name, String surname, Gender gender,   LocalDate dateOfBirth, Human spouse) {
        this(name, surname, gender, dateOfBirth,null,spouse,null,null);
    }

    

    public Human(String name, String surname, Gender gender,  LocalDate dateOfBirth,Human father,Human mother) {
      this(name, surname, gender, dateOfBirth,null,null,father, mother);

    }
   

    public Human(String name, String surname, Gender gender,  LocalDate dateOfBirth) {
      this(name, surname, gender, dateOfBirth,null,null,null,null);

    }

    public Human(String name, String surname, Gender gender,  LocalDate dateOfBirth, LocalDate dateOfDate) {
      this(name, surname, gender, dateOfBirth,dateOfDate,null,null,null);

    }

    public Human(){

    }
   

    public int  getAge( ){
        if (dateOfDeath == null) {
            return LocalDate.now().getYear() - dateOfBirth.getYear();
        }
        if (dateOfBirth == null) {
            return 0;}
        return -1;
    }



    public String getName() {
        return name;
    }

    public List<Human> getParents() {
        return parents;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }


    public Human getFather() {
        for (Human parent : parents) {
            if(parent.gender == Gender.M){
                return parent;
            }
            
        }
        return null;
    }


    public Human getMother() {
        
        for (Human parent : parents) {
            if(parent.gender == Gender.F){
                return parent;
            }
        }
        return null;
                
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }


    public Human getSpouse() {
        if(this.spouse == null){
            return null;
        }
        else{
        return spouse;
        }
        
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }


    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    // public void setSpouse(Human human){


    // }

    public void addSpouse(Human human) {
        this.spouse = human;
    }

    public void addParent(Human human) {
        
        if (!parents.contains(human)){
            parents.add(human);
        }
    }

    @Override
    public String toString(){

        return getInfo();
    }


    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append(name + " "+  surname +" | " +  getInfoMother() + " | " + getInfoFather() + " | "+ getInfoChildren() + " | " + getInfoSpouse());

        return info.toString();
    }

    public String getInfoMother(){
        StringBuilder info = new StringBuilder("мать: ");
        Human mother = getMother();
        if (mother!=null){
            info.append(mother.getName() +" " + mother.getSurname());
        }
        else{
            info.append("неизестна");
        }


        return info.toString();
    }

    public String getInfoFather(){
        StringBuilder info = new StringBuilder("отец: ");
        Human father = getFather();
        if (father!=null){
            info.append(father.getName() +" " + father.getSurname());
        }
        else{
            info.append("неизестен");
        }


        return info.toString();
    }

    public String getInfoChildren(){
        StringBuilder info = new StringBuilder();
        if(children.size()!= 0){
            info.append("дети: ");
            for (Human child: children) {
                info.append(child + "  ");
                
            }
        }
        else{
            info.append("нет детей");


        }
        return info.toString();
    }

    public String getInfoSpouse(){
        StringBuilder info = new StringBuilder();
        Human spouse = getSpouse();
        if(spouse != null){
            info.append(getName() + " " + getSurname() + " в браке с " + spouse.getName() +" " + spouse.getSurname());
        }
        else{
            info.append("не в браке");


        }
        return info.toString();
    }


  
        


}





    
