

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private String lastName;
    private String thirdName;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate deathday;
    private Human mother;
    private Human father;

    private List<Human> childrenList;


    public Human(String name, String lastName, String thirdName,
                 Gender gender, LocalDate birthday, LocalDate deathday,
                 Human mother, Human father) {
        id = -1;
        this.name = name;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.gender = gender;
        this.birthday = birthday;
        this.deathday = deathday;
        this.mother = mother;
        this.father = father;
        childrenList = new ArrayList<>();
    }

    public Human(String name, String lastName, String thirdName, Gender gender, LocalDate birthday, LocalDate deathday){
        this(name, lastName, thirdName, gender, birthday, deathday, null, null);
    }

    public Human(String name, String lastName, String thirdName, Gender gender, LocalDate birthday, Human mother, Human father){
        this(name, lastName, thirdName, gender, birthday, null, mother, father);
    }

    public boolean addChild(Human child){
        if (!childrenList.contains(child)){
            childrenList.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDeathday() {
        return deathday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
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

    public List<Human> getParrents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Human> getChildrenList() {
        return childrenList;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", отчество: ");
        sb.append(thirdName);
        sb.append(", фамилия: ");
        sb.append(lastName);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", дата рождения: ");
        sb.append(getBirthday());
        sb.append(", дата смерти: ");
        sb.append(getDeathday());
        sb.append(getMotherInfo());
        sb.append(getFatherInfo());
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String people = ", мать: ";
        if (mother != null){
            people += mother.getName();
        } else {
            people += " Неизвестно";
        }
        return people;
    };

    public String getFatherInfo(){
        String people = ", отец: ";
        if (father != null){
            people += father.getName();
        } else {
            people += " Неизвестно";
        }
        return people;
    };

    public String getChildrenInfo(){
        StringBuilder people = new StringBuilder();
        people.append(", дети: ");
        if (!childrenList.isEmpty()){
            people.append(childrenList.get(0).getName());
            for (int i = 1; i < childrenList.size(); i++){
                people.append(", ");
                people.append(childrenList.get(i).getName());
            }

        } else {
            people.append(" Отсутствуют,");
        }
        return people.toString();
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}


