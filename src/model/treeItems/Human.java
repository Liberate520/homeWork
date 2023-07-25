package model.treeItems;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import model.treeItems.enums.Gender;
import model.treeItems.enums.LifeState;

public class Human implements Comparable<Human>, GenTreeItem, Serializable {
    private static int maxYearOfLife = 130;

    private int id = 0;
    private String firstName;
    private String midName;
    private String lastName;
    private Gender gender;
    private String strGender;

    private LocalDate birthDate = null;
    private LocalDate deathDate = null;
    private String strBirthDate = "UnknownBirthDate";
    private String strDeathDate = "UnknownDeathDate";
    private LifeState lifeState;

    private Human mother = null;
    private Human father = null;
    private int motherId = 0;
    private int fatherId = 0;

    // List интерфейсы для выполнения принципа OCP и DIP
    private List<Human> childs = new ArrayList<Human>();
    private List<Integer> childsIds = new ArrayList<Integer>();

    private int hierarchyLevel = 0;

    // конструктор
    public Human(String firstName,
                 String midName,
                 String lastName,
                 Gender gender) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.gender = gender;
        if (this.gender == Gender.man) {
            strGender = "мужчина";
        }
        else {
            strGender = "женщина";
        }
    }

    @Override
    public void setId(int id) {this.id = id;}

    @Override
    public int getId() {return id;}

    @Override
    public int getFatherId() {return fatherId;}

    @Override
    public int getMotherId() {return motherId;}

    @Override
    public Gender getGender() {return gender;}

    @Override
    public int getAge() {
        if (birthDate != null && deathDate != null) {
            return Period.between(birthDate, deathDate).getYears();
        }
        else if (birthDate != null && deathDate == null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return -1;
    }

    @Override
    public int getHierarchyLevel() {return hierarchyLevel;}

    @Override
    public void setHierarchyLevel(int level) {hierarchyLevel = level;}

    @Override
    public void setBirthDate(int day, int month, int year) throws Exception {
        LocalDate birthDate = LocalDate.of(year, month, day);
        if (this.deathDate != null && birthDate.isAfter(this.deathDate)) {
            throw new Exception("birthDate can not be after deathDate");
        }
        else {
            this.birthDate = birthDate;
            this.strBirthDate = dateToString(birthDate);
            if (Period.between(birthDate, LocalDate.now()).getYears() > maxYearOfLife) {
                lifeState = LifeState.dead;
            }
            else {
                if (deathDate == null) {
                    lifeState = LifeState.alive;
                }
            }
        }
    }

    @Override
    public void setDeathDate(int day, int month, int year) throws Exception {
        LocalDate deathDate = LocalDate.of(year, month, day);
        if (this.birthDate != null && deathDate.isBefore(this.birthDate)) {
            throw new Exception("deathDate can not be before birthDate");
        }
        else {
            this.deathDate = deathDate;
            this.strDeathDate = dateToString(deathDate);
            this.lifeState = LifeState.dead;
        }
    }

    public void changeFullName(String firstName,
                               String midName,
                               String lastName) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
    }

    public Human getMother() {
        return this.mother;
    }

    public Human getFather() {
        return this.father;
    }

    private void setMother(GenTreeItem mother) {
        this.mother = (Human)mother;
        motherId = mother.getId();
        mother.setHierarchyLevel(this.hierarchyLevel + 1);
        mother.addChild(this);
    }

    private void setFather(GenTreeItem father) {
        this.father = (Human)father;
        fatherId = father.getId();
        father.setHierarchyLevel(this.hierarchyLevel + 1);
        father.addChild(this);
    }

    @Override
    public void setParent(GenTreeItem parent) {
        if (parent instanceof Human) {
            if (parent.getGender() == Gender.man) {
                this.setFather(parent);
            }
            else {
                this.setMother(parent);
            }
        }
    }

    public List<Human> getChilds() {
        return childs;
    }

    @Override
    public List<Integer> getChildsIds() {
        return childsIds;
    }

    @Override
    public void addChild(GenTreeItem child) {
        if (child instanceof Human) {
            if (!(this.childs.contains((Human)child))) {
                this.childs.add((Human)child);
                this.childsIds.add(child.getId());
                child.setHierarchyLevel(this.hierarchyLevel - 1);
                child.setParent(this);
            }
        }
    }

    private String getStrListChilds() {
        StringBuilder sb = new StringBuilder();
        for (Human child: childs) {
            sb.append(child.toString() + "\n");
        }
        return sb.toString();
    }

    private String dateToString(LocalDate date) {
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        return String.format("%d.%d.%d", day, month, year);
    }

    private String datesInfo() {
        return strBirthDate + " - " + strDeathDate;
    }

    @Override
    public String toString() {
        return "id=" + id + " hl=" + hierarchyLevel + " " + getFullName() + " " + datesInfo();
    }

    @Override
    public String getFullName() {
        return firstName + " " + midName + " " + lastName;
    }

    @Override
    public String getFullInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------------------\n");
        sb.append(toString()).append(" (").append(getAge()).append(" лет) ");
        sb.append(strGender).append(" ");
        sb.append(lifeState);

        sb.append("\nОтец: ");
        if (father == null) {sb.append("unknown");}
        else {sb.append(father.getFullName());}

        sb.append("\nМать: ");
        if (mother == null) {sb.append("unknown");}
        else {sb.append(mother.getFullName());}

        sb.append("\nДети:\n");
        sb.append(getStrListChilds());
        sb.append("-----------------------------------------------------\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human other = (Human)obj;
        return this.id == other.id &&
               this.firstName.equals(other.firstName) &&
               this.midName.equals(other.midName) &&
               this.lastName.equals(other.lastName) &&
               this.gender == other.gender;
    }

    // если не используются классы-компараторы, то этот метод служит для сортировки по умолчанию
    // переопределение из интерфейса Comparable
    @Override
    public int compareTo(Human other) {
        // нужно вернуть положительный инт если первый объект больше второго
        if (this.hierarchyLevel > other.hierarchyLevel) {
            return 1;
        }
        // нужно вернуть отрицательный инт если первый объект меньше второго
        else if (this.hierarchyLevel < other.hierarchyLevel) {
            return -1;
        }
        // если равны - вернуть 0
        return 0;
        // иначе говоря:
        // return this.hierarchyLevel - other.hierarchyLevel;
    }
}