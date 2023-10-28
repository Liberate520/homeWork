package HomeWork.familyTree.homeWork22_10_23.src.human;

import HomeWork.familyTree.homeWork22_10_23.src.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Конструктор
 * */
public class Human {
    private  long id;
    private String surname;
   private String name;
   private String patronymic;
   private LocalDate birthDay;
   private LocalDate dayOfDeath;
   private Gender gender;
   private Human mother;
   private Human father;
    private List<Human>children ;
    private Human spouse;

    public Human(String surname, String name, String patronymic, LocalDate birthDay, LocalDate dayOfDeath, Gender gender, Human mother, Human father, Human spouse) {
        id= -1;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.spouse = spouse;
    }

    public Human(String surname, String name, String patronymic, LocalDate birthDay, Gender gender) {
       this(surname, name, patronymic, birthDay,null, gender,null,null,null);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
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

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getAge(){
        if(dayOfDeath==null){
            LocalDate year = LocalDate.now();
            return year.minusYears(birthDay.getYear());
        }
        if(dayOfDeath!=null){
            LocalDate year = dayOfDeath;
            return year.minusYears(birthDay.getYear());
        }
            return null;
    }



        public boolean addChildren(Human human){
        if(!children.contains(human)){
            children.add(human);
            return true;
        }
        return false;
    }

    public List<Human>getParents(){
        List<Human> parentlist = new ArrayList<>(2);
        if (father!=null){
            parentlist.add(father);
        }
        if (mother!=null){
            parentlist.add(mother);
        }
        return parentlist;
    }
    public void addParent(Human human){
        if(human.getGender().equals(Gender.man)){
            setFather(human);
        }
        if (human.getGender().equals(Gender.woman)){
            setMother(human);
        }
    }
    public String getChildrenInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getSurname());
        stringBuilder.append(this.getName());
        if(this.gender == Gender.man){
            stringBuilder.append(" у него ");
        }
        if(this.gender==Gender.woman){
            stringBuilder.append(" у нее ");
        }

        int size = children.size();
        switch (size){
            case 1:
                stringBuilder.append(size).append(" ребенок : \n"); break;
            case 2:
            case 3:
            case 4:
                stringBuilder.append(size).append(" ребенка :\n"); break;
            default:stringBuilder.append(size).append(" детей :\n");break;
        }

        for (Human child : children) {
            stringBuilder.append(child.getSurname());
            stringBuilder.append(child.getName());
            stringBuilder.append(child.getPatronymic());
            stringBuilder.append(child.getAge().getYear());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public  String getParentInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getSurname());
        stringBuilder.append(this.getName());
        if(this.gender == Gender.man){
            stringBuilder.append(" у него : \n");
        }
        if(this.gender==Gender.woman){
            stringBuilder.append(" у нее :\n");
        }
        for (Human parent: getParents()){
            if(parent.gender==Gender.man){
                stringBuilder.append("отец ");
                stringBuilder.append(parent.getSurname());
                stringBuilder.append(parent.getName());
                stringBuilder.append(parent.getPatronymic());
                stringBuilder.append("\n");
            }else {
                stringBuilder.append("мать ");
                stringBuilder.append(parent.getSurname());
                stringBuilder.append(parent.getName());
                stringBuilder.append(parent.getPatronymic());
                stringBuilder.append("\n");
            }

        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDay=" + birthDay +
                ", dayOfDeath=" + dayOfDeath +
                ", gender=" + gender +
                ", mother=" + mother +
                ", father=" + father +
                ", childrenList=" + children +
                ", spouse=" + spouse +
                '}';
    }
}
