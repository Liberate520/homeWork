package homeWork_Oop.Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human {

   public List<String> fio;
   private Gender gender;
   private LocalDate birthday;
   private LocalDate dayOfDeath;
    private List<Human> parents;
    private List<Human> children;


    public Human(List<String> fio,Gender gender, LocalDate birthday,
                 LocalDate dayOfDeath, Human father, Human mother){
       this.fio = fio;
        this.gender = gender;
        this.birthday = birthday;
        this.dayOfDeath = dayOfDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
        this.children = new ArrayList<>();


    }
    public  Human(List<String> fio, Gender gender, LocalDate birthDate){
        this (fio, gender, birthDate, null, null, null);
    }
    public Human(List<String> fio, Gender gender, LocalDate birthDate,
                 Human father,Human mother){
        this (fio, gender, birthDate, null, father, mother);

    }
public List<Human> addChildren(Human child){
        if (!children.contains(child)){
        children.add(child);}
        return children;
        }

        public int getAge() {
            if (dayOfDeath == null) {
                return getPeriod(birthday, LocalDate.now());
            } else {
                return getPeriod(birthday, dayOfDeath);
            }
        }
        private int getPeriod(LocalDate birthday, LocalDate dayOfDeath){
        Period diff = Period.between(birthday,dayOfDeath);
        return  diff.getYears();
        }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();

        sb.append(" ФИО: ");
        sb.append(fio);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", вораст: ");
        sb.append(getAge());

//
        return sb.toString();
    }

    public static List<String> fioHumans(String name, String lastName, String soName){
//
        List<String> fio = new ArrayList<>();
        fio.add(name);
        fio.add(lastName);
        fio.add(soName);
        return  fio;
    }

    public  boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return  true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return fio == fio;
    }
    @Override
    public int hashCode() {
        return fio.get(0).hashCode() + 70*fio.get(1).hashCode() + 298*fio.get(2).hashCode();
    }

}


