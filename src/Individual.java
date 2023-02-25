import java.util.ArrayList;
import java.util.List;

public class Individual {
    private String name;
    private Gender gender;
    private Integer yearofbirth;
    private Individual father;
    private Individual mother;
    private List<Individual> children;

    
    public Individual() {
    }


    public String getName() {
        return name;
    }

    public Integer getYearofbirth() {
        return yearofbirth;
    }

    
    public Individual getFather() {
        return father;
    }

    public Individual getMother() {
        return mother;
    }

    
    public void addChild(Individual individ) {
    }

    
    public String getInfo() {
        return String.format("Имя: %s; Пол: %s; Год рождения: %d; Отец: %s; Мать: %s.", name, gender, yearofbirth, getFatherInfo(), getMotherInfo());
    }   

    

}
