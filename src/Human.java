import java.util.ArrayList;
import java.util.List;
public class Human implements Humanable{

    private String fio;
    private int yearBirth;
    private int yearDeath;
    private Gender gender;

    public String getFio() {
        return this.fio;
    }

    public void setFio(String fio) {
    this.fio=fio;
    }


    public int getYearBirth() {
        return this.yearBirth;
    }


    public void setYearBirth(int yearBirth) {
    this.yearBirth=yearBirth;
    }


    public int getYearDeath() {
        return this.yearDeath;
    }


    public void setYearDeath(int yearDeath) {
    this.yearDeath=yearDeath;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public void setGender(Gender gender) {
    this.gender = gender;
    }
}
