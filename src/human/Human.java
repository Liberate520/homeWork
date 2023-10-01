package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Human implements Serializable {
    private long id;
    private String fstName;
    private String lstName;
    private LocalDate bornDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Human> childrens;
    private Human mother;
    private Human father;


    public Human(String fstName, String lstName, LocalDate bornDate, LocalDate deathDate,
                 Gender gender, Human mother, Human father) {
        id = -1;
        this.fstName = fstName;
        this.lstName = lstName;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        childrens = new ArrayList<>();
    }

    public Human(String fstName, String lstName, LocalDate bornDate, Gender gender, Human mother, Human father) {
        this(fstName, lstName, bornDate, null, gender, mother, father);
    }

    public Human(String fstName, String lstName, LocalDate bornDate, Gender gender) {
        this(fstName, lstName, bornDate, null, gender, null, null);
    }

    public Human(String fstName, String lstName, LocalDate bornDate, LocalDate deathDate, Gender gender) {
        this(fstName, lstName, bornDate, deathDate, gender, null, null);
    }

    public void addChild(Human child) {
        if (!childrens.contains(child)) {
            childrens.add(child);
        }
    }

    public void addParent(Human parent) {
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


    public String toString() {
        return info();
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(" Фамилия: ").append(fstName);
        sb.append(" Имя: ").append(lstName);
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
        Human human = (Human) obj;
        return human.getId() == getId();
    }

//    public int compareTo(Human human) {
//        return human.getId();
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFstName() {
        return fstName;
    }

    public void setFstName(String fstName) {
        this.fstName = fstName;
    }

    public String getLstName() {
        return lstName;
    }

    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Human> childrens) {
        this.childrens = childrens;
    }


    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Gender getGender() {
        return gender;
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}




