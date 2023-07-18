import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.List;

public class Person extends Human{
    private int yearOdDeath;
    private Person mather;
    private Person father;
    private Person spouse;
    private List<Person> children;


    public Person(String firstName, String lastName, String surName, int yearOfBirth) {
        super(firstName, lastName, surName, yearOfBirth);
        this.children = new ArrayList<>();
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
            return super.toString() + "Мать: " + mather.getFullName() + "\n" +
                    "Отец: " + father.getFullName() + "\n";
        } else {
            return super.toString() + "Мать: нет данных \n" +
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

}
