package Classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
//import static Classes.Gender.female;
//import static Classes.Gender.male;

public class Human implements Serializable,Comparable<Human> {


    private final Integer idHuman;
    private final String name;
    private final String surname;
    private final String surnameOld;
    private String patronymic;
    private final Gender gender;
    private LocalDate brithDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;
    private List<Human> parents;

    public Human(Integer idHuman, String surname, String surnameOld, String name, String patronymic,
                 Gender gender, LocalDate brithDate, LocalDate deathDate, Human father, Human mother) {
        this.idHuman = idHuman;
        this.name = name;
        this.surname = surname;
        this.surnameOld = surnameOld;
        this.patronymic = patronymic;
        this.gender = gender;
        this.brithDate = brithDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        ArrayList<Human> parents = new ArrayList<>();
        //    if (father != null){
        //        parents.add(father);}
        //    if (mother != null) {
        //        parents.add(mother);}
        ArrayList<Object> children = new ArrayList<>();

    }

    //TODO продумать конструкторы
    //Тестовый вариант -проба перегрузки
    public Human(Integer idHuman, String surname, String name, String patronymic, Gender gender) {
        this(idHuman, surname, null, name, null, gender, null, null, null, null);
    }

    public Human(Integer idHuman, String surname, String surnameOld, String name, String patronymic,
                 Gender gender, LocalDate brithDate, LocalDate deathDate) {
        this(idHuman, surname, surnameOld, name, patronymic, gender, brithDate, deathDate, null, null);
    }

    public boolean addChild(Human child) {
        if (children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parents.contains(parent)) {
            parent.add(parent);
            return true;
        }
        return false;
    }

    private void add(Human parent) {

    }

    public Integer getId() {
        return idHuman;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSurnameOld() {
        return surnameOld;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }


    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    //TODO setters
    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("Персона(");
        tmpSb.append(getId());
        tmpSb.append("): ");
        tmpSb.append(getFIO());
        tmpSb.append(" (");
        tmpSb.append(getGender());
        tmpSb.append(") ");
        tmpSb.append(getBrithDate());
        if (getDeathDate() != null) {
            tmpSb.append(" - ");
        }
        tmpSb.append(getDeathDate());
        tmpSb.append(" (лет= ");
        tmpSb.append(getAge());
        tmpSb.append(") ");
        tmpSb.append(getFatherInfo());
        tmpSb.append(" ");
        tmpSb.append(getMotherInfo());
        tmpSb.append(" ");
        tmpSb.append(getChildrenInfo());


        return tmpSb.toString();
    }


    public String getFIO() {
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append(getSurname());
        tmpSb.append(" ");
        tmpSb.append(getSurnameOldInfo());
        tmpSb.append(getName());
        tmpSb.append(" ");
        tmpSb.append(getPatronymic());
        tmpSb.append(" ");
        return tmpSb.toString();
    }

    public String getSurnameOldInfo() {
        StringBuilder tmpSb = new StringBuilder();
        if (getSurnameOld().equals("")==false) {
            tmpSb.append(" ( ");
            tmpSb.append(getSurnameOld());
            tmpSb.append(" ) ");
        }
        return tmpSb.toString();
    }

    public String getFatherInfo() {
        StringBuilder tmpSb = new StringBuilder();
        Human father = getFather();
        if (father != null) {
            tmpSb.append("\n");
            tmpSb.append("          Отец: ");
            tmpSb.append(father.getFIO());
        } else {
            tmpSb.append("Отец неизвестен");}
        return tmpSb.toString();
    }

    public String getMotherInfo() {
        StringBuilder tmpSb = new StringBuilder();
        Human mother = getMother();
        if (mother != null) {
            tmpSb.append("\n");
            tmpSb.append("          Мать: ");
            tmpSb.append(mother.getFIO());
        } else {
            tmpSb.append("Мать неизвестна");
        }
        return tmpSb.toString();
    }

    private String getChildrenInfo() {
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("Дети: ");
//            if (children.size()!=0){
//                tmpSb.append(children.get(0).getName());
//                for (int i=1;i<children.size();i++){
//                    tmpSb.append(", ");
//                    tmpSb.append(children.get(0).getName());}
//            }
//            else {tmpSb.append("отсутствуют ");}
        return tmpSb.toString();
    }

    private int getAge() {
        //    StringBuilder tmpSb = new StringBuilder();
        if (deathDate == null)
            return getPeriod(brithDate, LocalDate.now());
        else return getPeriod(brithDate, deathDate);
    }

    private int getPeriod(LocalDate brithDate, LocalDate deathDate) {
        Period diff = Period.between(brithDate, deathDate);
        return diff.getYears();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getSurname().equals(getSurname()) & human.getName().equals(getName()) & human.getBrithDate().equals(getBrithDate());
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
