import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    private Gender gender;
    private String birthDate;

    private String name;
    private String fatherName;

    public Human(String name, Gender gender, String birthDate) {
        this.gender = gender;
        this.birthDate = birthDate;
        this.name = name;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = format.parse(birthDate);
            this.birthDate = String.valueOf(birthDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Геттеры и сеттеры


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
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
}