import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.io.*; // Serializable

public class Human implements Serializable {
    private String fName;
    private Human fParentsMom, fParentsDad; // родители
    private List <Human> fChidrens;  // List --> Set for unigue
    private int fChildId;
    private LocalDate fbirthDay, fdeathDay; // день рождения, дата смерти
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
    private Gender fGender; // пол
    
    public Human(String aName, Gender aGender, LocalDate aBirthDay) {
        this.fName = aName;
        this.fGender = aGender;
        this.fbirthDay = aBirthDay;
        
        fChidrens = new ArrayList<Human>();
    }  // constructor Human
    
    public Human setParent(Human aHuman) {
        if (aHuman.fGender.equals(Gender.Man)){
            if (this.fParentsDad == null){
                this.fParentsDad = aHuman;
            }
            return this.fParentsDad;
        } else {
            if (this.fParentsMom == null){
                this.fParentsMom = aHuman;
            }
            return this.fParentsMom;
        }
    }
    
    public Human getParentDad(){
        return this.fParentsDad;
    }
    
    public Human getParentMom(){
        return this.fParentsMom;
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
        if (fHmn != null){  fBrSs.addAll(fHmn.fChidrens);  }

        fHmn = this.getParentMom(); 
        if (fHmn != null){  fBrSs.addAll(fHmn.fChidrens);  }
        
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
        if(!fChidrens.contains(aChild)){  // only unigue childs !!!
            fChildId++;
            aChild.setParent(this);
            fChidrens.add(aChild);
        }
        return fChidrens;
    }
    
    public String getChilds(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.toString());
        stringBuilder.append("\n Дети :\n");
        
        for (Human h: fChidrens){
            stringBuilder.append(h);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getName(){
        return fName;
    }

    public String getBirthDay(){
        return fbirthDay.toString();
    }

    public LocalDate getBirthDayO(){  // LocalDate fbirthDay
        return fbirthDay;
    }


    @Override
    public String toString() {
        return "имя : " + fName + ",\t д.р. : " + fbirthDay + ",\t пол : " + fGender;
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this == obj){return true;}
    	if (!(obj instanceof Human)){return false;}
    	Human ahM = (Human) obj;
    	return (fName.equals(ahM.fName) && // имя
    		fbirthDay.toString().equals(ahM.fbirthDay.toString()) &&  // день рождения  LocalDate.of(...).toString().equals()
    		fGender == ahM.fGender);  // пол
    }

    @Override
    public int hashCode(){
    	return fName.hashCode() 
    		+ 3 * fbirthDay.hashCode()
    		+ 5 * fGender.hashCode()
    		+ 7 * fbirthDay.hashCode();	
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