package oop.familyTree.human;

import java.time.LocalDate;

public interface HumanNode {

    /**
     * Получение полного имени
     * @return String
     */
    String getFullName();

    /**
     * получение пола
     * @return String
     */
    String getGender();

    /**
     * Получение даты рождения
     * @return LocalDate
     */
    LocalDate getDateOfBirth();

    /**
     * Получение даты смерти
     * @return LocalDate
     */
    LocalDate getDateOfDeath();

    /**
     * Получение возраста
     * @return int
     */
    int getAge();

    /**
     * Получение имён супругов
     * @return String
     */
    String getSpouse();

    /**
     * Установка супруга
     *
     * @param str имя
     */
    void setSpouse(String str);

    /**
     * Получение имён детей
     * @return string
     */
    String getChildren();

    /**
     * Установка имён детей
     *
     * @param str имена
     */
    void setChild(String str);


}
