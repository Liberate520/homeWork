package family_tree.ftree;

import family_tree.person.Gender;
import  family_tree.person.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    
    private List<Person> relations;

    public FamilyTree(List<Person> relations){
        this.relations = relations;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addPerson(Person person){
        relations.add(person);
    }
    
    public String getFullRelativesInfo(){
        StringBuilder sB = new StringBuilder();
        sB.append("\n============\n");
        sB.append("Full Family tree:\n");
        sB.append("============\n");
        for (Person person: relations){
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
            sB.append(getSisterBrother(person.getMother(), person.getFather(), person.getID()));
            sB.append("\n------------\n");
        }

        return sB.toString();
    }

    public String getPersonalTree(int id){
        StringBuilder sB = new StringBuilder();
        Person person = relations.get(id);
        sB.append("\n============\n");
        sB.append(person.getID());
        sB.append(". ");
        sB.append(person);
        sB.append(getSisterBrotherFull(person.getMother(), person.getFather(), person.getID()));
        sB.append("\n============\n");

        return sB.toString();

    }
    public String getSisterBrotherFull(Person mother, Person father, long id){

        List <Person> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        for (Person person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == mother) || 
                (person.getFather() != null && person.getFather() == father))){
                    result.add(person);
            }
        }

        if (result.size() > 0){
            for(Person entry: result){
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

    public String getSisterBrother(Person mother, Person father, long id){

        List <Person> result = new ArrayList<>();
        StringBuilder sB = new StringBuilder();

        for (Person person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == mother) ||
                    (person.getFather() != null && person.getFather() == father))){
                result.add(person);
            }
        }

        if (result.size() > 0){
            for(Person entry: result){
                if (entry.getGender() == Gender.Female){
                    sB.append("\n :: Sister: ");
                    sB.append(entry.getPerson());
                } else {
                    sB.append("\n :: Brother: ");
                    sB.append(entry.getPerson());
                }
            }
        }
        return sB.toString();
    }

}
