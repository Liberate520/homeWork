package Tree;
/**
 * Класс описывающий Человека
 * с полями fName - имя, sName - фамилия,  patronymic - отчество,  bData - дата рождения, gender - пол
 */
public class Person {
    private final String fName;
    private final String sName;
    private final String patronymic;
    private final String bDate;
    private final Gender gender;

    /**
     * Конструктор - создание нового объекта
     */
    public Person(String firstName, String surName,String patronymic, String birthDate, Gender gender) {
        this.fName = firstName;
        this.sName = surName;
        this.patronymic = patronymic;
        this.bDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.fName;
    }

    public String getSurName() {
        return this.sName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    /**
     * @return // birthDate
     */
    public String getBirthDate() {
        return this.bDate;
    }

    /**
     * @return // gender
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Переопределение вывода экземпляра на печать в виде "Имя Фамилия Дата рождения Пол"
     */
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", getSurName(), getFirstName(), getPatronymic(),
                getBirthDate(), getGender());
    }
}
