import java.util.*;
import java.io.Serializable;

public class Family  implements Serializable, Iterable<Human>{
    private List<Human> members;

    private Writable writable;

    public Family(List<Human> members) {
        this.members = members;
    }

    public Family(){
        this(new ArrayList<>());
    }

    public List<Human> getMembers() {
        return members;
    }

    public void add(Human member) {
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

    public Human search(String sName) {
        Human find = null;
        for (Human human: members) {
            if (human.getName().contains(sName)) {
                find = human;
            }
        }
        return find;
    }

    public List<Human> getParents(Human child) {
        List<Human> parents = new ArrayList<>();
        if(child.getFather() != null) {
            parents.add(child.getFather());
        }
        if(child.getMother() != null) {
            parents.add(child.getMother());
        }
        return parents;
    }

    public List<Human> getChildrens(List<Human> parents) {
        List<Human> children = new ArrayList<>();
        for (Human parent: parents) {
            if(parent.getChildren() != null){
                children.addAll(parent.getChildren());
            }
        }
        Set<Human> uniq_children = new HashSet<>(children);
        children = new ArrayList<>(uniq_children);
        return children;
    }

    public List<Human> check(String sName) {
        Human find = search(sName);
        List<Human> parents = getParents(find);
        if(parents.isEmpty()) return parents;
        else{
            List<Human> children = getChildrens(parents);
            children.remove(find);
            return children;
        }
    }

    public StringBuilder getBroAndSis(String sName) {
        List<Human> res = check(sName);
        StringBuilder result = new StringBuilder(sName  + ": ");
        if(res.isEmpty()) result.append("no sister brother");
        else {
            for (Human human: res) {
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

    public void save() {
        if(writable instanceof FileHandler) {
            FileHandler fileHandler1 = (FileHandler) writable;
        }
        if(writable != null) {
            writable.save(this);
        }
    }

    public void setFileHandler(Writable writable) {
        this.writable = writable;
    }

    public Family read() {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                return (Family) writable.read();
            }
        }
        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return null;
    }
}
