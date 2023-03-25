public class Human {
    String fio;
    int yearBirth;
    Gender gender;
    Human father;
    Human mother;
    Human children;

    public Human(int yearBirth, String fio, Human father, Human mother) {
        this.fio = fio;
        this.yearBirth = yearBirth;
        this.father = father;
        this.mother = mother;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }


    public Human getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children = children;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
