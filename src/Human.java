import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private LocalDate dataOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Kinship kinship;
    private int id;
    private List<Human> cildrenList;
    private List<Human> parentsList;
    private List<Human> tempList;
    private int idKinship;
    private String str;

    public Human(String name, Gender gender, LocalDate dataOfBirth, LocalDate dataOfDeath) {
        this.name = name;
        this.gender = gender;
        this.dataOfBirth = dataOfBirth;
        this.dateOfDeath = dataOfDeath;
        cildrenList = new ArrayList<>();
        parentsList = new ArrayList<>();
        tempList = new ArrayList<>();

    }

    public Human(String name, Gender gender, LocalDate dataOfBirth) {
        this(name, gender, dataOfBirth, null);
    }

    public int getId() {
        return id;
    }

    public void addKinship(Human human, Kinship kinship) {
        this.kinship = kinship;
        if (this.kinship == Kinship.child) {
            cildrenList.add(human);
        } else if (this.kinship == Kinship.parent) {
            parentsList.add(human);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void SetGender(Gender gender) {
        this.gender = gender;
    }

    public String getKinshipInfo(Kinship kinship) {
        this.kinship = kinship;
        if (this.kinship == Kinship.child) {
            this.tempList = cildrenList;
            this.str = "Список детей:\n";
        } 
        else if (this.kinship == Kinship.parent) {
            this.tempList = parentsList;
            this.str = "Список родителей:\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + "\n");
        stringBuilder.append(this.str);
        // String str=null;
        this.idKinship=0;
        for (Human temp : this.tempList) {
            this.idKinship++;
            stringBuilder.append("ID_Kinship: " + idKinship);
            stringBuilder.append(temp);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        String str = "мужской";
        if (this.gender == Gender.female)
            str = "женский";
        if (dateOfDeath == null)
            return " ID_Human: " + id + " имя: " + name + ", пол: " + str + ", Дата рождения: " + dataOfBirth;
        else
            return " ID_Human: " + id + " имя: " + name + ", пол: " + str + ", Дата рождения: " + dataOfBirth
                    + ", Дата смерти: " + dateOfDeath;
    }

}
