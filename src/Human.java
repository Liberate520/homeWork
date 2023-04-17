import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private List<Human> brothers;
    private List<Human> sisters;

    public Human(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Human(String firstName, String lastName, LocalDate birthDate, Gender gender,
            Human mother, Human father, List<Human> children, List<Human> brothers, List<Human> sisters) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.brothers = brothers;
        this.sisters = sisters;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public List<Human> getBrothers() {
        return brothers;
    }

    public void setBrothers(List<Human> brothers) {
        this.brothers = brothers;
    }

    public List<Human> getSisters() {
        return sisters;
    }

    public void setSisters(List<Human> sisters) {
        this.sisters = sisters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(birthDate, human.birthDate) &&
                gender == human.gender &&
                Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father) &&
                Objects.equals(children, human.children) &&
                Objects.equals(brothers, human.brothers) &&
                Objects.equals(sisters, human.sisters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, gender, mother, father, children, brothers, sisters);
    }

    @Override
    public String toString() {
        String genderStr = "";
        if (gender == Gender.MALE) {
            genderStr = "мужской";
        } else if (gender == Gender.FEMALE) {
            genderStr = "женский";
        }

        String str = "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", День рождения=" + birthDate +
                ", пол=" + genderStr;
        if (mother != null) {
            str += ", Мать=" + mother.getFirstName() + " " + mother.getLastName();
        }
        if (father != null) {
            str += ", Отец=" + father.getFirstName() + " " + father.getLastName();
        }
        if (children != null && !children.isEmpty()) {
            str += ", Дети=";
            for (int i = 0; i < children.size(); i++) {
                str += children.get(i).getFirstName() + " " + children.get(i).getLastName();
                if (i != children.size() - 1) {
                    str += ", ";
                }
            }
        }
        if (brothers != null && !brothers.isEmpty()) {
            str += ", Братья=";
            for (int i = 0; i < brothers.size(); i++) {
                str += brothers.get(i).getFirstName() + " " + brothers.get(i).getLastName();
                if (i != brothers.size() - 1) {
                    str += ", ";
                }
            }
        }
        return str;
    }
}

// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей
// выбранного человека.

// Сделать PR к проекту: https://github.com/Liberate520/homeWork
// В качестве ответа указать ссылку на PR
// Ссылка на то как сделать пулреквест смотри в материалах к уроку
// Если PR все таки не дается, то можно и ссылкой на гит репозиторий