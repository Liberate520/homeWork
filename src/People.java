import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private String sex;
    private int age;
    private People father;
    private People mother;
    private List<People> children;

    public People(String name, String sex, int age, People father, People mother) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        children = new ArrayList<>();
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGend() {
        return sex;
    }

    public void setGend(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People getFather() {
        return father;
    }

    public void setFather(People father) {
        this.father = father;
    }

    public People getMother() {
        return mother;
    }

    public void setMother(People mother) {
        this.mother = mother;
    }

    public List<People> getChildren() {
        return children;
    }

    public void setChildren(List<People> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        String res = "\n" + name + ", " + sex + ", " + age + "";
        if (father != null) {
            res = res + ", father: " + father.getName();
        }
        if (mother != null) {
            res = res + ", mother: " + mother.getName();
        }
        return res;
    }
}