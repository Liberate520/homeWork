package human;

import tree.TreeCreaturable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Human implements Serializable, Comparable<Human>, TreeCreaturable<Human> {
    private String name;
    private String surname;
    private String patronymic;
    private Human mother;
    private Human father;
    private List<Human> childrenList;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Gender gender;
    private Human spouse;
    private List<Human> oldSpouse;
    private int id;
    private int age;
    static AtomicInteger nextId = new AtomicInteger();

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    public Human(String name, Gender gen, LocalDate birthDay, LocalDate deathDay) {
        this.name = name.split(" ")[1];
        this.surname = name.split(" ")[0];
        this.patronymic = name.split(" ")[2];
        this.gender = gen;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.childrenList = new ArrayList<>();
        id = nextId.incrementAndGet();

    }

    public Human(String name, Gender gen, LocalDate birthDay) {
        this.name = name.split(" ")[1];
        this.surname = name.split(" ")[0];
        this.patronymic = name.split(" ")[2];
        this.gender = gen;
        this.birthDay = birthDay;
        this.childrenList = new ArrayList<>();
        id = nextId.incrementAndGet();

    }

    public void setSpouse(Human spou) {
        this.spouse = spou;
    }

    public Human getSpouse() {
        return this.spouse;
    }

    public void addOldSpouse(Human hum) {
        if (this.oldSpouse == null) {
            this.oldSpouse = new ArrayList<>();
            this.oldSpouse.add(hum);
            this.spouse = null;
        } else this.oldSpouse.add(hum);
    }

    public String getOldSpouse() {
        StringBuilder sb = new StringBuilder();
        if (this.oldSpouse != null) {
            sb.append("Бывшие супруги: ");
            for (int i = 0; i < this.oldSpouse.size(); i++) {
                sb.append(this.oldSpouse.get(i).getFullName() + "; ");
            }
        } else sb.append("");
        return sb.toString();
    }

    public void setFullName(String name) {
        this.name = name.split(" ")[1];
        this.surname = name.split(" ")[0];
        this.patronymic = name.split(" ")[2];
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    public void setSurname(String name) {
        this.surname = name;
    }


    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMother(Human human) {
        this.mother = human;
    }

    public void setFather(Human human) {
        this.father = human;
    }

    public Human getMother() {
        return this.mother;
    }

    public Human getFather() {
        return this.father;
    }

    public List<Human> getChildrenList() {
        return childrenList;
    }

    public void addChild(Human child) {
        if (!childrenList.contains(child)) this.childrenList.add(child);
    }

    public String getFullName() {
        return this.surname + " " + this.name + " " + this.patronymic;
    }

    public LocalDate getBirthDay() {
        return this.birthDay;
    }

    public Gender getgGender() {
        return this.gender;
    }

    public LocalDate getDeathDay() {
        return this.deathDay;
    }

    @Override
    public String toString() {
        return "ID='" + id + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", mother=" + mother +
                ", father=" + father +
                ", childrenList=" + childrenList +
                ", birthDay=" + birthDay +
                ", deathDay=" + deathDay;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:" + this.id + "; ");
        sb.append(this.surname + " " + this.name + " " + this.patronymic + "; ");
        sb.append("Возраст: " + getAge() + "; ");
        sb.append("Пол: " + this.gender + "; ");
        sb.append(getSpouseInfo());
        sb.append(getOldSpouse());
        sb.append("Дети:");
        sb.append(childGetName());
        sb.append(" Мать: ");
        sb.append(getMa());
        sb.append(" Отец: ");
        sb.append(getFa());
        if (this.birthDay == null) sb.append("Дата рождения не установлена. ");
        else sb.append(" Дата Рождения: " + this.birthDay + "; ");
        if (this.deathDay != null) sb.append(" Дата смерти: " + this.deathDay + "; ");

        return sb.toString();
    }

    public String getSpouseInfo() {
        if (this.spouse == null) {
            if (this.gender == Gender.Man) return " не женат ";
            else return "Не замужем ";
        } else return "Супруг/супруга: " + this.spouse.getFullName() + "; ";
    }

    public String getMa() {
        String ma;
        if (this.mother == null) ma = "Нет информации; ";
        else ma = this.mother.getFullName();
        return ma;
    }

    public String getFa() {
        String fa;
        if (this.father == null) fa = "Нет информации; ";
        else fa = this.father.getFullName();
        return fa;
    }

    public String childGetName() {
        StringBuilder sb = new StringBuilder();
        if (childrenList.size() != 0) {
            for (Human child : this.childrenList) {
                sb.append(child.getFullName() + "; ");
            }
        } else sb.append("Отсутствуют; ");
        return sb.toString();
    }

    public int getAge() {
        if (this.deathDay == null) return LocalDate.now().getYear() - this.birthDay.getYear();
        else return this.deathDay.getYear() - this.birthDay.getYear();
    }

    public int getId() {
        return this.id;
    }

    public boolean equals(Human hum) {
        return (this.name == hum.name) && (this.surname == hum.surname) &&
                (this.patronymic == hum.patronymic) && (this.birthDay == hum.birthDay);
    }


}


