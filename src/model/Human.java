package src.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Human extends Animal implements Serializable {

//    private DateTimeFormatter formatterDt;
    public Human(String aName, Gender aGender, LocalDate aBirthDay) {
        super( aName,  aGender,  aBirthDay);
        DateTimeFormatter formatterDt;
        formatterDt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }  // constructor Human

    public void HumanStr(String aName, String aGenderStr, String aBirthDay) {


//        this().Human(aName, aGender, lt);
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