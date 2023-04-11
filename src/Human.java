import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Human implements Serializable {

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
        children= new HashSet<>();
        this.birthDay = getBirthDay();
        this.firstName = firstName.toUpperCase();
        this.secondName = secondName.toUpperCase();
        this.patronymic = patronymic.toUpperCase();
        this.sex = sex.toLowerCase();
    }
    public Human(String firstName, String secondName, String patronymic) {
        this(null,firstName.toUpperCase(),secondName.toUpperCase(),patronymic.toUpperCase(),null);
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
    public String getFullName(){
        return secondName+" "+firstName+" "+patronymic;
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

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }
    public String getFatherInfo() {
        String temp = "отец:";
        if (father !=null){
            temp+=father.getFullName();
        }
        else{
            temp="";
        }
        return temp;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }
    public String getMotherInfo() {
        String temp = "мать:";
        if (mother !=null){
            temp+=mother.getFullName();
        }
        else{
            temp="";
        }
        return temp;
    }
    public void addChild(Human child)  {

            this.children.add(child);



    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        if (children.size() !=0){
            for (Human el:children) {
                sb.append(el.getFullName());
                sb.append(" ,");
            }
        }
        else {
            sb.append("");
        }
        return sb.toString();
    }


    public void setWifeOrHusband(Human wifeOrHusband) {
        this.wifeOrHusband = wifeOrHusband;
    }

    public Human getWifeOrHusband() {
        return wifeOrHusband;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(getFullName());
        sb.append(" ,");
        sb.append("год рождения: ");
        sb.append(birth_year);
        sb.append(" ,");
        sb.append(getFatherInfo());
        sb.append(" ,");
        sb.append(getMotherInfo());
        sb.append(" ,");
        sb.append("дети: ");
        sb.append(getChildrenInfo());
        return sb.toString();
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
                && Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,secondName,patronymic,birthDay);
    }
}
