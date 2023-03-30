import java.util.ArrayList;
import java.util.Objects;

public class Relation extends Person {
    private ArrayList<Person> marriageList = new ArrayList<>();
    // private ArrayList<Person> parentsList = new ArrayList<>();
    private ArrayList<Person> kidsList = new ArrayList<>();

    public Relation(Integer id, String fullName, Integer birthYear, ArrayList<Person> marriageList,
            ArrayList<Person> kids) {
        super(id, fullName, birthYear);
        this.marriageList = marriageList;
        // this.parentsList = parents;
        this.kidsList = kids;
    }

    public Relation(Integer id, String fullName, Integer birthYear) {
        super(id, fullName, birthYear);
    }

    public Relation(Person person) {
        super(person.getId(), person.getFullName(), person.getBirthYear());
    }

    public void setKidsIdList(ArrayList<Person> kidsIdList) {
        this.kidsList = kidsIdList;
    }

    public void addKid(Person newKid) {
        if (!kidsList.contains(newKid))
            kidsList.add(newKid);
        return;
    }

    public void setMarriageIdList(ArrayList<Person> marriageIdList) {
        this.marriageList = marriageIdList;
    }

    public void addMarriage(Person newMarriage) {
        if (!marriageList.contains(newMarriage))
            marriageList.add(newMarriage);
        return;
    }

    public ArrayList<Person> getKidsList() {
        return kidsList;
    }

    public String listKids(ArrayList<Person> kidsIdList) {
        if (kidsIdList.isEmpty()) {
            return "<нет>";
        }
        StringBuilder kidsList = new StringBuilder();
        String suffix = "";
        for (Person kidId : kidsIdList) {
            kidsList.append(suffix);
            suffix = ", ";
            kidsList.append(kidId.toString());
        }
        return kidsList.toString();
    }

    public String listParents(ArrayList<Person> parentsIdList) {
        if (parentsIdList.isEmpty()) {
            return "<нет>";
        }
        StringBuilder parentsList = new StringBuilder();
        String suffix = "";
        for (Person parentId : parentsIdList) {
            parentsList.append(suffix);
            suffix = ", ";
            parentsList.append(parentId.toString());
        }
        return parentsList.toString();
    }

    public String listMarriage(ArrayList<Person> marriageList) {
        if (marriageList.isEmpty()) {
            return "<нет>";
        }
        StringBuilder marriageStringBuilder = new StringBuilder();
        String suffix = "";
        for (Person marriage : marriageList) {
            marriageStringBuilder.append(suffix);
            suffix = ", ";
            marriageStringBuilder.append(marriage.toString());
        }
        return marriageStringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Relation)) {
            return false;
        }
        Relation relation = (Relation) o;
        return relation.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(marriageList, kidsList);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nВ браке с: " + listMarriage(marriageList)
                + "\nДети: " + listKids(kidsList);
    }

    public ArrayList<Person> getMarriageList() {
        return this.marriageList;
    }

    public void setMarriageList(ArrayList<Person> marriageList) {
        this.marriageList = marriageList;
    }
    public void setKidsList(ArrayList<Person> kidsList) {
        this.kidsList = kidsList;
    }

}
