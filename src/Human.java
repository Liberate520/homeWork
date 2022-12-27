import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private String surname;
    private int birth;
    private int death;
    private String gender;
    private Human mother;
    private Human father;
    private Human child;

    public Human(String name, String surname, int birth, int death, String gender) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.death = death;
        this.gender = gender;
    }

    public Human(Human child, Human father, Human mother) {
        this.child = child;
        this.father = father;
        this.mother = mother;
    }

    public void setChild(Human child) {
        this.child = child;
    }

    public Human getChild() {
        return child;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth, int death) {
        if (birth < death) {
            this.birth = birth;
        } else {
            System.out.println("Вы ввели не верный год");
        }
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death, int birth) {
        if (death > birth) {
            this.death = death;
        } else {
            System.out.println("Вы ввели неверный год");
        }
    }

    public String getGender() {
        return gender;
    }

    public void getByname(Human human, String name) {
        if (human.getName() == name) {
            System.out.println(human);
        }
    }

    public void getByWholive(Human human, int year) {
        if (human.getBirth() < year && human.getDeath() > year) {
            System.out.println(human);
        }
    }

    // @Override
    // public String toString() {
    //     return "Human [name=" + name + ", surname=" + surname + ", gender=" + gender + "]";
    // }

    
    
    // // @Override
    // // public String toString() {
    // //     return "Human [mother=" + mother + ", father=" + father + ", child=" + child + "]";
    // // }

    @Override
    public String toString() {
        return "Child " + child.name + ", surname=" + child.surname + ", mother=" + mother.name + " "
                + mother.surname + ", father=" + father.name + " " + father.surname + "]";
    }
    

}
