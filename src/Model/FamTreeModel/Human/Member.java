package Model.FamTreeModel.Human;

import Model.FamTreeModel.TreeMembers;

import java.io.Serializable;
import java.util.*;

public abstract class Member implements Serializable, Comparable<Member>, TreeMembers {
    private long id;
    private String firstName;
    private String lastName;
    private Gender sex;

    private int age;
    private Member father;
    private Member mother;
    private Set<Member> children;

    public Member(){children = new HashSet<>();}
    public Member(long id, String firstName, String lastName, Gender sex, int age){
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public void addChildren(Member... children) {
        for (Member child : children) {
            if (isMan()) {
                child.setFatherWithoutAddingChild(this);
            } else {
                child.setMotherWithoutAddingChild(this);
            }
            this.children.add(child);

        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSex(Gender sex){
        this.sex = sex;
    }
    @Override

    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Gender getSex() {
        return sex;
    }


    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Member getFather() {
        return father;
    }

    public void setFather(Member father) {

        this.father = father;
        father.addChildrenWithoutSettingParents(this);
    }

    @Override
    public Member getMother() {
        return mother;
    }

    public void setMother(Member mother) {
        this.mother = mother;
        mother.addChildrenWithoutSettingParents(this);
    }

    @Override
    public Set<Member> getChildren() {

        return this.children;
    }


    public boolean isWom(){
        return sex == Gender.W;
    }
    public boolean isMan(){
        return sex == Gender.M;
    }



    private void setFatherWithoutAddingChild(Member father) {
        this.father = father;
    }
    private void setMotherWithoutAddingChild(Member mother) {
        this.mother = mother;
    }


    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        Formatter frm = new Formatter();
        String childrens = "No";
        if(!children.isEmpty()) {
            ArrayList<String> chldsNam = new ArrayList<>();
            for (Member ch : children) {
                chldsNam.add(ch.getFirstName());
            }

            childrens = chldsNam.toString();
        }
                String fater = "";
        String muter = "";
        if (father!= null) {

           fater = getFather().firstName;
        }
        else {
            fater = "n/a";
        }

        if (mother!= null) {

            muter = getMother().firstName;
        }
        else {
            muter = " n/a";
        }

        sb.append(frm.format("id: %3d, Name: %10s, Famil: %10s, Sex: %2s, Age: %3d, Father: %10s, Mother: %10s, Children: %20s ",
                                id, firstName, lastName, sex, age, fater, muter, childrens));
//        sb.append(getChildrenInf());
        return sb.toString();
    }

    @Override
    public int compareTo(Member member) {
        long l = id - member.getId();
        return (int) l;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private void addChildrenWithoutSettingParents(Member children) {
        {
            this.children.add(children);
        }
    }
}
