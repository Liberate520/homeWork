package ru.medved_sa.tree_family.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private long id;
    private String firstName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Human> parents;
    private List<Human> children;

    /**
     * Конструктор с максимальным количеством данных для создания сущности Human.
     * Важно!!! Поля Human father, Human mother будут созданы внутри parents ArrayList<>() и только если эти поля
     * будут созданы при создании сущности человека, иначе parents ArrayList<>() будет пустым.
     * Будет создан пустой children ArrayList<>() для хранения, при необходимости, списка детей.
     * @param firstName имя
     * @param gender пол
     * @param birthDate дата рождения
     * @param deathDate дата смерти
     * @param father отец
     * @param mother мать
     */
    public Human(String firstName, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother) {
        {
            this.firstName = firstName;
            this.birthDate = birthDate;
            this.deathDate = deathDate;
            this.gender = gender;
            parents = new ArrayList<>();
            if (father != null) {
                parents.add(father);
            }
            if (mother != null) {
                parents.add(mother);
            }
            children = new ArrayList<>();
        }
    }

    /**
     * Конструктор для создания человека с тремя параметрами. Так как этот конструктор будет обращаться к конструктору
     * верхнего уровня, то поля задействованные в конструкторе верхнего уровня, но не нужные в этом конструкторе
     * прописываются как нулевое значение -> null.
     * @param firstName имя
     * @param gender пол
     * @param birthDate дата рождения
     */
    public Human(String firstName, Gender gender, LocalDate birthDate) {
        this(firstName, gender, birthDate, null, null, null);
    }

    /**
     * Конструктор для создания человека с пятью параметрами. Так как этот конструктор будет обращаться к конструктору
     * верхнего уровня, то поля задействованные в конструкторе верхнего уровня, но не нужные в этом конструкторе
     * прописываются как нулевое значение -> null.
     * @param firstName имя
     * @param gender пол
     * @param birthDate дата рождения
     * @param father отец (прописывается раннее созданная сущность)
     * @param mother мать (прописывается раннее созданная сущность)
     */
    public Human(String firstName, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(firstName, gender, birthDate, null, father, mother);
    }

    /**
     * Метод принимает на вход сущность ребенка. Если такой же сущности (исключение дубликатов)
     * в children ArrayList<>(), то сущность будет добавлена в children.
     * @param child сущность ребенка.
     */
    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
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

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }
    //</editor-fold>

    /**
     * Переопределенный метод печати в консоль. Методы ...Info() описаны и прокомментированы ниже.
     * @return строка для визуально-понятного вывода в консоль.
     */
    @Override
    public String toString() {
        return "id: " + id +
                ", имя: " + firstName +
                ", пол: " + getGender() +
                ", дата рождения: " + getBirthDate() +
                ", " + getFindFatherName() +
                ", " + getFindMotherName() +
                ", " + getFindInfoAboutChildren();
    }

    /**
     * Метод, геттер. Если внутри той сущности, к которой применяется этот метод, есть ссылка на сущность
     * у которой пол обозначен как Male, то вернется найденная сущность, иначе вернется null.
     * @return Вернёт всю сущность отца, иначе null
     */
    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    /**
     * Метод, геттер. Если, внутри той сущности, к которой применяется этот метод, есть ссылка на сущность
     * у которой пол обозначен как Female, то вернется найденная сущность, иначе вернется null.
     * @return Вернёт всю сущность матери, иначе null
     */
    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    /**
     * Метод добавляющий информацию об отце в метод toString(), но может быть применен и отдельно. Метод формирует
     * строку. С помощью метода getMother() находит сущность по-гендерному признаку и достает из найденной
     * сущности имя, иначе возвращает null.
     * @return Сформированная строка с июнем отца или что имя неизвестно.
     */
    public String getFindFatherName() {
        String result = "отец: ";
        Human father = getFather();
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
     * @return Сформированная строка с июнем матери или что имя неизвестно.
     */
    public String getFindMotherName() {
        String result = "мать: ";
        Human mother = getMother();
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
                && Objects.equals(parents, human.parents)
                && Objects.equals(children, human.children);
    }

}

