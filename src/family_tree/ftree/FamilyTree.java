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
    
    public String getRelativesInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n============\n");
        stringBuilder.append("Family tree:\n");
        stringBuilder.append("============\n");
        for (Person person: relations){
            stringBuilder.append(person);
            stringBuilder.append(getSisterBrother(person.getMother(), person.getFather(), person.getID()));
            stringBuilder.append("\n------------\n");
        }

        return stringBuilder.toString();
    }

    public String getSisterBrother(Person mother, Person father, long id){

        List <Person> result = new ArrayList<>();

        for (Person person: relations){
            if (person.getID() != id && ((person.getMother() != null && person.getMother() == mother) || 
                (person.getFather() != null && person.getFather() == father))){
                    result.add(person);
            }
        }

        if (result.size() > 0){
            String resultList = "";
            for(Person entry: result){
                if (entry.getGender() == Gender.Female){
                    resultList += "\n :: Sister: " + result.toString();
                } else {
                    resultList += "\n :: Brother: " + result.toString();
                }
            }
            return resultList;
        }
        
        return null;
    }

}
