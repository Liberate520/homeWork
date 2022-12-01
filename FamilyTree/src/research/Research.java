package research;

import people.Humans;

import java.util.ArrayList;
import java.util.List;

public class Research {
    private String findPerson;

    public Research(String findPerson) {
        this.findPerson = findPerson;
    }

    public String getFindPerson() {
        return findPerson;
    }

    public void setFindPerson(String findPerson) {
        this.findPerson = findPerson;
    }

    public static List<Humans> findHumansByExample(List<Humans> humans, String find) {
        List<Humans> res = new ArrayList<>();
        for (Humans hum : humans) {
            if (hum.getOnePerson().startsWith(find)) {
                res.add(hum);
            }
        }
        return res;


    }
}
