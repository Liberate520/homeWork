package homeWork;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
/**
 * Это класс Человек
 */
public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private GenderType sex;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int age;
    private String spouse;
    private String father;
    private String mother;

    private List<String> children;


public Human(String name, String surname, String patronymic, GenderType sex, int birthYear, int birthMonth, int birthDay, String spouse, String father, String mother )
{
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.sex = sex;
    this.birthYear = birthYear;
    this.birthMonth = birthMonth;
    this.birthDay = birthDay;
    this.age = getAge(birthYear, birthMonth, birthDay);
    this.spouse = spouse;
    this.father = father;
    this.mother = mother;

}
public int getAge(int birthYear, int birthMonth, int birthDay) {
    LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
    LocalDate currentDate = LocalDate.now();
    int age = Period.between(birthDate, currentDate).getYears();
    return age;
}
public String getName() {
    return name;
}

public String getSurname() {
    return surname;
}

public int getAge() {
    return age;
}

public GenderType getSex() {
    return sex;
}
public String getSpouse() {
    return spouse;
}

public String getFather() {
    return father;
}

public String getMother() {
    return mother;
}

private List<Child> child;

public void addChild(List<Child> listChild, Child name)
{
    this.child = listChild;
    this.child.add(name);
    // System.out.println
    // (this.name + " и " + this.spouse + "\n" +
    //  "Ребенок: \n" + name + "\n");
}


@Override
public String toString() {
    return  name + ' ' +  patronymic + ' '+ surname + ", " + sex + ", " + age + " лет" + ", супруг/а: " + spouse + ", отец: " + father + ", мать: " + mother;
}
public void allChildren()
    {
        System.out.println("Родитель: " + this.name + " " + this.surname + " " + this.patronymic + ", " + "количество детей: " + this.child.size());
        for (int i = 0; i < child.size(); i++) 
        {
            System.out.println("\n" + (i + 1) + " Ребенок: ");
            System.out.println(child.get(i));            
        }
    }

}
