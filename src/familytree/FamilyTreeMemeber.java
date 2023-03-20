package familytree;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class FamilyTreeMemeber implements Serializable {
    protected int id;
    private String name;
    private String sex;
    private Date birthDay;
    private Date deathDay;
    private FamilyTreeMemeber[] parents;
    private FamilyTreeMemeber spouse;
    private ArrayList<FamilyTreeMemeber> children;

    public FamilyTreeMemeber(String name, String sex, Date birthDay, FamilyTreeMemeber[] parents) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.deathDay = null;
        this.parents = parents;// != null ?  parents.toArray(new FamilyTreeMemeber[0]) : null;
        this.children = new ArrayList<FamilyTreeMemeber>();
        if (this.parents != null) {
            this.parents[0].children.add(this);
            this.parents[1].children.add(this);
        }
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        var base = "ID: %d\n" +
                "Имя: %s\n" +
                "Пол: %s\n" +
                "Дата рождения: %s\n" +
                "Дата смерти: %s\n";
        var df = new SimpleDateFormat("dd.MM.yyyy");
        str.append(String.format(base, id + 1, name, sex, df.format(birthDay), deathDay != null ? df.format(deathDay) : "---"));
        str.append("Родители:\n");
        if (parents != null) {
            var sparents = "  %s (ID: %s)\n" +
                    "  %s (ID: %s)\n";
            str.append(String.format(sparents, parents[0].name, parents[0].id + 1, parents[1].name, parents[1].id + 1));
        } else
            str.append("  Неизвестно\n");
        str.append("Дети:\n");
        if (children.size() > 0) {
            for (FamilyTreeMemeber child : children)
                str.append(String.format("  %s (ID: %s)\n", child.name, child.id + 1));
        } else
            str.append("  Нет\n");
        return str.toString();
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String sex() {
        return sex;
    }

    public Date birthDay() {
        return birthDay;
    }

    public Date deathDay() {
        return deathDay;
    }

    public void deathDay(Date deathDay) {
        this.deathDay = deathDay;
    }

    public FamilyTreeMemeber[] parents() {
        return parents != null ? Arrays.copyOf(parents, parents.length) : null;
    }

    public FamilyTreeMemeber spouse() {
        return spouse;
    }

    public void spouse(FamilyTreeMemeber spouse) {
        this.spouse = spouse;
    }

    public FamilyTreeMemeber addSpouse(String name, Date birthDay) {
        String sex = this.sex == "мужской" ? "женский" : "мужской";
        this.spouse = new FamilyTreeMemeber(name, sex, birthDay, null);
        return this.spouse;
    }

    public FamilyTreeMemeber[] children() {
        return children.toArray(new FamilyTreeMemeber[0]);
    }
}
