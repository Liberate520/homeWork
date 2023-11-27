package WorkSeminar.model.Tree;

import WorkSeminar.model.Persona.Comporators.ComporatorSortAge;
import WorkSeminar.model.Persona.Comporators.ComporatorSortDEFAUT;
import WorkSeminar.model.Persona.Comporators.ComporatorSortGender;
import WorkSeminar.model.Persona.Comporators.ComporatorSortName;
import WorkSeminar.model.Persona.IteratorPerson;

import java.io.Serializable;
import java.util.*;

public class Tree<P extends TreeEtem<P>> implements Serializable, Iterable<P> {
    private long personID;
    private List<P> personaList;

    public long getPersonID() {
        return personID;
    }
    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public List<P> getPersonaList() {
        return personaList;
    }
    public void setPersonaList(List<P> personaList) {
        this.personaList = personaList;
    }

    public Tree(List<P> personaList) {
        this.personaList = personaList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public boolean addPersona(P persona){
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


    private void addToParents(P persona){
        for (P par : persona.addParents()){
            par.addKid(persona);
        }
    }
    private void addToKids(P persona) {
        for (P kid : persona.getKids()) {
            kid.addParent(persona);
        }
    }

    public P addID (long id){
        if (!checkID(id)){
            return null;
        }
        for (P key : personaList){
            if(key.getId() == id){
                return key;
            }
        }
        return  null;
    }

    public List<P> getSisBroth(int id){
        P persona = addID(id);
        if (persona == null) {
            return null;
        }
        List<P> sisBrothList = new ArrayList<>();
        for (P partner : persona.addParents()){
            for (P kid : partner.getKids()){
                if (!kid.equals(persona) && !sisBrothList.contains(kid)){
                    sisBrothList.add(kid);
                }
            }
        }
        return sisBrothList;
    }

    public void printSisBroth(List<P> list){
        if(list.size() != 0){
            for (P persona : list) {
                System.out.println(persona);
            }
        }
    }

    public List<P> getNamePersona(String name){
        List<P> NamePersonaList = new ArrayList<>();
        for (P persona : personaList){
            if (persona.getName().equals(name)) {
                NamePersonaList.add(persona);
            }
        }
        return NamePersonaList;
    }

    public boolean setWedding(P personaOne, P personaTwo){
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
            P personaOne = addID(personaOneId);
            P personaTwo = addID(personaTwoId);
            return setWedding(personaOne, personaTwo);
        }
        return false;

    }

    public  String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В семейном древе Грэев ");
        info.append(personaList.size());
        info.append(" членов семьи: \n");
        for (P persona : personaList) {
            info.append(persona);
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public String toString() {return  getInfo();}

    public void sortTreeByName(){
        Collections.sort(personaList, new ComporatorSortName<P>());
    }
    public void sortDefaut(){
        Collections.sort(personaList, new ComporatorSortDEFAUT<P>());
    }
    public void sortTreeByAge(){
        Collections.sort(personaList, new ComporatorSortAge<P>());
    }
    public void sortTreeByGender(){
        Collections.sort(personaList, new ComporatorSortGender<P>());
    }

    @Override
    public Iterator<P> iterator() {
        return new IteratorPerson<>(personaList);
    }
}
