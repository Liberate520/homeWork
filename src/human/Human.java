package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;


public class Human implements Serializable {

    private String name;
    private String lastName;
    Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;


    public Human(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(lastName, human.lastName) && Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, birthDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" ");
        sb.append(this.lastName);
        sb.append("\n");
        if (this.gender == Gender.male) {
            sb.append("male");
        } else {
            sb.append("female");
        }

        sb.append("\n");

        sb.append("Date of birth: ");
        sb.append(this.birthDate.format(DateTimeFormatter.ISO_DATE));
        sb.append("\n");
        if(checkDead(this)){
            sb.append("Date of death: ");
            sb.append(this.deathDate.format(DateTimeFormatter.ISO_DATE));
            sb.append("\n");
        }
        sb.append("Age: ");
        sb.append(showAge(this));
        sb.append("\n");
        if(this.spouse!=null){
            sb.append("Spouse: ");
            sb.append(this.spouse.name);
            sb.append(" ");
            sb.append(this.spouse.lastName);
            sb.append("\n");
        }
        if(!this.children.isEmpty()){
            sb.append("Children: ");
            for (Human human: this.children
            ) {
                sb.append(human.name);
                sb.append(" ");

            }
            sb.append("\n");
        }




        return sb.toString();
    }


    public String getLastName(Human human){
        return human.lastName;
    }

    public String getName(Human human){
        return human.name;
    }
    public void addChildren(Human child){
        if(!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public void addSpouse(Human human){
        this.spouse = human;
    }

    public void addMother(Human human){
        this.mother = human;
    }

    public void addFather(Human human){
        this.father = human;
    }



    public void getChildren(){
        if(!this.children.isEmpty()){
            for (Human human:this.children
            ) {
                System.out.println(human);
            }
        }else System.out.println("This person doesn't have any children!");
    }

    public boolean checkDead(Human human){
        return human.deathDate!= null;
    }

    public int showAge(Human human){
        if(!checkDead(human)){
            LocalDate today = LocalDate.now();
            Period intervalPeriod = Period.between(human.birthDate, today);
            return intervalPeriod.getYears();
        }else{
            Period intervalPeriod = Period.between(human.birthDate, human.deathDate);
            return intervalPeriod.getYears();
        }
    }


}



