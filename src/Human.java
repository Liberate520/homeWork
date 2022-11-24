import java.text.SimpleDateFormat;
import java.util.*;

public class Human {

    private String fullName;
    Character gender;
    Integer age;
    Date birthDate;
    Date deathDate;
    private Map<Human, Link> parents;
    private Map<Human, Link> childrens;
    private Map<Human, Link> nearCons;
    private Map<Human, Link> anotherAffinity;

//    private Map<Human, Link> wife;


    /**
     * @param birthDate строка формата "dd.MM.yyyy"
     */
    public Human(String fullName, Character gender, Integer age, String birthDate) {
        parents = new HashMap<>();
        childrens = new HashMap<>();
        nearCons = new HashMap<>();
        anotherAffinity = new HashMap<>();



        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.birthDate = ft.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Не верный формат даты");
//            this.birthDate = new Date(0);
        }

        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.deathDate = deathDate;
    }

    public Human(String fullName){
        this(fullName, 'N', 0, "01.01.0001");
    }


    public String getFullName() {
        return fullName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.birthDate = ft.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Не верный формат даты");
        }
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.deathDate = ft.parse(deathDate);
        } catch (Exception e) {
            System.out.println("Не верный формат даты");
        }
    }

    public Map<Human, Link> getParents() {
        return parents;
    }


    public void addParent(Human parent, Link link) {
        Map<Human, Link> linkTo = new HashMap<>();
        this.parents.put(parent, link);
    }

    public Map<Human, Link> getChildrens() {
        return childrens;
    }

    public void addChildren(Human children, Link link) {
        Map<Human, Link> linkTo = new HashMap<>();
        this.childrens.put(children, link);

    }

    public Map<Human, Link> getNearCons() {
        return nearCons;
    }

    public void addNearCons(Human cons, Link link) {
        Map<Human, Link> linkTo = new HashMap<>();
        this.nearCons.put(cons, link);
    }

    public void print(){

        System.out.println(
                String.format(
                        "fullName - %s \ngender - %c \nage - %d \nbirthDate - %te %<tB %<tY \ndeathDate - %te %<tB %<tY",
                        fullName,
                        gender,
                        age,
                        birthDate,
                        deathDate
                ));
        System.out.println(
                String.format(
                        "parents - %s \nchildrens - %s \nnearCons - %s",
                        parents.keySet(),
                        childrens.keySet(),
                        nearCons.keySet()

                ));
    }

//    public Map<Human, Link> getWife() {
//        return wife;
//    }
//
//    public void setWife(Human wife, Link link) {
//        this.wife = new HashMap<>();
//        this.wife.put(wife, link);
//    }
}
