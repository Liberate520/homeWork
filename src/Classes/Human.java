package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {


    private final Integer idHuman;
    private final String name;
    private final String surname;
    private final String surnameOld;
    private final Gender gender;
    private LocalDate brithDate;
    private final LocalDate deathDate;
    private final Human father;
    private final Human mother;
    private List<Human> children;

    public Human(Integer idHuman, String name, String surname, String surnameOld, Gender gender, LocalDate brithDate, LocalDate deathDate,
                 Human father, Human mother){
        this.idHuman =idHuman;
        this.name =name;
        this.surname = surname;
        this.surnameOld = surnameOld;
        this.gender = gender;
        this.brithDate = brithDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother =mother;
        ArrayList<Object> children = new ArrayList<>();
    }
    //TODO продумать конструктор
    //Тестовый вариант -проба перегрузки
    public Human(Integer idHuman, String name, String surname, String gender) {
        this(idHuman,name,surname,null,null,null,null,null,null);
    }
    //TODO addChild Добавлять ребенка
    // TODO getters

    public String getName() {return name;}

    //TODO setters
    public void  setBrithDate(LocalDate brithDate){this.brithDate = brithDate;}

    public String toString(){return getInfo();}
    public String getInfo(){
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("Персона: ");
        tmpSb.append(getName());

        return tmpSb.toString();
    }

}
