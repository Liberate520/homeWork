package OOPjavaTree.src;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String family;
    private String burndate;
    private List<String> parents;
    private List<String> children;

    public Human(String family, String name, String burndate) {
        this.name = name;
        this.family = family;
        this.burndate = burndate;
        this.parents = new ArrayList<String>();
        this.children = new ArrayList<String>();
    }

    public Human(){
        this.name = null;
        this.family = null;
        this.burndate = null;
        this.parents = new ArrayList<String>();
        this.children = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setBurndate(String burndate) {
        this.burndate = burndate;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(String person) {
        this.parents.add(person);
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(String person) {
        this.children.add(person);
    }

    @Override
    public String toString() {
        return this.family + " " + this.name + " " + this.burndate;
    }
}
