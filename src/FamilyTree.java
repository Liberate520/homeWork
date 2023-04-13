import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTree implements Serializable {
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
                result.add(person.getHumanName() + " " + person.getHumanSurname());
        }
        return result;
    }

    public  ArrayList<String> getBrothersAndSisters (Integer motherID, Integer fatherID, Integer humanID) {
        ArrayList<String> result = new ArrayList<>();
        if (motherID != null && fatherID != null) {
            for (Human person: mapHumans.values()) {
                if (person.getMotherID() == motherID && person.getFatherID() == fatherID && person.getHumanID() != humanID) {
                    result.add(person.getHumanFullName());
                }
            }
        }
        return result;
    }

    public String showTree (Integer id) {
        Human person = this.mapHumans.getOrDefault(id, new Human());
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder result = new StringBuilder(" [").append(person.getHumanID()).append("] ").
                append(person.getHumanFullName());
        result.append("\n\tдата рождения: ").append(df.format(person.getDateOfBirth()));
        if (person.getDateOfDeath() != null) result.append("\n\tдата смерти: ").append(df.format(person.getDateOfDeath()));
        if (person.getMotherID() != null) result.append("\n\tМать: ").append(
                this.mapHumans.get(person.getMotherID()).getHumanFullName());
        if (person.getFatherID() != null) result.append("\n\tОтец: ").append(
                this.mapHumans.get(person.getFatherID()).getHumanFullName());
        if (person.getPartnerID() != null) result.append("\n\tСупруг(а): ").append(
                this.mapHumans.get(person.getPartnerID()).getHumanFullName());

        ArrayList<String> childrens;
        childrens = this.getChildrens(person.getHumanID());

        if (childrens.size() > 0) {
            result.append("\n\n\tДети: ");
            for (String children : childrens) {
                result.append("\n\t\t").append(children);
            }
        }

        ArrayList<String> brothersAndSisters;
        brothersAndSisters = this.getBrothersAndSisters(person.getMotherID(), person.getFatherID(), person.getHumanID());
        if (brothersAndSisters.size() > 0) {
            result.append("\n\n\tБратья и сестры: ");
            for (String bs : brothersAndSisters) {
                result.append("\n\t\t").append(bs);
            }
        }

        return result.toString();
    }

    public String showTree () {
        return showTree(0);
    }

    @Override
    public String toString() {
        return mapHumans.toString();
    }
}
