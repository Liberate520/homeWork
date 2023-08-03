import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.io.*; // Serializable

public class Human extends Animal implements Serializable {
//    private String name;
//    private Human parentsMom, parentsDad; // родители
//    private List <Human> chidrens;  // List --> Set for unigue
//    private int childId;
//    private LocalDate birthDay, deathDay; // день рождения, дата смерти
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
//    private Gender gender; // пол
    
    public Human(String aName, Gender aGender, LocalDate aBirthDay) {
        super( aName,  aGender,  aBirthDay);
//        this.name = aName;
//        this.gender = aGender;
//        this.birthDay = aBirthDay;
//        super.chidrens = new ArrayList<Human>();
    }  // constructor Human
    
    public Human setParent(Human aHuman) {
        if (aHuman.getGender().equals(Gender.Man)){
            if (getparentDad() == null){
                setparentDad(aHuman);
            }
            return (Human) getparentDad();
        } else {
            if (getparentMom() == null){
                setparentMom(aHuman);
            }
            return  (Human) getparentMom();
        }
    }
    
    public Human getParentDad(){
        return (Human) getparentDad();
    }
    
    public Human getParentMom(){  return  (Human) getparentMom(); }
    
//    public List <Human> getGrandParents(){  //  дедушек и бабушек  ...  grandparents.
//        List <Human> fGPr = new ArrayList<Human>();
//        Human fHmn ;
//        fHmn = this.getParentDad();
//        if (fHmn != null){
//            fGPr.add(fHmn.getParentDad());      fGPr.add(fHmn.getParentMom());
//        }
//
//        fHmn = this.getParentMom();
//        if (fHmn != null){
//            fGPr.add(fHmn.getParentDad());      fGPr.add(fHmn.getParentMom());
//        }
//        return fGPr;
//    }
    
//    public String getGrandParentsStr(){  //  дедушек и бабушек  ...  grandparents.
//        List <Human> fGPr = getGrandParents();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.toString());
//        stringBuilder.append("\n дедушки и бабушки :\n");
//
//        for (Human h: fGPr){
//            if (h != null) { stringBuilder.append(h); stringBuilder.append("\n"); }
//        }
//        return stringBuilder.toString();
//    }
    
    
//    public List <Human> getBrotherSister(){  // братьев и сестер  ...  brothers and sisters
//        List <Human> fBrSs = new ArrayList<Human>();
//        Human fHmn;
//        fHmn = this.getParentDad();
//        if (fHmn != null){  fBrSs.addAll(fHmn.chidrens);  }
//
//        fHmn = this.getParentMom();
//        if (fHmn != null){  fBrSs.addAll(fHmn.chidrens);  }
//
//        return fBrSs;
//    }
    
    
//    public String getBrotherSisterStr(){  // братьев и сестер  ...  brothers and sisters
//        List <Human> fBrSs = getBrotherSister();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.toString());
//        stringBuilder.append("\n братья сестры :\n");
//
//        for (Human h: fBrSs){
//            if (h != null) { stringBuilder.append(h); stringBuilder.append("\n"); }
//        }
//        return stringBuilder.toString();
//    }
    
    
//    public List <Human> addChild(Human aChild){
//        if(!chidrens.contains(aChild)){  // only unigue childs !!!
//            childId++;
//            aChild.setParent(this);
//            chidrens.add(aChild);
//        }
//        return chidrens;
//    }
    
//    public String getChilds(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.toString());
//        stringBuilder.append("\n Дети :\n");
//
//        for (Human h: chidrens){
//            stringBuilder.append(h);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }

//    public String getName(){
//        return name;
//    }

//    public String getBirthDay(){
//        return birthDay.toString();
//    }
//
//    public LocalDate getBirthDayO(){  // LocalDate birthDay
//        return birthDay;
//    }


    @Override
    public String toString() {
        return "имя : " + getName() + ",\t д.р. : " + getBirthDay() + ",\t пол : " + getGender();
    }
    
    @Override
    public boolean equals(Object obj){
    	if (this == obj){return true;}
    	if (!(obj instanceof Human)){return false;}
    	Human ahM = (Human) obj;
    	return (getName().equals(ahM.getName()) && // имя
                getBirthDay().toString().equals(ahM.getBirthDay().toString()) &&  // день рождения  LocalDate.of(...).toString().equals()
                getGender() == ahM.getGender());  // пол
    }

    @Override
    public int hashCode(){
    	return getName().hashCode()
    		+ 3 * getBirthDay().hashCode()
    		+ 5 * getGender().hashCode();
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