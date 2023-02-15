import java.io.*;
public class Person implements Serializable {

    private String name;
    private String sex;
    private Integer dateOfBirth;
    private Integer dateOfDeath;

    public Person (String name, String sex, Integer dateOfBirth, Integer dateOfDeath){
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Person (){
        this("Unkown","Unkown", 0, 0 );
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getDataOfDeath() {
        return dateOfDeath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDataOfDeath(Integer dataOfDeath) {
        this.dateOfDeath = dataOfDeath;
    }

    @Override
    public String toString() {
        return "\nPerson " +
                "name='" + name + "',\n" +
                "sex='" + sex + "',\n" +
                "dateOfBirth=" + dateOfBirth +"',\n"+
                "dateOfDeath=" + dateOfDeath +"'\n";
    }
}
