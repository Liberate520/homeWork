package HW;

import java.util.List;

public class FamilyMember<T> {
    private String name;
    private String dateBirth;
    private String dateDeath;
    private T father;
    private T mather;
    private int age;
    private List<T> children;

    public T getFather() {
        return father;
    }

    public void setFather(T father) {
        this.father = father;
    }

    public T getMather() {
        return mather;
    }

    public void setMather(T mather) {
        this.mather = mather;
    }
    public boolean addChild(T human) {

        if (!children.contains(human)) {
            children.add(human);
            return true;
        }
        return false;

    }
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public String getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(String dateDeath) {
        this.dateDeath = dateDeath;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPatronymic() {
        return null;
    }
}
