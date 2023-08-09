package family_tree.backend.ftree;

import family_tree.backend.person.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<P extends Relatives<P>> implements Serializable, Iterable<P>, Childrens {
    
    private List<P> relations;

    public FamilyTree(List<P> relations){
        this.relations = relations;
    }

    public FamilyTree(){
        this(new ArrayList<P>());
    }

    public void addPerson(P person){
        relations.add(person);
    }
    public String getFullRelativesInfo(){
        StringBuilder sB = new StringBuilder();
        sB.append("\n============\n");
        sB.append("Full Family tree:\n");
        sB.append("============\n");
        for (P person: relations){
            sB.append(person.getID());
            sB.append(". ");
            sB.append(person.getPerson());
            if (person.getMother() != null || person.getFather() != null){
                sB.append("\n :: Parents: ");
                if (person.getMother() != null){
                    sB.append(person.getMother().getPerson());
                }
                if (person.getMother() != null && person.getFather() != null) {
                    sB.append(" & ");
                }
                if (person.getFather() != null) {
                    sB.append(person.getFather().getPerson());
                }
            }
            sB.append(getChildrensInfo(person.getID()));
            sB.append(getSiblings(person.getID()));
            sB.append("\n------------\n");
        }

        return sB.toString();
    }

    public P getPersonObj(long id){
        for (P person: relations) {
            if (person.getID() == id) {return person;}
        }
    return null;
    }

    public String getUnitPersonalTree(long id){
        StringBuilder sB = new StringBuilder();
        P selPerson = getPersonObj(id);
        sB.append("\n============\n");
        sB.append(selPerson.getID());
        sB.append(". ");
        sB.append(selPerson);
        sB.append(getChildrensInfo(selPerson.getID()));
        sB.append(getSiblingsFull(selPerson.getID()));
        sB.append("\n============\n");
        return sB.toString();
    }
    public String getSiblingsFull(long id){

        List <P> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();
        P selPerson = getPersonObj(id);
        P personMother = selPerson.getMother();
        P personFather = selPerson.getFather();

        for (P person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == personMother) ||
                (person.getFather() != null && person.getFather() == personFather))){
                    result.add(person);
            }
        }

        if (!result.isEmpty()){
            for(P entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n :: Sister: ");
                    sB.append(result);
                } else {
                    sB.append("\n :: Brother: ");
                    sB.append(result);
                }
            }
        }
        return sB.toString();
    }

    public String getSiblings(long id){

        List <P> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        P selPerson = getPersonObj(id);
        P personMother = selPerson.getMother();
        P personFather = selPerson.getFather();

        for (P person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == personMother) ||
                    (person.getFather() != null && person.getFather() == personFather))){
                result.add(person);
            }
        }

        if (!result.isEmpty()){
            for(P entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n ::=:: Sister: ");
                    sB.append(entry.getPerson());
                } else {
                    sB.append("\n ::=:: Brother: ");
                    sB.append(entry.getPerson());
                }
            }
        }
        return sB.toString();
    }

    public String getChildrensInfo(long id){
        StringBuilder sB = new StringBuilder();
        sB.append(getChildrensList(id));
        return sB.toString();
    }

    public String getChildrensList(long id){
        List <P> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        for (P person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother().getID() == id) ||
                    (person.getFather() != null && person.getFather().getID() == id))){
                result.add(person);
            }
        }

        if (!result.isEmpty()){
            for(P entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n ::>> Daughter: ");
                    sB.append(entry.getPerson());
                } else {
                    sB.append("\n ::>> Son: ");
                    sB.append(entry.getPerson());
                }
            }
        }
        return sB.toString();
    }

    public void sortByBirthDays() {
        System.out.println("Sorting by BirthDay");
        relations.sort(new PersonsComparatorByBirthday());
    }

    public void sortByNames(){
        System.out.println("Sorting by Name");
        relations.sort(new PersonsComparatorByNames());
    }

    public void sortByID(){
        System.out.println("Sorting by ID");
        relations.sort(new PersonsComparatorByID());
    }

    public void clear(){
        relations.clear();
    }

    public long setNextID(){
        long id = 0;
        for (P record: relations){
            if (id < record.getID()){
                id = record.getID();
            }
        }
        return id + 1;
    }

    public void setParents(int personId, int parentId){
        P unit = relations.get(personId);
        P parent = relations.get(parentId);
        System.out.println(unit);
        System.out.println(parent);
        if(parent.getGender().equals(Gender.Male)){
            unit.setFather(parent);
        } else {
            unit.setMother(parent);
        }
    }

    public void setUnitMarriage(int personId, String newName, int spouseId, LocalDate marriageDate){
        P unit = relations.get(personId);
        P spouse = relations.get(spouseId);
        List<P> unitList = new ArrayList<>();
        List<P> spouseList = new ArrayList<>();
        unitList.add(unit);
        spouseList.add(spouse);
//        System.out.println(unit);
//        System.out.println(spouse);
        unit.setMarriage(spouseList, newName, marriageDate);
        spouse.setMarriage(unitList, "", marriageDate);

    }

    @Override
    public Iterator<P> iterator() {
        return new FamilyTreeIterator(relations);
    }

}
