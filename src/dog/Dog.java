package dog;

import member.Member;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Dog implements Serializable, Comparable<Dog>, Member {
    private List<String> name;
    private String kind;
    private boolean isMale;
    private Calendar bornDate;
    private List<Dog> children;
    private List<Dog> parents;

    public Dog(String name, String kind, boolean isMale, Calendar bornDate) {
        this(name, kind, isMale, bornDate, new ArrayList<>(), new ArrayList<>());
    }

    public Dog(String name, Dog dog) {
        this(name, dog.kind, dog.isMale, dog.bornDate, dog.children, dog.parents);
        this.updateLinks();
    }

    private Dog(String name, String kind, boolean isMale, Calendar bornDate, List<Dog> children, List<Dog> parents) {
        this.setName(name);
        this.kind = kind;
        this.isMale = isMale;
        this.bornDate = bornDate;
        this.children = children;
        this.parents = parents;
    }

    public void setName(String name) {
        setName(new ArrayList<>(Arrays.asList(name.split(","))));
    }

    private void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getName() {
        return this.name;
    }

    @Override
    public String getNameString() {
        return this.getName().stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    @Override
    public Calendar getBornDate() {
        return this.bornDate;
    }

    @Override
    public Boolean getGender() {
        return this.isMale;
    }

    @Override
    public ThreadLocal<Object> getChildren() {
        return (ThreadLocal<Object>) this.children;
    }

    @Override
    public ThreadLocal<Object> getParents() {
        return (ThreadLocal<Object>) this.parents;
    }

    @Override
    public String getKind() {
        return this.kind;
    }

    public void addChild(Dog child) {
        if (!this.hasChild(child)) {
            this.children.add(child);
            child.addParent(this);
        }
    }

    public void addParent(Dog parent) {
        if (!this.hasParent(parent)) {
            this.parents.add(parent);
            parent.addChild(this);
        }
    }

    public void updateLinks() {
        this.updateChildren();
        this.updateParents();
    }

    private void updateChildren() {
        if (this.countChildren() > 0) {
            for (Dog dog : this.children) {
                dog.addParent(this);
            }
        }
    }

    private void updateParents() {
        if (this.countParents() > 0) {
            for (Dog dog : this.parents) {
                dog.addChild(this);
            }
        }
    }

    @Override
    public int countChildren() {
        return this.children.size();
    }

    private int countParents() {
        return this.parents.size();
    }

    public boolean hasChild(Dog child) {
        return this.children.contains(child);
    }

    private boolean hasParent(Dog parent) {
        return this.parents.contains(parent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return isMale == dog.isMale && Objects.equals(name, dog.name) && Objects.equals(kind, dog.kind) && Objects.equals(bornDate, dog.bornDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, isMale, bornDate);
    }

    @Override
    public int compareTo(Dog p) {
        int result = this.getName().get(0).compareTo(p.getName().get(0));
        if (result == 0) result = this.getName().get(1).compareTo(p.getName().get(1));
        if (result == 0) {
            result = this.getBornDate().compareTo(p.getBornDate());
        }
        return result;
    }
}
