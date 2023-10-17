import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private List<Human> children;
    private Human mother;
    private Human father;


    public Human(int id, String name, Gender gender, LocalDate birthDay, Human mother, Human father){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();

    }
    public Human(int id, String name, Gender gender, LocalDate birthDay){
        this(id, name, gender, birthDay, null, null);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
//        System.out.println(children); //TODO пока вывод мне не нужен, но потом определиться
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

    @Override
    public String toString() { //TODO Доработать! Сделать универсальным и настроить вывод только имён детей
        if (mother != null || father !=null) {
            return "id: "+ id +", имя: " + name + ", пол: "+ gender + ", день рождения: " + birthDay + ", мать: " + mother.getName() +", отец: " + father.getName() + ", дети: " + children;
        }

        else if (children!=null) {
            return "id: "+ id +", имя: " + name + ", пол: "+ gender + ", день рождения: " + birthDay + ", мать: " +", отец: "+  ", дети: " + children;
        }
        else if (children!=null || mother == null) {
            return "id: "+ id +", имя: " + name + ", пол: "+ gender + ", день рождения: " + birthDay + ", мать: нет" +", отец: нет" + ", дети: " + children;
        }
        else return "id: "+ id +", имя: " + name + ", пол: "+ gender + ", день рождения: " + birthDay + ", мать: нет" + ", отец: нет" + ", дети: нет";

    }
}
