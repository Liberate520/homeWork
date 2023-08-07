package ru.gb.Tree.Human;
import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> childrenList;
    private Human spouse;
   


    public Human (String name, Gender  gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        childrenList = new ArrayList<>();
    }

    public Human (String name, Gender  gender, LocalDate birthDate, Human mother, Human father){
        this(name, gender, birthDate, null, mother, father);
    }

    public Human (String name, Gender  gender, LocalDate birthDate, LocalDate deathDate){
        this(name, gender, birthDate, deathDate, null, null);
    }

    public Human (String name, Gender  gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }
    
    
    
    public void addToChildren(Human child){
    //    if (!childrenList.contains(child)); // проверка списка на присутствие, изучить позже !!!
            childrenList.add(child);
    }

     public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (childrenList.size() != 0){
            res.append(childrenList.get(0).getName());
            for (int i = 1; i < childrenList.size(); i++) {
                res.append(", ");
                res.append(childrenList.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public List<Human> getChildrenList() {
        return childrenList;
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

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
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
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getName() {
        return name;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }

    public static LocalDate getBirthDate (int year, int month, int day) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        return birthDate;
     }

    public static LocalDate getDeathDate (int year, int month, int day) {
        LocalDate deathDate = LocalDate.of(year, month, day);
        return deathDate;
     }
    
    public Gender getGender() {
        return gender;
    }
   
    public List<Human> getChildren() {
        return childrenList;
    }

    // public String getAge(LocalDate birthDate, LocalDate deathDate){   // работает, но может быть неудобно в будущем, т.к. age в String
    //     LocalDate today = LocalDate.now();
    //     String ageStr = "";
    //     if (deathDate == null){
    //         int age = today.getYear() - birthDate.getYear();
    //         ageStr = Integer.toString(age);
    //     }else {
    //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    //         String birth = birthDate.format(formatter);
    //         String death = deathDate.format(formatter);
    //         ageStr = birth + " - " + death;
    //     }
    //     return ageStr;
    // }

    public int getAge(LocalDate birthDate, LocalDate deathDate){
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();
        return age;
    }
      
    public String getInfo(){
        StringBuilder stringBuilderHuman = new StringBuilder();
        stringBuilderHuman.append("имя: ");
        stringBuilderHuman.append(name);
        stringBuilderHuman.append(", пол: ");
        stringBuilderHuman.append(getGender());
        if (deathDate != null){
            stringBuilderHuman.append(", годы жизни: ");
            stringBuilderHuman.append(birthDate +" - " + deathDate);
        }
        else {
            stringBuilderHuman.append(", родился: " + birthDate);
            stringBuilderHuman.append(", возраст: ");
            stringBuilderHuman.append(getAge(birthDate, deathDate));
        }
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getSpouseInfo());
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getMotherInfo());
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getFatherInfo());
        stringBuilderHuman.append(", ");
        stringBuilderHuman.append(getChildrenInfo());
        return stringBuilderHuman.toString();
    }
    
    @Override
    public String toString(){
        return getInfo();
    }


    // @Override                                // проверка списка на присутствие, изучить позже!!!
    // public boolean equals(Object obj) {
    //     if (this == obj){
    //         return true;
    //     }
    //     if (!(obj instanceof Human)){
    //         return false;
    //     }
    //     Human human = (Human) obj;
    //     return human.getId() == getId();
    // }

}
