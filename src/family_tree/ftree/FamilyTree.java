package family_tree.ftree;

import  family_tree.person.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    
    private long idc;
    private long id;
    private List<Person> relations;

    public FamilyTree(List<Person> relations){
//        this.id = idc++;
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
        stringBuilder.append("\n------------\n");
        for (Person person: relations){
            stringBuilder.append(person);
            stringBuilder.append("\n============\n");
        }

        return stringBuilder.toString();
    }
}
