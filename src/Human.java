import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    // Описываем класс Human
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthDay;

    private LocalDate dateDeath;

    public List<Human> children;



    // Конструктор с детьми(списком)

    public Human(String name, String lastName, Gender gender, LocalDate birthDay,LocalDate dateDeath, List<Human> children) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.dateDeath = dateDeath;
        this.children = new ArrayList<>(children);


    }
    // Конструктор без детей по принципу DRY
    public Human(String name, String lastName, Gender gender, LocalDate birthDay,LocalDate dateDeath) {
        this(name,lastName,gender,birthDay,dateDeath ,new ArrayList<>(0));

    }

    // Геттеры для полей класса

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    // Переопределяем метод toString класса Human
    @Override
    public  String toString() {
        StringBuilder br = new StringBuilder();
        if(children.isEmpty()&&gender.equals(Gender.MALE))
        br.append("СЫН: ");
        else if (children.isEmpty()&&gender.equals(Gender.FEMALE))
            br.append("ДОЧЬ: ");
        else if(gender.equals(Gender.MALE))
           br.append("\n").append("СЫН: ");
        else
            br.append("\n").append("ДОЧЬ: ");

            br.append("имя: ")
                    .append(name)
                    .append(", фамилия: ")
                    .append(lastName)
                    .append(", возраст: ");
            if(dateDeath == null)
                    br.append(Period.between(birthDay,LocalDate.now()).getYears()).append(" лет ");
            else
                br.append("умер в количестве : ").append(Period.between(birthDay,dateDeath)).append(" лет");

                  br.append(",пол: ")
                    .append(gender);

        if(children.isEmpty())
            br.append(",дети: ").append("нет детей.");

        else
            br.append(",дети: ").append(getChildren());

        return br.toString();

    }

    }












