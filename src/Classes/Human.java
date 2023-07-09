package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {


    private final Integer idHuman;
    private final String name;
    private final String surname;
    private final String surnameOld;
    private String patronymic;
    private final Gender gender;
    private LocalDate brithDate;
    private final LocalDate deathDate;
    private final Human father;
    private final Human mother;
    private List<Human> children;

    public Human(Integer idHuman,String surname,String surnameOld, String name, String patronymic,
                 Gender gender, LocalDate brithDate, LocalDate deathDate, Human father, Human mother){
        this.idHuman =idHuman;
        this.name =name;
        this.surname = surname;
        this.surnameOld = surnameOld;
        this.patronymic = patronymic;
        this.gender = gender;
        this.brithDate = brithDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother =mother;
        ArrayList<Object> children = new ArrayList<>();
    }
    //TODO продумать конструктор
    //Тестовый вариант -проба перегрузки
    public Human(Integer idHuman, String surname, String name, String patronymic, Gender gender) {
        this(idHuman,surname,null, name,null,gender,null,null,null,null);
    }
    //TODO addChild Добавлять ребенка
    // TODO getters

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getSurnameOld() {return surnameOld;}
    public String getPatronymic() {return patronymic;}
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
