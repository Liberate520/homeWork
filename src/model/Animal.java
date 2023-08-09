package src.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable {
    private String name;
    private Animal parentMom, parentDad; // родители
    private List <Animal> chidrens;  // List --> Set for unigue
    private int childId;
    private LocalDate birthDay, deathDay; // день рождения, дата смерти
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
    private Gender gender; // пол
    
    public Animal(String aName, Gender aGender, LocalDate aBirthDay) {
        this.name = aName;
        this.gender = aGender;
        this.birthDay = aBirthDay;
        
        chidrens = new ArrayList<Animal>();
    }  // constructor Animal

    public Gender getGender(){      return gender;    }

//    Animal parentsMom, parentsDad; // родители
    public void setparentMom(Animal anm){
        parentMom = anm;
    }

    public Animal getparentMom(){
        return parentMom;
    }

    public void setparentDad(Animal anm){
        parentDad = anm;
    }

    public Animal getparentDad(){
        return parentDad;
    }


    public Animal setParent(Animal aNM) {
        if (aNM.gender.equals(Gender.Man)){
            if (this.parentDad == null){
                this.parentDad = aNM;
            }
            return this.parentDad;
        } else {
            if (this.parentMom == null){
                this.parentMom = aNM;
            }
            return this.parentMom;
        }
    }
    
    public Animal getParentDad(){
        return this.parentDad;
    }
    
    public Animal getParentMom(){
        return this.parentMom;
    }
    
    
    public List <Animal> getGrandParents(){  //  дедушек и бабушек  ...  grandparents.
        List <Animal> fGPr = new ArrayList<Animal>();
        Animal fHmn ;
        fHmn = this.getParentDad();
        if (fHmn != null){
            fGPr.add(fHmn.getParentDad());      fGPr.add(fHmn.getParentMom()); 
        }
        
        fHmn = this.getParentMom();
        if (fHmn != null){
            fGPr.add(fHmn.getParentDad());      fGPr.add(fHmn.getParentMom()); 
        }
        return fGPr;
    }
    
    public String getGrandParentsStr(){  //  дедушек и бабушек  ...  grandparents.
        List <Animal> fGPr = getGrandParents();
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.toString());
        stringBuilder.append("\n дедушки и бабушки :\n");
        
        for (Animal h: fGPr){
            if (h != null) { stringBuilder.append(h); stringBuilder.append("\n"); }
        }
        return stringBuilder.toString();
    }

    public String getParentsStr(){  //  Родители  ...  parents.
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.toString());
        stringBuilder.append("\n Родители :\n");

//        parentMom, parentDad; // родители
        if (parentDad != null) { stringBuilder.append(parentDad); stringBuilder.append("\n");}
        if (parentMom != null) { stringBuilder.append(parentMom); stringBuilder.append("\n");}
        return stringBuilder.toString();
    }
    
    
    public List <Animal> getBrotherSister(){  // братьев и сестер  ...  brothers and sisters
        List <Animal> fBrSs = new ArrayList<Animal>();
        Animal fHmn;
        fHmn = this.getParentDad();
        if (fHmn != null){  fBrSs.addAll(fHmn.chidrens);  }

        fHmn = this.getParentMom(); 
        if (fHmn != null){  fBrSs.addAll(fHmn.chidrens);  }
        
        return fBrSs;
    }
    
    
    public String getBrotherSisterStr(){  // братьев и сестер  ...  brothers and sisters
        List <Animal> fBrSs = getBrotherSister();
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.toString());
        stringBuilder.append("\n братья сестры :\n");
        
        for (Animal h: fBrSs){
            if (h != null) { stringBuilder.append(h); stringBuilder.append("\n"); }
        }
        return stringBuilder.toString();
    }
    
    
    public List <Animal> addChild(Animal aChild){
        if(!chidrens.contains(aChild)){  // only unigue childs !!!
            childId++;
            aChild.setParent(this);
            chidrens.add(aChild);
        }
        return chidrens;
    }
    
    public String getChilds(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.toString());
        stringBuilder.append("\n Дети :\n");
        
        for (Animal h: chidrens){
            stringBuilder.append(h);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getName(){
        return name;
    }

    public String getBirthDay(){
        return birthDay.toString();
    }

    public LocalDate getBirthDayO(){  // LocalDate fbirthDay
        return birthDay;
    }


    @Override
    public String toString() {
        return "имя : " + name + ",\t д.р. : " + birthDay + ",\t пол : " + gender;
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this == obj){return true;}
    	if (!(obj instanceof Human)){return false;}
        Animal ahM = (Animal) obj;
    	return (name.equals(ahM.name) && // имя
    		birthDay.toString().equals(ahM.birthDay.toString()) &&  // день рождения  LocalDate.of(...).toString().equals()
    		gender == ahM.gender);  // пол
    }

    @Override
    public int hashCode(){
    	return name.hashCode()
    		+ 3 * birthDay.hashCode()
    		+ 5 * gender.hashCode();
    }
    
    /*************
     * private String fName;    
     * private Human fParentsMom, fParentsDad; // родители
     * private List <Human> fChidrens;
     * private int fChildId;
     * private LocalDate fbirthDay, fdeathDay; // день рождения, дата смерти
     * private Gender fGender; // пол
     * 
     * 1 3 5 7 11 13 17 19 
    *************/
    
}