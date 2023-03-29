import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTree {
    private HashMap<Integer, Human> mapHumans;

    public FamilyTree() {
        mapHumans = new HashMap<>();
    }

    public void add (Human human) {
        mapHumans.put(human.getHumanID(), human);
    }

    public String getNameByID (Integer id) {
        return mapHumans.get(id).getHumanName();
    }

    public ArrayList<String> getChildrens (Integer id) {
        ArrayList<String> result = new ArrayList<>();
        for (Human person: mapHumans.values()) {
            if (id.equals(person.getFatherID()) || id.equals(person.getMotherID()))
                result.add(person.getHumanName());
        }
        return result;
    }

    public  ArrayList<String> getBrothersAndSisters (Integer motherID, Integer fatherID, Integer humanID) {
        ArrayList<String> result = new ArrayList<>();
        if (motherID != null && fatherID != null) {
            for (Human person: mapHumans.values()) {
                if (person.getMotherID() == motherID && person.getFatherID() == fatherID && person.getHumanID() != humanID) {
                    result.add(person.getHumanName());
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return mapHumans.toString();
    }
}
