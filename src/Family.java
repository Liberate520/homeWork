import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.Serializable;

public class Family<T extends People> implements Serializable, Iterable<T>{

    private List<T> members;

    private WritableFile writable;

    public Family(List<T> members) {
        this.members = members;
    }

    public void setWritable(WritableFile writable) {
        this.writable = writable;
    }

    public void saveFamily() {
        writable.save(this);
    }

    public void setFileHandler(WritableFile writable) {
        this.writable = writable;
    }

    public Family readFile() {
        if (writable != null) {
            // Проверка класса
            // if (writable instanceof FileHandler) {}
            if(writable.readFile() == null) {
                return new Family<T>();
            }
            else return (Family) writable.readFile();
        }
        return null;
    }

    public Family() {
        this(new ArrayList<>());
    }

    public void add(T member) {
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

    // поменять на .contains >> .equals?
    public People search(String sPeopleName) {
        People finderPeople  = null;
        for (T people : members) {
            if (people.getName().equals(sPeopleName)) {
                finderPeople = people;
            }
        }
        return finderPeople;
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

    public void showAll(){
        for (T member: members) {
            System.out.println(member.toString());
        }
    }

    public void sortByName() {
        Collections.sort(members);
    }

    public void sortByDate() {
        Collections.sort(members, new ComparatorByDate());
    }

    @Override
    public String toString() {
        return "Family: " +
                members;
    }

    @Override
    public  Iterator<T> iterator() {
        // 
        return new FamilyIterator(members);
        // return null;
    }

}
