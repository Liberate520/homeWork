package model.family;

import model.person.Person;
import model.person.PersonIterator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class FamilyTree<E extends Person> implements Serializable, Iterable<E>, Family<E> {
    private HashMap<Integer, E> mapHumans;
    private int id;

    public int getId() {
        return id;
    }

    public FamilyTree() {
        mapHumans = new HashMap<>();
    }

    public void add(E human) {
        mapHumans.put(id, human);
        id++;
    }

    public void delete (Integer id) {
        mapHumans.remove(id);
    }

    public List<E> getHumanList() {
        return new ArrayList<>(mapHumans.values());
    }

    public String getNameByID(Integer id) {
        return mapHumans.get(id).getPersonName();
    }

    public ArrayList<String> getChildrens(Integer id) {
        ArrayList<String> result = new ArrayList<>();
        for (E person : mapHumans.values()) {
            if (id.equals(person.getFatherID()) || id.equals(person.getMotherID()))
                result.add(person.getPersonName() + " " + person.getPersonSurname());
        }
        return result;
    }

    public ArrayList<String> getBrothersAndSisters(Integer motherID, Integer fatherID, Integer humanID) {
        ArrayList<String> result = new ArrayList<>();
        if (motherID != null && fatherID != null) {
            for (E person : mapHumans.values()) {
                if (person.getMotherID() == motherID && person.getFatherID() == fatherID && person.getID() != humanID) {
                    result.add(person.getHumanFullName());
                }
            }
        }
        return result;
    }

    public String showTree(Integer id) {
        E person = this.mapHumans.get(id);
//        E model.person = this.mapHumans.getOrDefault(id, new <E>());
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder result = new StringBuilder(" [").append(person.getID()).append("] ").
                append(person.getHumanFullName());
        if (person.getDateOfBirth() != null)
            result.append("\n\tдата рождения: ").append(df.format(person.getDateOfBirth()));
        if (person.getDateOfDeath() != null)
            result.append("\n\tдата смерти: ").append(df.format(person.getDateOfDeath()));
        if (person.getMotherID() != null) result.append("\n\tМать: ").append(
                this.mapHumans.get(person.getMotherID()).getHumanFullName());
        if (person.getFatherID() != null) result.append("\n\tОтец: ").append(
                this.mapHumans.get(person.getFatherID()).getHumanFullName());
        if (person.getPartnerID() != null) result.append("\n\tСупруг(а): ").append(
                this.mapHumans.get(person.getPartnerID()).getHumanFullName());

        ArrayList<String> childrens;
        childrens = this.getChildrens(person.getID());

        if (childrens.size() > 0) {
            result.append("\n\n\tДети: ");
            for (String children : childrens) {
                result.append("\n\t\t").append(children);
            }
        }

        ArrayList<String> brothersAndSisters;
        brothersAndSisters = this.getBrothersAndSisters(person.getMotherID(), person.getFatherID(), person.getID());
        if (brothersAndSisters.size() > 0) {
            result.append("\n\n\tБратья и сестры: ");
            for (String bs : brothersAndSisters) {
                result.append("\n\t\t").append(bs);
            }
        }

        return result.toString();
    }

    public String showTree() {
        return showTree(0);
    }

    @Override
    public String toString() {
        return mapHumans.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(mapHumans);
    }

    public boolean checkID(Integer id) {
        return mapHumans.containsKey(id);
    }

    public Integer sizeTree() {
        return mapHumans.size();
    }
}
