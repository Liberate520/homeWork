package faminly_tree.model.human;

import faminly_tree.model.tree.FamiliItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Думаю, что стоит оставить внутри класса только создание самого объекта типа человек (в соответствии с 1ым принципом),
//потому что сейчас класс так же решает задачи составления взаимосвязи между людьми, // которую мог бы взять на себя,
//например, класс Connection. Так же выделить в отдельный класс методы передачи информации (все методы типа getInfo),
//а возможно даже и в интерфейсы, потому что похожие методы реализует FamilyTree, тут надо будет проверять на 4ый принцип SOLID.

//Так же здесь нарушается принцип разделения интерфейсов. Сейчас программа написана таким образом, что она вообще не
// записывает и не читает объекты типа Human - это просто не нужно, потому что программа работает с деревом и,
// при необходимости достанет человека из сохраненного дерева. Следовательно для Human не нужен интерфейс Serializable
public class Human implements Serializable, FamiliItem {
    private int id;
    private String name, surname, patronymic;
    private Gender gender;
    private LocalDate birth, death;
    private Human mother, father;
    private List<Human> children;
    private int age;

    public Human(String name, String surname, String patronymic, Gender gender, LocalDate birth, LocalDate death) {
        this.id = -1;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.age = getAge(birth, death);
    }
    public Human(String name, String surname, String patronymic, Gender gender, LocalDate birth) {
        this(name, surname, patronymic, gender, birth, null);
    }
    public Human(String name, Gender gender, LocalDate birth) {
        this(name, null, null, gender, birth, null);
    }
    public Human(String name, Gender gender, LocalDate birth, LocalDate death) {
        this(name, null, null, gender, birth, death);
    }

    /**
     * Определение возраста по дате смерти, если она есть или по текущей дате
     *
     * @param birth дата рождения
     * @param death дата смерти
     * @return
     */
    private int getAge(LocalDate birth, LocalDate death) {
        if (birth == null) return 0;
        int age;
        int birthYear = birth.getYear();
        int birthMonth = birth.getMonthValue();
        int birthDay = birth.getDayOfMonth();
        if (death == null) {
            LocalDate date = LocalDate.now();
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            if (birthMonth == month) {
                if (day >= birthDay) age = year - birthYear;
                else age = year - birthYear - 1;
            }
            if (month > birthMonth) age = year - birthYear;
            else age = year - birthYear - 1;
        } else {
            int deathYear = death.getYear();
            int deathMonth = death.getMonthValue();
            int deathDay = death.getDayOfMonth();
            if (birthMonth == deathMonth) {
                if (deathDay >= birthDay) age = deathYear - birthYear;
                else age = deathYear - birthYear - 1;
            }
            if (deathMonth > birthMonth) age = deathYear - birthYear;
            else age = deathYear - birthYear - 1;
        }
        return age;
    }

    /**
     * Определение взаимосвязи ребенок-родитель
     *
     * @param human родитель
     */
    public void childFor(Human human) {
        if (human.gender == Gender.Male) {
            this.setFather(human);
        } else {
            this.setMother(human);
        }
        List<Human> children = human.getChildren();
        if (children == null) {
            children = new ArrayList<>();
            children.add(this);
        } else children.add(this);
        human.setChildren(children);
    }

    //TODO метод брака
    //TODO метод развода
    //TODO метод смерти

    //Методы вывода информации с исп. toString
    @Override
    public String toString() {
        return getInfo();
    }
    private String motherGetInfo() {
        StringBuilder sb = new StringBuilder();
        if (this.getMother() != null) sb.append(this.getMother().getName());
        else sb.append("неизвестна");
        return sb.toString();
    }
    private String fatherGetInfo() {
        StringBuilder sb = new StringBuilder();
        if (this.getFather() != null) sb.append(this.getFather().getName());
        else sb.append("неизвестен");
        return sb.toString();
    }
    private String childrenGetInfo(){
        StringBuilder sb = new StringBuilder();
        List<Human> children = this.getChildren();
        if (children == null) sb.append("нет");
        else {
            for(Human el : children){
                sb.append(el.getName());
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    //Метод нарушает 2ой принцип SOLID - открытость/закрытость. Если будут добавляться поля (например "супруг(а)"),
    //то придется изменять реализацию этого метода. Как я писала в начале класса, возможно стоит вынести все методы типа
    //getInfo в отдельный класс, даже в отдельный пакет, внутри которого, так же, как мы это делали для меню в консоли,
    //создать классы с описанием и выводом определенных полей класса Human (через геттеры), а потом с помощью того же
    // StringBuilder собирать их в одну строку
    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        if (this.name != null) {
            sb.append(", имя: ");
            sb.append(name);
        }
        if (this.surname != null) {
            sb.append(", фамилия: ");
            sb.append(surname);
        }
        if (this.patronymic != null) {
            sb.append(", отчество: ");
            sb.append(patronymic);
        }
        if (this.age != 0) {
            sb.append(", возраст: ");
            sb.append(age);
        }
        sb.append(", мать: ");
        sb.append(motherGetInfo());
        sb.append(", отец: ");
        sb.append(fatherGetInfo());
        sb.append(", дети: ");
        sb.append(childrenGetInfo());
        return sb.toString();
    }

    //Далее сеттеры и геттеры
    @Override
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
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public LocalDate getBirth() {
        return birth;
    }
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public LocalDate getDeath() {
        return death;
    }
    public void setDeath(LocalDate death) {
        this.death = death;
    }
    @Override
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int getId() {
        return id;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    @Override
    public List<Human> getChildren() {
        return children;
    }
    @Override
    public Human getFather() {
        return father;
    }
    @Override
    public Gender getGender() {
        return gender;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    @Override
    public Human getMother() {
        return mother;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
}
