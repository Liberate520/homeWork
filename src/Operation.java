import java.util.*;

public class Operation<T extends Human> {
    private FamilyTree<T> familyftree;

    public Operation(FamilyTree<T> familyftree) {
        this.familyftree = familyftree;
    }

    public T search(String sName) {
        T find = null;
        if(sName.isEmpty() || sName.equalsIgnoreCase("no")){
            find = null;
        }
        else{
            for (T human: familyftree) {
                if (human.getName().contains(sName)) {
                    find = human;
                }
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
}