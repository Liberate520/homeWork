package geotree;

import person.Gender;
import person.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Research {

    private final ArrayList<Person> tree;


    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    // метод поиска связи
    public ArrayList<StringBuilder> spend(Person person, String re) {
        ArrayList<StringBuilder> result = new ArrayList<>();
        for (Person p : tree) {
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
            person =  new Person(dataForPerson.split(",")[0],
                    new GregorianCalendar(Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[0]),
                            Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[1]),
                            Integer.parseInt(dataForPerson.split(",")[1].split("\\.")[2])), Gender.Male);
        }catch (Exception e){
            return "Can't create human!";
        }
        tree.add(person);
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
}