package Animal.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Animal.Animal;

/**
 * Класс ЧЕЛОВЕК
 */
public class Human implements Comparable<Human>, Animal<Human>, Serializable{
    private int ID;
    private String name;
    private DataLive data;
    private Gender gender;
    private Human father, mather, spouse;
    private List<Human> childrenList;

    //----------------Конструкторы класса--------------------------------
    /**
     * Конструктор класса Human
     * @param name Имя человека
     * @param year_bd Год рождения
     * @param m_bd Месяц рождения
     * @param day_bd День рождения
     * @param year_dd Год смерти
     * @param m_dd Месяц смерти
     * @param day_dd День смерти
     * @param gender Пол человека
     */
    public Human (String name, int year_bd, int m_bd, int day_bd, int year_dd,
                  int m_dd, int day_dd, Gender gender){
        this.ID = -1;
        this.name = name;
        this.data = new DataLive();
        data.setTimeLive(LocalDate.of(year_bd, m_bd, day_bd),LocalDate.of(year_dd, m_dd, day_dd));
        this.gender = gender;
        this.childrenList = new ArrayList<>();
    }
    public Human (String name, int year_bd, int m_bd, int day_bd, Gender gender){
        this.ID = -1;
        this.name = name;
        this.data = new DataLive(year_bd,m_bd,day_bd);
        this.gender = gender;
        this.childrenList = new ArrayList<>();
    }
    public Human(){
        this("человек", 12, 12, 12, Gender.Male);
    }
    public Human(String name){
        this(name, 12, 12, 12, Gender.Male);
    }

    //----------------Методы работы с личными данными--------------------
    /**
     * Метод присвоения ID человека
     * @param value ID
     */
    public void setId(int value) {
        this.ID = value;
    }
    
    /**
     * Метод возврата ID человека
     * @return ID
     */
    public int getId(){
        return this.ID;
    }

    /**
     * Метод задания имени человека
     * @param str имя
     */
    public void setName(String str) {
        this.name = str;
    }

    /**
     * Метод возвражающий имя человека
     * @return имя
     */
    public String getName(){
        return this.name;
    }

    public void setBirthday(LocalDate value){
        this.data
            .setBirthday(value);
    }

    public void setTimeLive(LocalDate value1, LocalDate value2){
        this.data
            .setTimeLive(value1, value2);
    }

    public LocalDate getBirthday(){
        return this.data.getBirthday();
    }

    public LocalDate getDayDed(){
        return this.data.getDayded();
    }

    public void setGender(Gender value){
        this.gender = value;
    }

    public void setGender(String value){
        switch (value) {
            case "м":
                this.gender = Gender.Male;
                break;
            
            case "М":
                this.gender = Gender.Male;
                break;
        
            case "ж":
                this.gender = Gender.Female;
                break;
            
            case "Ж":
                this.gender = Gender.Female;
                break;
        }
    }
   
    public Gender getGender(){
        return this.gender;
    }
    
    //----------------Методы работы с родственниками--------------------

    public void setFather(Human value){
        this.father = value;
    }

    public void setMather(Human value){
        this.mather = value;
    }

    public void setSpouse(Human value){
        this.spouse = value;
    }

    public Human getFather(){
        return this.father;
    }

    public Human getMather(){
        return this.mather;
    }

    public List<Human> getPerent(){
        List<Human> perents = new ArrayList<>();
        perents.add(this.father);
        perents.add(this.mather);
        return perents; 
    }

    public Human getSpouse(){
        return spouse;
    }

    public void addChildren(Human children){
        if (  (childrenList.contains(children) == false) 
            &&((children.getBirthday().getYear() - this.data.getBirthday().getYear()) > 18)){
            this.childrenList.add(children);
        }
    }

    public List<Human> getChildren(){
        return this.childrenList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ID+". Имя:"+ this.name);
        
        if (this.gender == Gender.Male){
            sb.append("; Пол:Муж. ");
        } else  sb.append("; Пол:Жен. ");
        
        sb.append(";"+ this.data);
        if (this.father != null) sb.append("; Отец: " + this.father.getName());
        if (this.mather != null) sb.append("; Мать: " + this.mather.getName());
        if (this.spouse != null) sb.append("; В браке");
        if (this.childrenList.size()>0) sb.append("; Детей: "+this.childrenList.size());
        sb.append(".");

        return sb.toString();
    }
    
    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
