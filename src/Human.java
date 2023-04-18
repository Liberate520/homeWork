import java.util.ArrayList;
import java.util.List;

public class Human {
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

    public String GetName() {
        return this.name;
    }

    public String GetFullHumanInfo() {
        String genderString = this.gender.toString().toLowerCase();
        if (childrens.size() > 0) {
            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, мать - %s, отец - %s, дети - %s", this.surName, this.name,
                        this.fatherName, genderString, this.mother == null ? "нет" : this.mother,
                        this.father == null ? "нет" : this.father,
                        ConvertChildrensToString(this.childrens));
            } else {
                return String.format("%s %s, пол - %s, мать - %s, отец - %s, дети - %s", this.surName, this.name,
                        genderString, this.mother == null ? "нет" : this.mother,
                        this.father == null ? "нет" : this.father,
                        ConvertChildrensToString(this.childrens));
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

    public String GetShortHumanInfo() {
        String genderString = gender.toString().toLowerCase();
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

    public String GetFullName() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    public List<Human> GetChildrens() {

        return this.childrens;
    }

    public String ConvertChildrensToString(List<Human> childrens) {
        int count = childrens.size();
        if (count > 0) {
            String result = "";
            for (int i = 0; i < childrens.size() - 1; i++) {
                result += childrens.get(i).GetFullName() + ", ";
            }
            result += childrens.get(childrens.size() - 1).GetFullName();
            return result;
        }
        return "детей нет";
    }

    public void ShowChildrensInfo() {
        System.out.println("\n" + GetFullName().toUpperCase() + " ИНФОРМАЦИЯ О ДЕТЯХ");
        System.out.println(ConvertChildrensToString(this.childrens));
    }
    
    public Human GetMother() {
        return this.mother;
    }

    public void CheckChildrenRelation(Human human) {
        if (!this.childrens.contains(human)) {
            AddChildren(human);
        }

    }
    
    public void CheckParentsRelationAdd(Human human) {
        if (human.GetGender().equals(Gender.МУЖСКОЙ)) {
            this.father=human;
        } else {
            this.mother=human;
        }
    }

    public void CheckParentsRelationRemove(Human human) {
        if (human.GetGender().equals(Gender.ЖЕНСКИЙ) && this.mother.equals(human)) {
            this.mother=null;
        } else if (human.GetGender().equals(Gender.МУЖСКОЙ) && this.father.equals(human)) {
            this.father=null;
        }
    }
    
    public Human GetFather() {
        return this.father;
    }

    public Gender GetGender() {
        return this.gender;
    }

    public void AddChildren(Human newHuman) {
        List<Human> childrens = GetChildrens();
        if (!childrens.contains(newHuman)) {
            childrens.add(newHuman);
            this.childrens=childrens;
        }
    }

    public void RemoveChildren(Human newHuman) {
        List<Human> childrens = GetChildrens();
        if (childrens.contains(newHuman)) {
            childrens.remove(newHuman);
            this.childrens=childrens;
        }
    }

    public String toString() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

}
