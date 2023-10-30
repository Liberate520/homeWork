package WorkSeminar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private long personID;
    private List<Persona> personaList;

    public long getPersonID() {
        return personID;
    }
    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }
    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Tree(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public boolean addPersona(Persona persona){
        if(persona == null) {
            return false;
        }
        if (!personaList.contains(persona)){
            personaList.add(persona);
            persona.setId(personID++);
            addToParents(persona);
            addToKids(persona);

            return true;
        }
        return false;
    }

    private  boolean checkID(long id){
        return  id < personID && id >= 0;
    }


    private void addToParents(Persona persona){
        for (Persona par : persona.addParents()){
            par.addKid(persona);
        }
    }
    private void addToKids(Persona persona) {
        for (Persona kid : persona.getKids()) {
            kid.addParent(persona);
        }
    }

    public  Persona addID (long id){
        if (!checkID(id)){
            return null;
        }
        for (Persona key : personaList){
            if(key.getId() == id){
                return key;
            }
        }
        return  null;
    }

    public List<Persona> getSisBroth(int id){
        Persona persona = addID(id);
        if (persona == null) {
            return null;
        }
        List<Persona> sisBrothList = new ArrayList<>();
        for (Persona partner : persona.addParents()){
            for (Persona kid : partner.getKids()){
                if (!kid.equals(persona) && !sisBrothList.contains(kid)){
                    sisBrothList.add(kid);
                }
            }
        }
        return sisBrothList;
    }

    public void printSisBroth(List<Persona> list){
        if(list.size() != 0){
            for (Persona persona : list) {
                System.out.println(persona);
            }
        }
    }

    public  List<Persona> getNamePersona(String name){
        List<Persona> NamePersonaList = new ArrayList<>();
        for (Persona persona : personaList){
            if (persona.getName().equals(name)) {
                NamePersonaList.add(persona);
            }
        }
        return NamePersonaList;
    }

    public boolean setWedding(Persona personaOne, Persona personaTwo){
        if(personaOne.getPartner() == null && personaTwo.getPartner() == null) {
            personaOne.setPartner(personaTwo);
            personaTwo.setPartner(personaOne);
            return true;
        } else {
            return false;
        }
    }

    public boolean setWedding(long personaOneId, long personaTwoId){
        if(checkID(personaOneId) && checkID(personaTwoId)) {
            Persona personaOne = addID(personaOneId);
            Persona personaTwo = addID(personaTwoId);
            return setWedding(personaOne, personaTwo);
        }
        return false;

    }

    public  String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В семейном древе Грэев ");
        info.append(personaList.size());
        info.append(" членов семьи: \n");
        for (Persona persona : personaList) {
            info.append(persona);
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public String toString() {return  getInfo();}



}
