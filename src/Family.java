import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;

public class Family implements Serializable {

    private List<People> members;

    private WritableFile writable;

    public Family(List<People> members) {
        this.members = members;
    }

    // Лишняя проверка
    public void save() {
        if (writable instanceof FileHandler) {
            FileHandler fileHandler1 = (FileHandler) writable;
        }
        if (writable != null) {
            writable.save(this);
        }
    }

    public void setFileHandler(WritableFile writable) {
        this.writable = writable;
    }

    // Лишняя проверка
    public Family readFile() {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                return (Family) writable.readFile();
            }
        }
        return null;
    }

    public Family() {
        this(new ArrayList<>());
    }

    public void add(People member) {
        // Придумать как составить метод addChild из этой кнострукции
        // "и добавить в классе People метод addChild"
        if (member != null) {
            members.add(member);
            if (member.getFather() != null) {
                member.getFather().getChildren().add(member);
            }
            if (member.getMother() != null) {
                member.getMother().getChildren().add(member);
            }
        }
    }

    // Что то с циклом не так и поменять на .contains >> .equals?
    public People search(String sPeopleName) {
        People finderPeople  = null;
        for (People people : members) {
            if (people.getName().contains(sPeopleName)) {
                finderPeople  = people;
            }
        }
        return finderPeople ;
    }

    public List<String> getFamMembers(String sPeopleName) {
        List<String> allNames = new ArrayList<>();
        People finderPeople = search(sPeopleName);
        if (finderPeople.getFather() != null && finderPeople.getFather().getChildren() != null) {
            for (People child : finderPeople.getFather().getChildren()) {
                allNames.add(child.getName());
            }
        }
        if (finderPeople.getMother() != null && finderPeople.getMother().getChildren() != null) {
            for (People child : finderPeople.getMother().getChildren()) {
                allNames.add(child.getName());
            }
        }
        Set<String> uniq_name = new HashSet<>(allNames); // удалние повторяющихся имен (дети матери и дети отца)
        List<String> res = new ArrayList<>(uniq_name);
        res.remove(sPeopleName);
        if (res.isEmpty()) {
            res.add("нет братьев или сестер");
        }
        return res;
    }

    @Override
    public String toString() {
        return "Family: " +
                members;
    }

}
