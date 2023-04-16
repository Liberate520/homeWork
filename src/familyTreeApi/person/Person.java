package familyTreeApi.person;

import familyTreeApi.member.Member;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Person implements Serializable, Comparable<Person>, Member {
    private List<String> name;
    private String kind;
    private boolean isMale;
    private Calendar bornDate;
    private Map<Person, Boolean> married;
    private List<Person> children;
    private List<Person> parents;

    public Person(String name, String kind, boolean isMale, Calendar bornDate) {
        this(name, kind, isMale, bornDate, new HashMap<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Person(String name, Person person) {
        this(name, person.kind, person.isMale, person.bornDate, person.married, person.children, person.parents);
        this.updateLinks();
    }

    private Person(String name, String kind, boolean isMale, Calendar bornDate, Map<Person, Boolean> married, List<Person> children, List<Person> parents) {
        this.setName(name);
        this.kind = kind;
        this.isMale = isMale;
        this.married = married;
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

    public String getNameString() {
        return this.getName().stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public Calendar getBornDate() {
        return this.bornDate;
    }

    public Boolean getGender() {
        return this.isMale;
    }

    public Map<Person, Boolean> getMarrieds() {
        return this.married;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public String getKind() {
        return this.kind;
    }

    public Person getMarried() {
        if (this.getMarrieds().containsValue(true)) {
            for (Map.Entry<Person, Boolean> entry : this.getMarrieds().entrySet())
                if (entry.getValue()) return entry.getKey();
        }
        return null;
    }

    public boolean addMarried(Member married, boolean isMarried) {
        if (!this.hasMarried((Person) married)) {
            this.getMarrieds().put((Person) married, isMarried);
            married.addMarried(this, isMarried);
            return true;
        }
        return false;
    }

    public boolean addChild(Member child) {
        if (!this.hasChild((Person) child)) {
            ((List<Person>) this.getChildren()).add((Person) child);
            child.addParent(this);
            return true;
        }
        return false;
    }

    public boolean addParent(Member parent) {
        if (!this.hasParent((Person) parent)) {
            ((List<Person>) this.getParents()).add((Person) parent);
            parent.addChild(this);
            return true;
        }
        return false;
    }

    public void updateLinks() {
        this.updateChildren();
        this.updateParents();
    }

    private void updateChildren() {
        if (this.countChildren() > 0) {
            for (Person person : this.children) {
                person.addParent(this);
            }
        }
    }

    private void updateParents() {
        if (this.countParents() > 0) {
            for (Person person : this.parents) {
                person.addChild(this);
            }
        }
    }

    public int countChildren() {
        return this.children.size();
    }

    private int countParents() {
        return this.parents.size();
    }

    public boolean hasMarried(Person married) {
        return this.married.containsKey(married);
    }

    public boolean hasChild(Person child) {
        return this.children.contains(child);
    }

    private boolean hasParent(Person parent) {
        return this.parents.contains(parent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return isMale == person.isMale && Objects.equals(name, person.name) && Objects.equals(kind, person.kind) && Objects.equals(bornDate, person.bornDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, isMale, bornDate);
    }

    public int compareTo(Person p) {
        int result = this.getName().get(0).compareTo(p.getName().get(0));
        if (result == 0) result = this.getName().get(1).compareTo(p.getName().get(1));
        if (result == 0) {
            result = this.getBornDate().compareTo(p.getBornDate());
        }
        return result;
    }
}