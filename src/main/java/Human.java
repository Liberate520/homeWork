import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Human mother;
    private Human father;
    private List<Human> childrenList = new ArrayList<>();
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Gender gender;
    private Human spouse;
    private int id;
    private int age;
    static AtomicInteger nextId = new AtomicInteger();

    public Human(String name, Gender gen, LocalDate birthDay, LocalDate deathDay) {
        this.name = name.split(" ")[1];
        this.surname = name.split(" ")[0];
        this.patronymic = name.split(" ")[2];
        this.gender = gen;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        id = nextId.incrementAndGet();

    }

    public Human(String name, Gender gen, LocalDate birthDay) {
        this.name = name.split(" ")[1];
        this.surname = name.split(" ")[0];
        this.patronymic = name.split(" ")[2];
        this.gender = gen;
        this.birthDay = birthDay;
        id = nextId.incrementAndGet();
        ;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;

    }

    public void setFullName(String name) {
        this.name = name.split(" ")[1];
        this.surname = name.split(" ")[0];
        this.patronymic = name.split(" ")[2];
    }

    public void setName(String name) {
        this.name = name;
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

    public StringBuilder getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:" + this.id + "; ");
        sb.append(this.surname + " " + this.name + " " + this.patronymic + "; ");
        sb.append("Возраст: " + getAge() + "; ");
        sb.append("Пол: " + this.gender + "; ");
        sb.append(getSpouse());
        sb.append("Дети:");
        sb.append(childGetName());
        sb.append(" Мать: ");
        sb.append(getMa());
        sb.append(" Отец: ");
        sb.append(getFa());
        if (this.birthDay == null) sb.append("Дата рождения не установлена. ");
        else sb.append(" Дата Рождения: " + this.birthDay + "; ");
        if (this.deathDay != null) sb.append(" Дата смерти: " + this.deathDay + "; ");

        return sb;
    }

    public String getSpouse() {
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

    public StringBuilder childGetName() {
        StringBuilder sb = new StringBuilder();
        if (childrenList.size() != 0) {
            for (Human child : this.childrenList) {
                sb.append(child.getFullName() + "; ");
            }
        } else sb.append("Отсутствуют; ");
        return sb;
    }

    public int getAge() {
        if (this.deathDay == null) return LocalDate.now().getYear() - this.birthDay.getYear();
        else return this.deathDay.getYear() - this.birthDay.getYear();
    }

    public boolean equals(Human hum) {
        return (this.name == hum.name) && (this.surname == hum.surname) &&
                (this.patronymic == hum.patronymic) && (this.birthDay == hum.birthDay);
    }
}
