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

    public T search(String sName) {
        T find = null;
        for (T human: members) {
            if (human.getName().contains(sName)) {
                find = human;
            }
        }
        return find;
    }

    public List<T> getParents(T child) {
        List<T> parents = new ArrayList<>();
        if(child.getFather() != null) {
            parents.add((T) child.getFather());
        }
        if(child.getMother() != null) {
            parents.add((T) child.getMother());
        }
        return parents;
    }

    public List<T> getChildrens(List<T> parents) {
        List<T> children = new ArrayList<>();
        for (T parent: parents) {
            if(parent.getChildren() != null){
                children.addAll((Collection<? extends T>) parent.getChildren());
            }
        }
        Set<T> uniq_children = new HashSet<>(children);
        children = new ArrayList<>(uniq_children);
        return children;
    }

    public List<T> check(String sName) {
        T find = search(sName);
        List<T> parents = getParents(find);
        if(parents.isEmpty()) return parents;
        else{
            List<T> children = getChildrens(parents);
            children.remove(find);
            return children;
        }
    }

    public StringBuilder getBroAndSis(String sName) {
        List<T> res = check(sName);
        StringBuilder result = new StringBuilder(sName  + ": ");
        if(res.isEmpty()) result.append("no sister brother");
        else {
            for (T human: res) {
                result.append(human.getName() + " ");
            }
        }
        return result;
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
