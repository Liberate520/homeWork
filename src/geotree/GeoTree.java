package geotree;

import person.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class GeoTree<T extends Person> implements Serializable, Iterable<T> {

    private final ArrayList<T> tree = new ArrayList<>();

    public ArrayList getTree() {

        return tree;
    }

    public void appendPerson(T person) {

        tree.add(person);
    }
    public void autoAppendChildren(){
        for (T p:tree) {
            if (p.getFather()!=null){
                p.getMother().addChild(p);
            }
            if (p.getFather()!=null){
                p.getFather().addChild(p);
            }
        }
    }

    public ArrayList<StringBuilder> spend(Person person, String re) {
        ArrayList<StringBuilder> result = new ArrayList<>();
        for ( Person p : tree) {
            if (p == person && re.equals("mother")) {
                result.add(p.getMother().getInfo());
            } else {
                if (p == person && re.equals("father")) {
                    result.add(p.getFather().getInfo());
                } else {
                    if (p == person && re.equals("child")) {
                        result.add(p.getChildrenInfo());
                    }
                }
            }
        }
        return result;
    }

    public String findPersonByName(String person) {
        for (Person p : tree) {
            if (p.getFullName().equals(person)) {
                return p.getInfo().toString();
            }
        }
        return "No such person!";
    }


    // метод поиска по возрасту
    public String searchAge(String age) {
        ArrayList<String> resultAge = new ArrayList<>();
        if (age.chars().allMatch(Character::isDigit)) {
            for (Person p : tree) {
                if (p.getAge() <= Integer.parseInt(age) && !resultAge.contains(p.getInfo())) {
                    resultAge.add(p.toString());
                }
            }
            return resultAge.toString();
        }
        return "No such people!";
    }

    public String addHuman(String dataForPerson){
        Person person;
        try{
            if (dataForPerson.split(",")[2].equals("Male")){
                person =  new Person(dataForPerson.split(",")[0],
                        new GregorianCalendar(Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[2]),
                                Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[1]),
                                Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[0])), Gender.Male);
            } else {
                if (dataForPerson.split(",")[2].equals("Female")) {
                    person = new Person(dataForPerson.split(",")[0],
                            new GregorianCalendar(Integer.parseInt(dataForPerson.split(",")[2].split("\\.")[0]),
                                    Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[1]),
                                    Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[0])), Gender.Female);
                } else {
                    return "Can't create human!";
                }
            }
        }catch (Exception e){
            return "Can't create human!";
        }
        tree.add((T) person);
        return person.toString();
    }
    public String getHuman(String person){
        for (Person p : tree) {
            if (p.getFullName().equals(person)) {
                return p.toString();
            }
        }
        return "No such person!";
    }
    public String getAll(){
        StringBuilder sb = new StringBuilder();
        for (Person p : tree) {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator(){
        return new PersonIterator(tree);
    }
    public void sortByAge() {
        tree.sort(new PersonComparatorByAge());
    }
    public void sortByName() {
        tree.sort(new PersonComparatorByName());
    }

}