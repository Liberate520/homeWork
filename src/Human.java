import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(int id, String name, LocalDate birthDate, LocalDate deathDate, Human mother,
                 Human father,
                 List<Human> childrens) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.childrens = childrens;
    }

    public Human() {
        this(0, null, null, null, null, null, null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("\n").append(id).append(", имя: ").append((name)).append(", дата рождения: ").append(birthDate);
        if (deathDate == null)
            sb = sb.append(", возраст: ").append(getAge());
        else
            sb = sb.append(", дата смерти: ").append(deathDate);
        if (mother == null)
            sb = sb.append(", мать не определена");
        else
            sb = sb.append(", мать: ").append(mother.getName());
        if (father == null)
            sb = sb.append(", отец не определен");
        else
            sb = sb.append(", отец: ").append(father.getName());
        if (childrens == null)
            sb = sb.append(", детей нет");
        else {
            sb = sb.append(", дети:");
            for (int i = 0; i < childrens.size(); i++) {
                sb = sb.append(" ").append(childrens.get(i).getName());
            }
        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAge() {
        LocalDate currenDate = LocalDate.now();
        if (getDeathDate() == null)
            return Period.between(birthDate, currenDate).getYears();
        else
            return Period.between(birthDate, deathDate).getYears();
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void addChildren(Human person) {
        if (this.childrens == null)
            this.childrens = new ArrayList<>();
        this.childrens.add(person);
    }

}