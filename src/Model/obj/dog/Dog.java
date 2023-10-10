package Model.obj.dog;

import Model.familyTree.FamilyTreeItem;
import Model.obj.Gender;
import Model.obj.human.Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Dog implements Comparable<Dog>, FamilyTreeItem<Dog> {
    private long id;
    private Human human;
    private String fstName;
    private String lstName;
    private Gender gender;
    private LocalDate bornDate;
    private LocalDate deathDate;
    private List<Dog> childrens;
    private Dog mother;
    private Dog father;


    public Dog(Human human, String fstName,String lstName, Gender gender, LocalDate bornDate, LocalDate deathDate, Dog mother, Dog father) {
        id = -1;
        this.human = human;
        this.fstName = fstName;
        this.lstName = lstName;
        this.gender = gender;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        childrens = new ArrayList<>();
    }

    public Dog(Human human, String fstName,String lstName, Gender gender, LocalDate bornDate, LocalDate deathDate) {
        this(human,fstName,lstName, gender, bornDate, deathDate,null,null);
    }

    public Dog(Human human, String fstName,String lstName, Gender gender, LocalDate bornDate) {
        this(human,fstName,lstName, gender, bornDate, null,null,null);
    }

    public Dog(Human human, String fstName, Gender gender, LocalDate bornDate) {
        this(human,fstName,null, gender, bornDate, null,null,null);
    }

    public Dog(String fstName,String lstName, Gender gender, LocalDate bornDate) {
        this(null,fstName,lstName, gender, bornDate, null,null,null);
    }

    public void addChild(Dog child) {
        if (!childrens.contains(child)) {
            childrens.add(child);
        }
    }

    public void addParent(Dog parent) {
        if (parent.getGender().equals(Gender.MALE)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.FEMALE)) {
            setMother(parent);
        }
    }

    public int getAge() {
        if (deathDate == null) {
            return lifePeriod(bornDate, LocalDate.now());
        } else {
            return lifePeriod(bornDate, deathDate);
        }
    }

    private int lifePeriod(LocalDate birthDate, LocalDate deathDate) {
        Period difference = Period.between(birthDate, deathDate);
        return difference.getYears();
    }

    public String getMotherInfo() {
        String res = " Мама: ";
        if (mother != null) {
            res += mother.getFstName() + " " + mother.getLstName();
        } else {
            res += "Неизвестно";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = " Папа: ";
        if (father != null) {
            res += father.getFstName() + " " + father.getLstName();
        } else {
            res += "Неизвестно";
        }
        return res;
    }

    public String getHumanInfo() {
        String res = " Xозяин: ";
        if (human != null) {
            res += human.getFstName() + " " + human.getLstName();
        } else {
            res += "Неизвестно";
        }
        return res;
    }


    public String toString() {
        return info();
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(getHumanInfo()).append(" ");
        sb.append(" Кличка(Имя): ").append(fstName);
        sb.append(" Фамилия: ").append(lstName);
        sb.append(" Пол: ").append(gender);
        sb.append(" ДР: ").append(bornDate);
        sb.append(" ДС: ").append(deathDate);
        sb.append(getMotherInfo()).append(" ");
        sb.append(getFatherInfo()).append(" ");
        sb.append(" Возраст: ").append(getAge());

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Dog dog = (Dog) obj;
        return human.getId() == getId();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getFstName() {
        return fstName;
    }

    @Override
    public void setFstName(String fstName) {
        this.fstName = fstName;
    }

    @Override
    public String getLstName() {
        return lstName;
    }

    @Override
    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Dog> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Dog> childrens) {
        this.childrens = childrens;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public Dog getMother() {
        return mother;
    }

    @Override
    public void setMother(Dog mother) {
        this.mother = mother;
    }

    @Override
    public Dog getFather() {
        return father;
    }

    @Override
    public void setFather(Dog father) {
        this.father = father;
    }


    public int compareTo(Dog o){
        return fstName.compareTo(o.getFstName());
    }
}
