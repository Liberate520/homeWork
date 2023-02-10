import java.util.*;
import java.io.Serializable;

public class Family <T extends Human> implements Serializable, Iterable<T>{
    private List<T> members;

    public Family(List<T> members) {
        this.members = members;
    }

    public Family(){
        this(new ArrayList<>());
    }

    public List<T> getMembers() {
        return members;
    }

    public void add(T member) {
        if(member != null) {
            members.add(member);
            if(member.getFather() != null) {
                member.getFather().getChildren().add(member);
            }
            if(member.getMother() != null) {
                member.getMother().getChildren().add(member);
            }
        }
    }


    @Override
    public String toString() {
        return "Family: " +
                members;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyIterator(members);
    }
}
