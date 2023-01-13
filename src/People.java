import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
// import java.time.Year;
// import java.util.Random;

public class People implements Serializable, Comparable<People> {
    private String name;
    private String sex;
    private int birthDate;
    private People father;
    private People mother;
    private List<People> children;

    public People(String name, String sex, int birthDate, People father, People mother) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        children = new ArrayList<>();
        this.father = (People) father;
        this.mother = (People) mother;
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

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
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

    public void addChild(People child) {
        this.getChildren().add(child);
    }

    // public static void addChild(Human human) {
    //     if (human.father != null) {
    //         human.father.childrenList.add(human);
    //     }
    //     if (human.mother != null) {
    //         human.mother.childrenList.add(human);
    //     }
    // }

    // private int generateNowDate() {
    //     int birthDate = Year.now().getValue();
    //     return birthDate;
    // }

    // private String getRandomSex() {
    //     Random random = new Random();
    //     int rnd = random.nextInt(0, 2);
    //     if (rnd == 0)
    //         return "female";
    //     else
    //         return "male";
    // }

    @Override
    public String toString() {
        String res = "\n" + name + ", " + sex + ", " + birthDate + "";
        if (father != null) {
            res = res + ", father: " + father.getName();
        }
        if (mother != null) {
            res = res + ", mother: " + mother.getName();
        }
        return res;
    }

    @Override
    public int compareTo(People o) {
        // 
        return name.compareTo(((People) o).getName());
    }
}