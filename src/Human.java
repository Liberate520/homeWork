import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private String surName;
    private String fatherName;
    private Human mother;
    private Human father;
    private List<Human> childrens;
    private Gender gender;

    private Human(String name, String surName, String fatherName, Human mother, Human father,
            ArrayList<Human> childrens, Gender gender) {
        this.name = name;
        this.surName = surName;
        this.fatherName = fatherName;
        this.mother = mother;
        this.father = father;
        this.childrens = childrens;
        this.gender = gender;
    }

    public Human(String name, String surName, String fatherName, Human mother, Human father, Gender gender) {
        this(name, surName, fatherName, mother, father, new ArrayList<Human>(), gender);
    }

    public Human(String name, String surName, String fatherName, Gender gender) {
        this(name, surName, fatherName, null, null, new ArrayList<Human>(), gender);
    }

    public String getName() {
        return this.name;
    }

    public String getFullHumanInfo() {
        String genderString = this.gender.equals(Gender.Male) ? "мужской" : "женский";
        if (childrens.size() > 0) {
            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, мать - %s, отец - %s, дети - %s", this.surName, this.name,
                        this.fatherName, genderString, this.mother == null ? "нет" : this.mother,
                        this.father == null ? "нет" : this.father,
                        convertChildrensToString(this.childrens));
            } else {
                return String.format("%s %s, пол - %s, мать - %s, отец - %s, дети - %s", this.surName, this.name,
                        genderString, this.mother == null ? "нет" : this.mother,
                        this.father == null ? "нет" : this.father,
                        convertChildrensToString(this.childrens));
            }
        } else {

            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, мать - %s, отец - %s, детей нет", this.surName, this.name,
                        this.fatherName,
                        genderString, this.mother == null ? "нет" : this.mother,
                        this.father == null ? "нет" : this.father);
            } else {
                return String.format("%s %s, пол - %s, мать - %s, отец - %s, детей нет", this.surName, this.name,
                        genderString, this.mother == null ? "нет" : this.mother,
                        this.father == null ? "нет" : this.father);
            }
        }
    }

    public String getShortHumanInfo() {
        String genderString = this.gender.equals(Gender.Male) ? "мужской" : "женский";
        if (childrens.size() > 0) {
            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s", this.surName, this.name, this.fatherName, genderString);
            } else {
                return String.format("%s %s, пол - %s", this.surName, this.name, genderString);
            }
        } else {

            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s", this.surName, this.name,
                        this.fatherName, genderString);
            } else {
                return String.format("%s %s, пол - %s", this.surName, this.name,
                        genderString);
            }
        }
    }

    public String getFullName() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    public List<Human> getChildrens() {

        return this.childrens;
    }

    public String convertChildrensToString(List<Human> childrens) {
        int count = childrens.size();
        if (count > 0) {
            String result = "";
            for (int i = 0; i < childrens.size() - 1; i++) {
                result += childrens.get(i).getFullName() + ", ";
            }
            result += childrens.get(childrens.size() - 1).getFullName();
            return result;
        }
        return "детей нет";
    }

    public void showChildrenInfo() {
        System.out.println("\n" + getFullName().toUpperCase() + " ИНФОРМАЦИЯ О ДЕТЯХ");
        System.out.println(convertChildrensToString(this.childrens));
    }

    public Human getMother() {
        return this.mother;
    }

    public void addParent(Human human) {
        if (human.getGender().equals(Gender.Male)) {
            this.father = human;
        } else {
            this.mother = human;
        }
    }

    public void removeParent(Human human) {
        if (human.getGender().equals(Gender.Female) && this.mother.equals(human)) {
            this.mother = null;
        } else if (human.getGender().equals(Gender.Male) && this.father.equals(human)) {
            this.father = null;
        }
    }

    public Human getFather() {
        return this.father;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void addChildren(Human newHuman) {
        List<Human> childrens = getChildrens();
        if (!childrens.contains(newHuman)) {
            childrens.add(newHuman);
            this.childrens = childrens;
        }
    }

    public void removeChildren(Human newHuman) {
        List<Human> childrens = getChildrens();
        if (childrens.contains(newHuman)) {
            childrens.remove(newHuman);
            this.childrens = childrens;
        }
    }

    public String toString() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return this.getFullName().equals(human.getFullName());
    }
}
