package model;

import model.tree.TreeItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends Human implements Comparable<Person>, TreeItem<Person> {
    private LocalDate dateOfdDeath;
    private Person mather;
    private Person father;
    private Person spouse;
    private List<Person> children;


    public Person(int id, String firstName, String lastName, String surName,
                  LocalDate dateOfBirth, LocalDate dateOfdDeath, Gender gender) {
        super(id, firstName, lastName, surName, dateOfBirth, gender);
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
    public Person(int id, String firstName, String lastName,
                  String surName, LocalDate dateOfBirth, Gender gender) {
        super(id, firstName, lastName, surName,
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
        if (mather != null && father != null) {
            return super.toString() + "\nМать: " + mather.getFullName() + "\n" +
                    "Отец: " + father.getFullName() + "\n";
        } else if(mather != null && father == null) {
            return super.toString() + "\nМать: " + mather.getFullName() + "\n" +
                    "Отец: нет данных \n";
        } else{
            return super.toString() + "\nМать: нет данных \n" +
                    "Отец: нет данных \n";
        }
    }

    /**
     * Получение ФИО
     * @return
     */
    public String getFullName(){
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


    @Override
    public int compareTo(Person o) {
        return getFirstName().compareTo(o.getFirstName());
    }
}
