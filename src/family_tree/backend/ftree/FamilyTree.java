package family_tree.backend.ftree;

import family_tree.backend.person.Gender;
import family_tree.backend.person.PersonsComparatorByNames;
import family_tree.backend.person.PersonsComparatorByBirthday;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<P extends Relatives<P>> implements Serializable, Iterable<P>, Wedding, Childrens {
    
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
                if (person.getMother().getPerson() != null){
                    sB.append(person.getMother().getPerson());
                }
                if (person.getMother() != null && person.getFather() != null) {
                    sB.append(" & ");
                }
                if (person.getFather().getPerson() != null) {
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

    public String getPersonalTree(long id){
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

        if (result.size() > 0){
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

        if (result.size() > 0){
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

        if (result.size() > 0){
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

    public void sortByBirthDays(){
        relations.sort(new PersonsComparatorByBirthday());
    }

    public void sortByNames(){
        relations.sort(new PersonsComparatorByNames());
    }

    @Override
    public Iterator<P> iterator() {
        return new FamilyTreeIterator(relations);
    }

}
