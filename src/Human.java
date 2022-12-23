import java.util.ArrayList;
import java.util.List;

public class Human {
    private String fullName;
    private Gender gender;
    private int age;
    private Human mother, father;
    private List<Human> children = new ArrayList<>();

    public Human(String fullName, Gender gender, int age, Human father, Human mother) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.father = father;
        this.mother = mother;
        this.addChild();
    }

    public void addChild(){
        if (father != null) {this.father.children.add(this);}
        if (mother != null) {this.mother.children.add(this);}
    }

    public Human(String fullName, Gender gender, int age) {
        this(fullName, gender, age, null, null);
    }

    public Human(String fullName, Gender gender, int age, Human human) {
            this(fullName, gender, age,
                    human.gender == Gender.Male ? human : null, human.gender == Gender.Female ? human : null);
    }

    public void setFather(Human father) {
        if (this.father == null) {
            this.father = father;
            this.father.children.add(this);
        } else {
            System.out.printf("У %s уже указан отец - %s", this.fullName, this.father.fullName);
        }
    }

    public void setMother(Human mother) {
        if (this.mother == null) {
            this.mother = mother;
            this.mother.children.add(this);
        } else {
            System.out.printf("У %s уже указана мать - %s", this.fullName, this.mother.fullName);
        }
    }

    public Human getFather() { return father;}

    public Human getMother() {
        return mother;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public List<Human> getSistersBrothers(){
        List<Human> byMother = this.getMother() != null ? this.getMother().getChildren() : null;
        List<Human> byFather = this.getFather() != null ? this.getFather().getChildren() : null;
        List<Human> all = new ArrayList<>();

        if (byFather != null) {
            for (Human human : byFather) {
                if (!human.getFullName().equals(this.fullName)) {
                    all.add(human);
                }
            }
        }

        if (byMother != null) {
            for (Human human : byMother) {
                if (!human.getFullName().equals(this.fullName)) {
                    all.add(human);
                }
            }
        }
        return all;
    }

    @Override
    public String toString() {
        String genString = gender == Gender.Male ? "муж." : "жен.";
        return  fullName + ", " + genString + ", " + age + " " + agePostfix(age);

    }

    enum Gender {
        Male,
        Female
    }

    private String agePostfix(int age) {
        int ageLastNumber = age % 10;
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);
        String old = "";

        if (ageLastNumber == 1)
            old = "год";
        else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
            old = "лет";
        else if(ageLastNumber >= 2 && ageLastNumber <= 4)
            old = "года";
        if (isExclusion)
            old = "лет";

        return old;
    }
}
