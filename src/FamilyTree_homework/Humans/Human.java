package FamilyTree_homework.Humans;



import FamilyTree_homework.Family.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Human implements Serializable,Comparable<Human>, TreeNode<Human> {

    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;


    public Human(String name,Gender gender,LocalDate birthDate,LocalDate deathDate,Human father,Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public Human(String name,Gender gender,LocalDate birthDate){
        this(name,gender,birthDate, null, null, null);
    }
    public Human(String name,Gender gender,LocalDate birthDate,Human father,Human mother){
        this(name,gender,birthDate, null, father, mother);
    }
    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public Gender getGender(){
        return gender;
    }
    public Human getFather(){
        return father;
    }
    public void setFather(Human father){
        this.father = father;
    }
    public Human getMother(){
        return mother;
    }
    public void setMother (Human mother){
        this.mother = mother;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public List<Human> getChildren() {
        return children;
    }
    public List<Human> getParents () {
        List<Human> List = new ArrayList<>(2);
        if (father != null) {
            List.add(father);
        }
        if (mother != null) {
            List.add(mother);
        }
        return List;
    }
    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return false;
    }
    @Override
    public String toString(){
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
        sb.append(", дата рождения: ");
        sb.append(getBirthDate());
        sb.append(", : ");
        sb.append(getMotherInfo());
        sb.append(", : ");
        sb.append(getFatherInfo());
        sb.append(", : ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        Human mother = getFather();
        if (mother != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют: ");
        }
        return res.toString();
    }

    @Override
    public int compare(Human o1, Human o2) {
        return 0;
    }

    @Override
    public  boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public Comparator<Human> reversed() {
        return TreeNode.super.reversed();
    }

    @Override
    public Comparator<Human> thenComparing(Comparator<? super Human> other) {
        return TreeNode.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Human> thenComparing(Function<? super Human, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return TreeNode.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Human> thenComparing(Function<? super Human, ? extends U> keyExtractor) {
        return TreeNode.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Human> thenComparingInt(ToIntFunction<? super Human> keyExtractor) {
        return TreeNode.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Human> thenComparingLong(ToLongFunction<? super Human> keyExtractor) {
        return TreeNode.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Human> thenComparingDouble(ToDoubleFunction<? super Human> keyExtractor) {
        return TreeNode.super.thenComparingDouble(keyExtractor);
    }

    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }


}
