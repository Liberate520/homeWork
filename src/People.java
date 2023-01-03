import java.util.ArrayList;
import java.util.List;

public class People {
    private String peopleName;
    private String sex;
    private int age;
    People father;
    People mother;
    List<People> children;
    
    public People(String name, String sex, int age, People father, People mother) {
        this.peopleName = name;
        this.sex = sex;
        this.age = age;
        children = new ArrayList<>();
        this.father = father;
        if(father != null) {
            father.children.add(this);
        }
        this.mother = mother;
        if(mother != null) {
            mother.children.add(this);
        }
    }

    public String getName() {
        return peopleName;
    }

    public void setName(String name) {
        this.peopleName = name;
    }

    public String getGender() {
        return sex;
    }

    public void setGender(String gender) {
        this.sex = gender;
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
        String res = "\n" + peopleName + " " + sex  + " " + age + " y.o.";
        if(father != null) {
            res = res + ", father: " + father.getName();
        }
        if(mother != null) {
            res = res + ", mother: " + mother.getName();
        }
        return res;
    }
}
