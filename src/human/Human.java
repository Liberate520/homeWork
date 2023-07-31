package human;

import family_tree.FamilyTreeElement;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, FamilyTreeElement<Human> {
    private String name;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human spouse;
    private List<Human> children = new ArrayList<>();
    private List<Human> parents = new ArrayList<>();


    public Human(String name, LocalDate birthDay, LocalDate deathDay){
        this.name = name;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.spouse = null;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDay){
        this(name, birthDay, null);
    }

    @Override
    public void addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void marry(Human partner){
        if(this.spouse == null || partner.spouse == null) {
            this.spouse = partner;
            partner.spouse = this;
        }
    }

    @Override
    public void addParent(Human parent) {
        if(!parents.contains(parent)){
            parents.add(parent);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" {");
        sb.append(this.outputData());
        sb.append(this.outputSpouse());
        sb.append(this.outputParents());
        sb.append(this.outputChildren());
        sb.append("}");
        return sb.toString();
    }

    private String outputData() {
        StringBuilder sb = new StringBuilder();
        if(deathDay == null){
            sb.append("Дата рождения: ");
            sb.append(birthDay);
        }
        else {
            sb.append("Дата жизни: ");
            sb.append(birthDay);
            sb.append(" - ");
            sb.append(deathDay);
        }
        return sb.toString();
    }

    private String outputSpouse() {
        StringBuilder sb = new StringBuilder();
        if(spouse != null){
            sb.append("; ");
            sb.append("Супруг(а): ");
            sb.append(spouse.name);
        }
        return sb.toString();
    }

    private String outputParents() {
        StringBuilder sb = new StringBuilder();
        if(!parents.isEmpty()) {
            sb.append("; ");
            sb.append("Родители: ");
            for(int i=0; i<parents.size();){
                sb.append(parents.get(i).name);
                if(++i<parents.size()){
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    private String outputChildren() {
        StringBuilder sb = new StringBuilder();
        if(!children.isEmpty()) {
            sb.append("; ");
            sb.append("Дети: ");
            for(int i=0; i<children.size();){
                sb.append(children.get(i).name);
                if(++i<children.size()){
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public LocalDate getBirthDay(){
        return birthDay;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }


}
