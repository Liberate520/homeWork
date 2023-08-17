package FamilyTree;

import Human.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable {
    private long personID;
    private List<Person> personList;

    public Tree(List<Person> personList) {this.personList = personList;}
    public Tree(){this(new ArrayList<>());}

    public List<Person> getPersonList() {
        return personList;
    }

    public boolean add(Person person){
        if (person == null){
            return false;
        }
        if (!personList.contains(person)){
            personList.add(person);
            person.setId(personID++);

            addToParent(person);
            addToChildren(person);

            return true;
        }
        return false;
    }

    private void addToParent(Person person) {
        for (Person parent: person.getParents()){
            parent.addChild(person);
        }
    }

    private void addToChildren(Person person){
        for(Person child: person.getChildren()){
            child.addParent(person);
        }
    }

    public List<Person> getSiblings(int id) {
        Person person = getById(id);
        if (person == null){
            return null;
        }
        List<Person> res = new ArrayList<>();
        for (Person parent: person.getParents()){
            for (Person child: parent.getChildren()){
                if (!child.equals(person) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Person> getByName(String name){
        List<Person> res = new ArrayList<>();
        for (Person person: personList){
            if (person.getName().equalsIgnoreCase(name)){
                res.add(person);
            }
        }
        return res;
    }

    public boolean setWedding(long personID1, long personID2){
        if(checkId(personID1) && checkId(personID2)){
            Person per1 = getById(personID1);
            Person per2 = getById(personID2);
            return setWedding(per1, per2);
        }
        return false;
    }

    public boolean setWedding(Person per1, Person per2){
        if(per1.getSpouse()==null && per2.getSpouse()==null){
            per1.setSpouse(per2);
            per2.setSpouse(per1);
            return true;
        }else{
            return false;
        }
    }

    public boolean setDivorce(long personID1, long personID2){
        if(checkId(personID1) && checkId(personID2)) {
            Person per1 = getById(personID1);
            Person per2 = getById(personID2);
            if (per1.getSpouse() != null && per2.getSpouse() != null) {
                per1.setSpouse(null);
                per2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long personID){
        if(checkId(personID)){
            Person human = getById(personID);
            return personList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id > personID || id < 0){
            return false;
        }
        for (Person person: personList) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Person getById(long id){
        for (Person per: personList){
            if (per.getId()==id){
                return per;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tree contains ");
        sb.append(personList.size());
        sb.append(" objects: \n");
        for (Person per: personList){
            sb.append(per);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
}
