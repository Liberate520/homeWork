import java.util.ArrayList;
import java.util.Objects;

public class Relation extends Person {
    private Integer marriageId;
    private ArrayList<Integer> parentsIdList = new ArrayList<>();
    private ArrayList<Integer> kidsIdList = new ArrayList<>();

    public Relation(Integer id, String fullName, Integer birthYear, Integer marriageId, ArrayList<Integer> parents,
            ArrayList<Integer> kids) {
        super(id, fullName, birthYear);
        this.marriageId = marriageId;
        this.parentsIdList = parents;
        this.kidsIdList = kids;
    }

    public String listKids(ArrayList<Integer> kidsIdList) {
        if (kidsIdList.isEmpty()) {
            return "<нет>";
        }
        StringBuilder kidsList = new StringBuilder();
        String suffix = "";
        for (Integer kidId : kidsIdList) {
            kidsList.append(suffix);
            suffix = ", ";
            kidsList.append(kidId.toString());
        }
        return kidsList.toString();
    }

    public String listParents(ArrayList<Integer> parentsIdList) {
        if (parentsIdList.isEmpty()) {
            return "<нет>";
        }
        StringBuilder parentsList = new StringBuilder();
        String suffix = "";
        for (Integer parentId : parentsIdList) {
            parentsList.append(suffix);
            suffix = ", ";
            parentsList.append(parentId.toString());
        }
        return parentsList.toString();
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
        return Objects.hash(marriageId, parentsIdList, kidsIdList);
    }

    @Override
    public String toString() {
        return super.toString() + "\nРодители: " + listParents(parentsIdList) + "\nДети: " + listKids(kidsIdList);
        // + "\nВ браке с: " + (marriageId == null ? "<Нет>" : marriageId)
    }

}
