import java.lang.management.ThreadInfo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends Human{
    private LocalDate dateOfdDeath;
    private Person mather;
    private Person father;
    private Person spouse;
    private List<Person> children;


    public Person(String firstName, String lastName, String surName,
                  LocalDate dateOfBirth, LocalDate dateOfdDeath, Gender gender) {
        super(firstName, lastName, surName, dateOfBirth, gender);
        this.children = new ArrayList<>();
        this.dateOfdDeath = dateOfdDeath;
    }

    /**
     * Перегруженный конструктор на случай заранее известной даты смерти
     * @param firstName
     * @param lastName
     * @param surName
     * @param dateOfBirth
     */
    public Person(String firstName, String lastName,
                  String surName, LocalDate dateOfBirth, Gender gender) {
        super(firstName, lastName, surName,
                dateOfBirth, gender);
        this.children = new ArrayList<>();
        this.dateOfdDeath = null;
    }


    /**
     * Добавление информации о матери
     * @param mather ссылка на мать
     */
    public void setMather(Person mather) {
        this.mather = mather;
        mather.setChildren(this);
    }

    public Person getMather() {
        return mather;
    }

    /**
     * Добавление информации об отце с обновлением информации о ребенке
     * @param father ссылка на отца
     */
    public void setFather(Person father) {
        this.father = father;
        father.setChildren(this);
    }
    public Person getFather() {
        return father;
    }

    /**
     * Добавление ребенка
     * @param person
     */
    private void setChildren(Person person) {
        children.add(person);
    }

    /**
     * Получение списка детей
     * @return
     */
    public String getChildren(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей: " + this.getFullName() + "\n" + "\n");
        for (Person person: children) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        if (mather != null) {
            return super.toString() + "\nМать: " + mather.getFullName() + "\n" +
                    "Отец: " + father.getFullName() + "\n";
        } else {
            return super.toString() + "\nМать: нет данных \n" +
                    "Отец: нет данных \n";
        }
    }

    /**
     * Получение ФИО
     * @return
     */
    private String getFullName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLastName() + " " +
                this.getFirstName().toUpperCase().charAt(0) + ". " +
                this.getSurName().toUpperCase().charAt(0) + ".");
        return stringBuilder.toString();

    }

    /**
     * Задание даты смерти
     * @param dateOfdDeath
     */
    public void setDateOfdDeath(LocalDate dateOfdDeath) {
        this.dateOfdDeath = dateOfdDeath;
    }
    /**
     * Получение даты смерти
     * @return
     */
    public LocalDate getDateOfdDeath() {
        return dateOfdDeath;
    }


}
