import java.util.ArrayList;
import java.util.List;

public class Human {
    String name;
    String patronymic;
    String surname;
    int dateBirth;
    int dateDeath;

    Human father;
    Human mother;
    List<Human> children = new ArrayList<>();

    public Human() {
    }

    /**
     * 
     * @param name       // Input null if unknown
     * @param patronymic // Input null if unknown
     * @param surname    // Input null if unknown
     * @param dateBirth  // Input 0 if unknown
     * @param dateDeath  // Input 0 if unknown
     * @param father     // Input null if unknown
     * @param mother     // Input null if unknown
     */

    public Human(String name, String patronymic, String surname,
            int dateBirth, int dateDeath, Human father, Human mother) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name:");
        if (name != null)
            sb.append(" " + name);
        if (patronymic != null)
            sb.append(" " + patronymic);
        if (surname != null)
            sb.append(" " + surname);
        if (dateBirth != 0)
            sb.append(" (" + dateBirth);
        else
            sb.append(" ( ??? ");
        if (dateDeath != 0)
            sb.append(" - " + dateDeath + ")");
        else
            sb.append(" - ??? )");

        return sb.toString();
    }

    public String GetDescendants() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\nDescendants:\n");
        if (children.size() > 0) {
            for (Human human : children) {
                sb.append(human.toString() + "\n");
            }
        } else
            sb.append("Unknown!\n");
        return sb.toString();
    }

    public String GetParents() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\nParents:");
        sb.append("\nFather:");
        if (father != null)
            sb.append("\n" + father.toString());
        else
            sb.append("\nUnknown!");

        sb.append("\nMother:");
        if (mother != null)
            sb.append("\n" + mother.toString());
        else
            sb.append("\nUnknown!\n");
        return sb.toString();
    }
}
