import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateOfBirth;

    private Person father;
    private Person mother;
    private List<Person> children;

    /**
     * Вспомогательный конструктор отвечающий за добавление личностей без известных
     * родственных связей
     */
    public Person(
            String name,
            String surname,
            String patronymic,
            LocalDate dateOfBirth) {
        this(name, surname, patronymic, dateOfBirth, null, null);
    }

    /**
     * Основной конструктор с добавление личностей имеющих известные родственные
     * связи.
     * 
     * Поля класса личности:
     * 
     * @param name        - имя;
     * @param surname     - фамилия;
     * @param patronymic  - отчество;
     * @param dateOfBirth - дата рождения;
     * @param father      - отец личности;
     * @param mother      - мать личности:
     */
    public Person(
            String name,
            String surname,
            String patronymic,
            LocalDate dateOfBirth,
            Person father,
            Person mother) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    // =============================================================================
    /**
     * Метод для проверки, добавлен наследник родителю, для предотращения
     * повторного закидывания его в список наследников.
     * 
     * Параметры:
     * 
     * @param child - наследник
     * @return - возвращает true или false
     */
    public boolean addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Сбор всей информации о личносте и возвращение ее для дальнейшей работы
     * с ней в виде строки
     * 
     * @return - toString
     */
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("\n===========ДАННЫЕ ЛИЧНОСТИ=========\n");
        info.append("имя: ");
        info.append(name);
        info.append("\n");
        info.append("фамилия: ");
        info.append(surname);
        info.append("\n");
        info.append("отчество: ");
        info.append(patronymic);
        info.append("\n");
        info.append(getMotherInfo());
        info.append("\n");
        info.append(getFatherInfo());
        info.append("\n");
        info.append(getChildrenInfo());
        info.append("\n===================================\n");
        
        return info.toString();
    }

    /**
     * Сбор данных о матери и возвращение их строкой
     * 
     * @return - toString
     */
    public String getMotherInfo() {
        StringBuilder stM = new StringBuilder();
        stM.append("мать: ");

        if (mother != null) {
            stM.append("\n");
            stM.append("имя: ");
            stM.append(mother.getName());
            stM.append("\n");
            stM.append("фамилия: ");
            stM.append(mother.getSurname());
            stM.append("\n");
            stM.append("отчество: ");
            stM.append(mother.getPatronymic());
            stM.append("\n");

        } else {
            stM.append("не установлена");
        }

        return stM.toString();
    }

    /**
     * Сбор данных об отце и возвращение их строкой
     * 
     * @return - toString
     */
    public String getFatherInfo() {
        StringBuilder stM = new StringBuilder();
        stM.append("отец: ");

        if (father != null) {
            stM.append("\n");
            stM.append("имя: ");
            stM.append(father.getName());
            stM.append("\n");
            stM.append("фамилия: ");
            stM.append(father.getSurname());
            stM.append("\n");
            stM.append("отчество: ");
            stM.append(father.getPatronymic());
            stM.append("\n");

        } else {
            stM.append("не установлен");
        }
        return stM.toString();
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!ПРОБЛЕМНОЕ МЕСТО, НАДО УТОЧНИТЬ!!!!!!!!!!!!!!!
    // iChil.append(children.get(0).getName()); - проблемная строка сложно понять,
    // как записать занесение данных имени, фамилии, отчества ребенка.

    /**
     * Сбор данных о наследниках и возвращение их строкой
     * 
     * @return - toString
     */
    public String getChildrenInfo() {
        StringBuilder iChil = new StringBuilder();
        iChil.append("дети: ");

        if (children.size() != 0) {
            iChil.append(children.get(0).getName());
            iChil.append(" ");
            iChil.append(children.get(0).getSurname());
            iChil.append(" ");
            iChil.append(children.get(0).getPatronymic());

            for (int i = 1; i < children.size(); i++) {
                iChil.append(", ");
                iChil.append(children.get(i).getName());
                iChil.append(" ");
                iChil.append(children.get(i).getSurname());
                iChil.append(" ");
                iChil.append(children.get(i).getPatronymic());
            }

        } else {
            iChil.append("нет");
        }

        return iChil.toString();
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!ПРОБЛЕМНОЕ МЕСТО, НАДО УТОЧНИТЬ!!!!!!!!!!!!!!!

    /**
     * Переопределение метода equals
     */
    @Override
    public boolean equals(Object obj) {
        /**
         * Проверка равенства ссылок для того чтобы убедиться, что это один и тот же
         * объект
         */
        if (this == obj) {
            return true;
        }

        /**
         * Проверка объекта, что он является объектом класса Person
         */
        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;

        return ((person.getName().equals(getName())) &&
                (person.getSurname().equals(getSurname())) &&
                (person.getPatronymic().equals(getPatronymic())));
    }
}
