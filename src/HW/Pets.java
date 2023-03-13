package HW;

import java.util.List;

public class Pets extends FamilyMember{
    private String name;
    private String dateBirth;
    private String dateDeath;
    private Pets father;
    private Pets mather;
    private int age;
    private List<Pets> children;
    public Pets(String name, String dateBirth, String dateDeath) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        
    }
    public Pets(String name, String dateBirth, String dateDeath, Pets father, Pets mather, List<Pets> children) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mather = mather;
        this.children = children;
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
    public String getDateDeath() {
        return dateDeath;
    }
    public void setDateDeath(String dateDeath) {
        this.dateDeath = dateDeath;
    }
    public int getAge() {
        if (dateDeath != null) {
            return (Integer.parseInt(dateDeath.trim()) - Integer.parseInt(dateBirth.trim()));
        } else {
            return 2023 - Integer.parseInt(dateBirth.trim());
        }
    }
    public void setAge(int age) {
        this.age = age;
    }
    private String dateLife() {
        String res = ", Даты жизни: " + dateBirth + " - " + dateDeath;

        if (dateBirth == null && dateDeath == null) {
            res = ", Даты жизни: ... - ...";
        } else if (dateBirth != null && dateDeath == null) {
            res = ", Даты жизни: " + getDateBirth() + " - ...";
        } else if (dateBirth == null && dateDeath != null) {
            res = ", Даты жизни: ... - " + dateDeath;
        }
        return res;

    }
    @Override
    public String toString() {
        return "\n Домашние животные: " + name + ", даты жизни: " +  dateLife() + ", возраст " + getAge();
    }
    public Pets getFather() {
        return father;
    }
    public void setFather(Pets father) {
        this.father = father;
    }
    public Pets getMather() {
        return mather;
    }
    public void setMather(Pets mather) {
        this.mather = mather;
    }
    public List<Pets> getChildren() {
        return children;
    }
    public boolean addChild(Pets human) {

        if (!children.contains(human)) {
            children.add(human);
            return true;
        }
        return false;

    }
    public void setChildren(Pets pets, List<Pets> children) {
        pets.children = children;
    }

 

    

}
