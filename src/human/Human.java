package human;

import familyTree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyTreeItem<Human> {
    private String surname, name, patronymic;
    private Gender gender;
    private LocalDate birthDate, deathDate;
//    private Human father, mother;
    private List<Human> parents, children;
    //    private String placeOfBirth;
    //    private String location;
    private long id;
    private String fullName;
    //
    private int age;

    public Human(String surname, String name, String patronymic, Gender gender, LocalDate birthDate,
                 LocalDate deathDate, Human father, Human mother, int id) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
        this.id = id;
        this.age = getAge(birthDate, deathDate);
    }

    public Human(String surname, String name, String patronymic, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(surname, name, patronymic, gender, birthDate, deathDate, null, null, 0);
    }

    public Human(String surname, String name, String patronymic, Gender gender, LocalDate birthDate) {
        this(surname, name, patronymic, gender, birthDate, null, null, null, 0);
    }

    public Human(String surname, String name, String patronymic, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(surname, name, patronymic, gender, birthDate, null, father, mother, 0);
    }

    // ===========================================================
    @Override
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    @Override
    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            //TODO здесь ошибка у Константина
            parents.add(parent);// children.add(parent);
            return true;
        }
        return false;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getFullName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getFullName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getFullName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    // ===========================================================
    // Getting
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getPatronymic() {
        return patronymic;
    }

    public Gender getGender() {
        return gender;
    }
    @Override
    public LocalDate getBirthDate() {
        if (birthDate != null)
            return birthDate;
        else return null;
    }
    @Override
    public LocalDate getDeathDate() {
        if (deathDate != null)
            return deathDate;
        else return null;
    }

    private int getAge(LocalDate birthDate, LocalDate deathDate) {
        if (birthDate == null)
            return 0;
        else {
            if (deathDate == null)
                return Period.between(birthDate, LocalDate.now()).getYears();
            else
                return Period.between(birthDate, deathDate).getYears();
        }
    /*  if (birthDate != null) {
            int birthYear = birthDate.getYear();
            int birthMonth = birthDate.getMonthValue();
            int birthDay = birthDate.getDayOfMonth();

            if (deathDate == null) {
                LocalDate today = LocalDate.now();
                int todayYear = today.getYear();
                int todayMonth = today.getMonthValue();
                int todayDay = today.getDayOfMonth();

                if (birthMonth == todayMonth) {
                    if (todayDay >= birthDay) return todayYear - birthYear;
                    else return todayYear - birthYear - 1;
                }
                if (todayMonth > birthMonth) return todayYear - birthYear;
                else return todayYear - birthYear - 1;
            } else {
                int deathYear = deathDate.getYear();
                int deathMonth = deathDate.getMonthValue();
                int deathDay = deathDate.getDayOfMonth();

                if (birthMonth == deathMonth) {
                    if (deathDay >= birthDay) return deathYear - birthYear;
                    else return deathYear - birthYear - 1;
                }
                if (deathMonth > birthMonth) return deathYear - birthYear;
                else return deathYear - birthYear - 1;
            }
        } else return 0;
    */
    }
    @Override
    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }
    @Override
    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }
    @Override
    public List<Human> getParents() {
        return parents;
    }
    @Override
    public List<Human> getChildren() {
        return children;
    }
    @Override
    public long getId() {
        return id;
    }
    @Override
    public int getAge() {
        return age;
    }

    // Setting
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    //
    @Override
    public String getFullName() {
        return getSurname() + " " + getName() + " " + getPatronymic();
    }

    public void addChildren(Human human) {
        children.add(human);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id " + getId() + ", ");
        sb.append("ФИО: " + getFullName() + ", ");
        sb.append("Дата рождения: " + getBirthDate() + ", ");
        if (deathDate != null) {
            sb.append("Дата смерти: " + getDeathDate() + ", ");
        }
        sb.append("Возраст: " + age + ", ");
        sb.append(getMotherInfo() + ", ");
        sb.append(getFatherInfo() + ", ");
        sb.append(getChildrenInfo());
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
        return human.getName().equals(getName());
    }

//    @Override
//    public int compareTo(Human o) {
//        return fullName.compareTo(o.fullName);
//    }
}


