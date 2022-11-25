package Tree;

/**

 * Класс описывающий поля допустимые для Человека. Строковые поля:
 * fName - Имя
 * sName - Фамилия
 * patronymic - Отчество
 * bDate - Дата рождения
 * Имеет конструктор Person для установки значений полей в момент создания экземпляра класса;
 * Геттеры для всех полей;
 * Переопределен toString для отображения данных об экземпляре определенным образом.
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
    public Person(String surName, String firstName, String patronymic, String birthDate, Gender gender) {

        this.fName = firstName;
        this.sName = surName;
        this.patronymic = patronymic;
        this.bDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.fName;
    }

    public String setFirstName(String fName) {
        return fName;
    }

    public String getSurName() {
        return this.sName;
    }
    public String setSurName(String sName){
        return sName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }
    public String gsetPatronymic(String patronymic){
        return patronymic;
    }

    /**
     * @return // birthDate
     */
    public String getBirthDate() {
        return this.bDate;
    }
    public String setBirthDate(String bDate){
        return bDate;
    }

    /**
     * @return // gender
     */
    public Gender getGender() {
        return this.gender;
    }
    public Gender setGender(Gender gender){
        return gender;
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
