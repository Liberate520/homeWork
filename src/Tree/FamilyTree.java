package Tree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private HashMap<Integer, Person> personList;
    private int personId = 0;
    public FamilyTree() {
        this.personList = new HashMap<Integer, Person>();
    }

    public void addPerson(Person person){
        this.personList.put(personId++,person);
    }

    public void setParent1(Person person, Person parent){
        person.setParent1(parent);
        if (! parent.getChildren().contains(person)){
            parent.addChild(person);
        }
    }
    public void setParent2(Person person, Person parent){
        person.setParent2(parent);
        if (! parent.getChildren().contains(person)){
            parent.addChild(person);
        }
    }

    public void printTree(){
        for (Map.Entry<Integer, Person> item : personList.entrySet()){
            System.out.println(item.getValue().toString());
        }
    }

}
