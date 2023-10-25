package ru.medved_sa.tree_family.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private long id;
    private String firstName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;

    /**
     * Конструктор с максимальным количеством данных для создания сущности Human.
     * Важно!!! Поля Human father, Human mother будут созданы внутри parents ArrayList<>() и только если эти поля
     * будут созданы при создании сущности человека, иначе parents ArrayList<>() будет пустым.
     * Будет создан пустой children ArrayList<>() для хранения, при необходимости, списка детей.
     *
     * @param firstName имя
     * @param gender    пол
     * @param birthDate дата рождения
     * @param deathDate дата смерти
     * @param father    отец
     * @param mother    мать
     */
    public Human(String firstName, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother) {
        {
            this.id = -1;
            this.firstName = firstName;
            this.gender = gender;
            this.birthDate = birthDate;
            this.deathDate = deathDate;
            this.father = father;
            this.mother = mother;
            children = new ArrayList<>();
        }
    }

    /**
     * Конструктор для создания человека с тремя параметрами. Так как этот конструктор будет обращаться к конструктору
     * верхнего уровня, то поля задействованные в конструкторе верхнего уровня, но не нужные в этом конструкторе
     * прописываются как нулевое значение -> null.
     *
     * @param firstName имя
     * @param gender    пол
     * @param birthDate дата рождения
     */
    public Human(String firstName, Gender gender, LocalDate birthDate) {
        this(firstName, gender, birthDate, null, null, null);
    }

    /**
     * Конструктор для создания человека с пятью параметрами. Так как этот конструктор будет обращаться к конструктору
     * верхнего уровня, то поля задействованные в конструкторе верхнего уровня, но не нужные в этом конструкторе
     * прописываются как нулевое значение -> null.
     *
     * @param firstName имя
     * @param gender    пол
     * @param birthDate дата рождения
     * @param father    отец (прописывается раннее созданная сущность)
     * @param mother    мать (прописывается раннее созданная сущность)
     */
    public Human(String firstName, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(firstName, gender, birthDate, null, father, mother);
    }

    /**
     * Метод принимает на вход сущность ребенка. Проверка, если такой сущности в children ArrayList<>() нет,
     * то сущность будет добавлена в children.
     *
     * @param child сущность ребенка.
     */
    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    /**
     * Метод определения отцовства или материнства на основании гендерного признака.
     *
     * @param parent сущность персон
     */
    public void addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
    }

    /**
     * Метод вычисляющий период межу двумя входящими датами и возвращающий количество полных лет.
     *
     * @param birthDate дата в формате LocalDate
     * @param deathDate дата в формате LocalDate
     * @return полных лет
     */
    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    /**
     * Метод вычисления возраста для сущности Human.
     *
     * @return количество полных лет
     */
    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    /**
     * Метод создающий список родителей. Родители могут быть в списке как один, так сразу два. В дальнейшем
     *
     * @return Список родителей
     */
    public List<Human> getParents() {
        List<Human> parent = new ArrayList<>(2);
        if (father != null) {
            parent.add(father);
        }
        if (mother != null) {
            parent.add(mother);
        }
        return parent;
    }


    //<editor-fold desc="Геттеры и сеттеры">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(firstName);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(" ");
        sb.append(getPostfixGeneration());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getFindMotherName());
        sb.append(", ");
        sb.append(getFindFatherName());
        sb.append(", ");
        sb.append(getFindInfoAboutChildren());
        return sb.toString();
    }

    /**
     * Метод генерации постфикса к возрасту (год/года/лет)
     *
     * @return вернет строку префикса
     */
    public String getPostfixGeneration() {
        int age = getAge();
        int ageLastNumber = age % 10;
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);
        String old = "";
        if (ageLastNumber == 1) {
            old = "год";
            return old;
        } else if (ageLastNumber == 0 || ageLastNumber >= 5) {
            old = "лет";
            return old;
        } else if (ageLastNumber >= 2) {
            old = "года";
            return old;
        } else if (isExclusion) {
            old = "лет";
            return old;
        }
        return old;
    }

    /**
     * Если значение поле spouse пустое, возвращается нет, иначе имя супруга, супруги
     *
     * @return вернет - "нет" или имя супруга
     */
    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getFirstName();
        }
        return res;
    }



    /**
     * Метод добавляющий информацию об отце в метод toString(), но может быть применен и отдельно. Метод формирует
     * строку. С помощью метода getMother() находит сущность по-гендерному признаку и достает из найденной
     * сущности имя, иначе возвращает null.
     *
     * @return Сформированная строка с июнем отца или что имя неизвестно.
     */
    public String getFindFatherName() {
        String result = "отец: ";
//        Human father = getFatherInfo();
        if (father != null) {
            result += father.getFirstName();
        } else {
            result += "неизвестен";
        }
        return result;

    }

    /**
     * Метод добавляющий информацию об матери в метод toString(), но может быть применен и отдельно. Метод формирует
     * строку. С помощью метода getMother() находит сущность по-гендерному признаку и достает из найденной
     * сущности имя, иначе возвращает null.
     *
     * @return Сформированная строка с июнем матери или что имя неизвестно.
     */
    public String getFindMotherName() {
        String result = "мать: ";
//        Human mother = getMotherInfo();
        if (mother != null) {
            result += mother.getFirstName();
        } else {
            result += "неизвестна";
        }
        return result;
    }

    /**
     * Метод добавляющий информацию, список детей в метод toString(), но может быть применен и отдельно. Метод
     * формирует StringBuilder, который содержит в себе список всех имен детей или что дети отсутствуют.
     *
     * @return Сформированная StringBuilder для вывода в консоль всех детей.
     */
    public String getFindInfoAboutChildren() {
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        // Проходим по всему children ArrayList<>()
        if (children.size() != 0) { // если он не пуст, то
            sb.append(children.get(0).getFirstName()); // первый элемент добавляем в sb
            for (int i = 1; i < children.size(); i++) { // если есть ещё элементы, то по-очередно
                sb.append(", "); // через запятую
                sb.append(children.get(i).getFirstName()); // добавим все...
            }
        } else {
            sb.append("отсутствуют"); // иначе...
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(firstName, human.firstName)
                && Objects.equals(birthDate, human.birthDate)
                && Objects.equals(deathDate, human.deathDate)
                && gender == human.gender
                && Objects.equals(mother, human.mother)
                && Objects.equals(father, human.father)
                && Objects.equals(children, human.children);
    }

}

