package Tree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("Family tree:\n");
        for (Map.Entry<Integer, Person> item : personList.entrySet()){
            tmp.append(item.getValue().toString());
            tmp.append("\n");
            //System.out.println(item.getValue().toString());
        }
        return tmp.toString();
    }

//    public void printTree(){
//        for (Map.Entry<Integer, Person> item : personList.entrySet()){
//            System.out.println(item.getValue().toString());
//        }
//    }

}
