package family_tree.family_tree.model.human;

import family_tree.family_tree.model.GeneralTypeTree;
import family_tree.family_tree.model.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, GeneralTypeTree {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private List<Human> parents;
    private Human spouse;  // супруг

    public Human(String name, Gender gender, LocalDate birthDate,
                 LocalDate deathDate, Human father, Human mother){ // конструктор класса из 6 аргументов
        id = -1; // индификатор человека не являющийся еще частью чей-то семьи.
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
// создается перегрузка конструктора
    public Human(String name, Gender gender, LocalDate birthDate){

        this(name, gender, birthDate, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate,
                 Human father, Human mother){
        this(name, gender, birthDate, null, father, mother);
    }

    public Human(String name,LocalDate birthDate, LocalDate deathDate,  Gender gender){
        this.name=name;
        this.birthDate= birthDate;
        this.deathDate=deathDate;
        this.gender=gender;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }
    public Human(String name, LocalDate birthDate, Gender gender ){

        this( name, birthDate, null, gender);
    }


// конструктор HumanBuilder для new Human(maxId++, name, age)
//    public Human(int Id, String name, int age) {
//        this(Id, name, age);
//    }


    public boolean addChild(Human child){
        if (!children.contains(child)){  // проверка наличия ребенка
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }
    public void setMother(Human mother) {this.mother = mother; }
    public void setFather(Human father) {this.father = father; }
    public Human getMother() {return mother; }

    @Override
    public boolean addChild(Object human) {
        return false;
    }

    @Override
    public boolean addParent(Object human) {
        return false;
    }

    public Human getFather() {return father; }
//вспомогательный метод для дальнейшей возможной работы в цикле (получаем список родителей)
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2); //ожидание количества элементов в списке
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }
//метод рассчета возраста
    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public void setSpouse(Human spouse) { this.spouse = spouse; }
    public Human getSpouse() { return spouse; }

    @Override
    public void setSpouse(Object human) {

    }

    public String getName() { return name; }

    public long getId(){ return id; }
    public void setId(long id) {this.id = id; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public List<Human> getChildren() { return children; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate; }
    public Gender getGender() { return gender; }

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
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }
    public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

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

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name); // ?
//        return 0;
    }

// ????
//    @Override
//    public int compareTo(Human o){
//        return this.name.compareTo(o.name);
//    }
}
