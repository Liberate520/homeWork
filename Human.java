import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.io.*; // Serializable

public class Human implements Serializable {
    private String name;
    private Human parentsMom, parentsDad; // родители
    private List <Human> chidrens;  // List --> Set for unigue
    private int childId;
    private LocalDate birthDay, deathDay; // день рождения, дата смерти
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
    private Gender gender; // пол
    
    public Human(String aName, Gender aGender, LocalDate aBirthDay) {
        this.name = aName;
        this.gender = aGender;
        this.birthDay = aBirthDay;
        
        chidrens = new ArrayList<Human>();
    }  // constructor Human
    
    public Human setParent(Human aHuman) {
        if (aHuman.gender.equals(Gender.Man)){
            if (this.parentsDad == null){
                this.parentsDad = aHuman;
            }
            return this.parentsDad;
        } else {
            if (this.parentsMom == null){
                this.parentsMom = aHuman;
            }
            return this.parentsMom;
        }
    }
    
    public Human getParentDad(){
        return this.parentsDad;
    }
    
    public Human getParentMom(){
        return this.parentsMom;
    }
    
    
    public List <Human> getGrandParents(){  //  дедушек и бабушек  ...  grandparents.
        List <Human> fGPr = new ArrayList<Human>();
        Human fHmn ;
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
        List <Human> fGPr = getGrandParents();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.toString());
        stringBuilder.append("\n дедушки и бабушки :\n");
        
        for (Human h: fGPr){
            if (h != null) { stringBuilder.append(h); stringBuilder.append("\n"); }
        }
        return stringBuilder.toString();
    }
    
    
    public List <Human> getBrotherSister(){  // братьев и сестер  ...  brothers and sisters
        List <Human> fBrSs = new ArrayList<Human>();
        Human fHmn;
        fHmn = this.getParentDad();
        if (fHmn != null){  fBrSs.addAll(fHmn.chidrens);  }

        fHmn = this.getParentMom(); 
        if (fHmn != null){  fBrSs.addAll(fHmn.chidrens);  }
        
        return fBrSs;
    }
    
    
    public String getBrotherSisterStr(){  // братьев и сестер  ...  brothers and sisters
        List <Human> fBrSs = getBrotherSister();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.toString());
        stringBuilder.append("\n братья сестры :\n");
        
        for (Human h: fBrSs){
            if (h != null) { stringBuilder.append(h); stringBuilder.append("\n"); }
        }
        return stringBuilder.toString();
    }
    
    
    public List <Human> addChild(Human aChild){
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
        
        for (Human h: chidrens){
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

    public LocalDate getBirthDayO(){  // LocalDate birthDay
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
    	Human ahM = (Human) obj;
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
     * private Human parentsMom, parentsDad; // родители
     * private List <Human> chidrens;
     * private int childId;
     * private LocalDate birthDay, deathDay; // день рождения, дата смерти
     * private Gender gender; // пол
     * 
     * 1 3 5 7 11 13 17 19 
    *************/
    
}