package Person;

import java.util.ArrayList;
import java.util.List;


public class Person implements Comparable<Person>{
    
    private String firstname;
    private String secondname;
    private String dateofbirth;
    private String alive;
    private String dateofdeath;
    private Person father;
    private Person mother;
    private List<Person> childrens = new ArrayList<>();

    
    /**
     * @param firstname Имя
     * @param secondname Фамилия
     * @param dateofbirth Дата рождения 
     * @param alive Жив или Мертв
     * @param dateofdeath Дата смерти
     * @param father Отец 
     * @param mother Мать 
     * @param childrens Дети
     */
    public Person(String firstname, String secondname, String dateofbirth, String alive, String dateofdeath, Person father, Person mother, List<Person> childrens){
        this.firstname = firstname;
        this.secondname = secondname;
        this.dateofbirth = dateofbirth;
        this.alive = alive;
        this.dateofdeath = dateofdeath;
        this.father = father;
        this.mother = mother;
        this.childrens = new ArrayList<>();
    }

    /**
     * @param firstname Имя
     * @param secondname Фамилия
     * @param dateofbirth Дата рождения 
     */
    public Person(String firstname, String secondname, String dateofbirth){
        this(firstname, secondname, dateofbirth, null, null, null, null, null);
    }
    
    /**
     * @param firstname Имя
     * @param secondname Фамилия
     */
    public Person(String firstname, String secondname){
        this(firstname, secondname, null, null, null, null, null, null);
    }
  
    /**
     * @return Имя Фамилия
     */
    public String getFullName(){
        return firstname + " " + secondname;
    }    

    /**
     * @return Имя
     */
    public String getFirstName() {
        return firstname;
    }

    /**
     * @return Фамилия
     */
    public String getSecondName() {
        return secondname;
    }

    /**
     * @return Дата рождения
     */
    public String getDateOfBirth() {
        return dateofbirth;
    }

    /**
     * @return Жив или мертв
     */
    public String getAlive() {
        return alive;
    }

    /**
     * @return Дата смерти
     */
    public String getDateOfDeath() {
        return dateofdeath;
    }

    /**
     * @return Мать
     */
    public Person getMother() {
        return mother; 
    }

    /**
     * @return Отец
     */
    public Person getFather() {
        return father;
    }

    /**
     * @param i Индекс списка дети (childrens)
     * @return Ребенок
     */
    public Person getChild(int i){
       return childrens.get(i);
    }

    /**
     * @return Список детей
     */
    public List<Person> getChildrens() {
        return childrens;
    }

    /**
     * @param firstname Имя
     * @return Задать Имя
     */
    public String setFirstName(String firstname){
        return this.firstname = firstname;
    }

    /**
     * @param secondname Фамилия 
     * @return Задать Фамилию
     */
    public String setSecondName(String secondname){
        return this.secondname = secondname;
    }

    /**
     * @param dateofbirth Дата рождения
     * @return Задать дату рождения
     */
    public String setDateOfBirth(String dateofbirth){
        return this.dateofbirth = dateofbirth;
    }

    /**
     * @param alive True == Жив, False == Мертв
     * @return Задать Жив или Жертв
     */
    public String setAlive(Boolean alive){
        if (alive == true){
            return this.alive = "Жив";
        }
        return this.alive = "Мертв";
    }

    /**
     * @param dateofdeath Дата смерти
     * @return Задать Дату смерти
     */
    public String setDateOfDeath(String dateofdeath){
        return this.dateofdeath = dateofdeath;
    }

    /**
     * @param person Человек
     * @return Задать мать
     */
    public Person setMother(Person person) {
        return this.mother = person;
    }

    /**
     * @param person Человек
     * @return Задать отца
     */
    public Person setFather(Person person) {
        return this.father = person;
    }

    /**
     * @param person Человек
     */
    public void addChild(Person person){
        childrens.add(person);
    }

    /**
     * @return Информация о человеке (Имя Фамилия, Мать, Отец, Дети)
     */
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstname);
        sb.append(" ");
        sb.append(secondname);
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    /**
     * @return Информация о матери человека
     */
    public String getMotherInfo(){
        String res = " Мать: ";
        if (mother != null){
            res += mother.getFullName();
        } else {
            res += "не известна";
        }
        return res;
    }

    /**
     * @return Информация об отце человека
     */
    public String getFatherInfo(){
        String res = " Отец: ";
        if (father != null){
            res += father.getFullName();
        } else {
            res += "не известен";
        }
        return res;
    }

    /**
     * @return информация о детях человека
     */
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(" Дети: ");
        if (childrens.size() != 0){
            res.append(childrens.get(0).getFullName());
            for (int i = 1; i < childrens.size(); i++) {
                res.append(", ");
                res.append(childrens.get(i).getFullName());
            }
        } else {
            res.append("нет или не известны");
        }
        return res.toString();
    }
    
   
    
    @Override
    public String toString() {
       return "Имя: " + this.firstname + " " + secondname
       + ". Дата рождения: " + dateofbirth + ". Живой: " + alive + ". Дата смерти: " + dateofdeath
       + ". " + getMotherInfo() + ". " + getFatherInfo() + ". " + getChildrenInfo();
    }
 
    @Override
    public int compareTo(Person person) {
        return getFullName().compareTo(person.getFullName());
    }

    
}