import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Human {

    private String birthDay;
    private int birth_date;
    private int birth_month;
    private int birth_year;
    private Human father;
    private Human mother;
    private String sex;
    private Human wifeOrHusband;
    private Set<Human> children;
    private String firstName;
    private String secondName;
    private String patronymic;


    public Human(String birthDay, String firstName, String secondName, String patronymic, String sex) {
        convertDateFromStringToInt(birthDay);
        this.birthDay = getBirthDay();
        this.firstName = firstName.toUpperCase();
        this.secondName = secondName.toUpperCase();
        this.patronymic = patronymic.toUpperCase();
        this.sex = sex.toLowerCase();
    }
    private void convertDateFromStringToInt(String input){
        String[] tempString = input.split("[//.,]");
        this.birth_date = Integer.parseInt (tempString[0]);;
        this.birth_month = Integer.parseInt (tempString[1]);;
        this.birth_year = Integer.parseInt (tempString[2]);;
    }

    public String getBirthDay() {
        String bDay =  this.birth_date+"."+  this.birth_month+"."+ this.birth_year;
        return bDay;
    }

    public int getAge() {
        Date dt=new Date();
        int year=dt.getYear();
      return year-birth_year+1900;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setChildren(Human child)  {
        if (children == null){
            this.children= new HashSet<>();
            this.children.add(child);
        }
        else {
            this.children.add(child);
        }
        if (this.sex =="male"){
            setFather(child);
        }
        else {
            setMother(child);
        }

    }

    public Set<Human> getChildren() {
        return children;
    }


    public void setWifeOrHusband(Human wifeOrHusband) {
        this.wifeOrHusband = wifeOrHusband;
    }

    public Human getWifeOrHusband() {
        return wifeOrHusband;
    }


    @Override
    public String toString() {
        return secondName+ " " + firstName+" "
                + patronymic +", "
                + "год рождения: " + this.birth_year+"\n, "
                + "пол: " + this.sex +"\n, "
                + "дети: " + this.children +" "
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Human human =(Human) o;
        return Objects.equals(firstName, human.firstName)
                && Objects.equals(secondName, human.secondName)
                && Objects.equals(patronymic, human.patronymic) && Objects.equals(birthDay, human.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,secondName,patronymic,birthDay);
    }
}
