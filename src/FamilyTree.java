import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private String name;
    private Integer volume;
    private List<Human> treeElements = new ArrayList<>();

    private Writable writable;

    public FamilyTree(String name) {
        this.name = name;
        this.volume = 0;
    }

    public FamilyTree(String name, List<Human> humans) {
        this(name);
        this.volume = humans.size();
        for (Human human : humans) {
            this.treeElements.add(human);
        }
    }

    public void addHuman(Human human){
        this.treeElements.add(human);
        this.volume++;
    }

    @Override
    public String toString() {
        StringBuilder humansForPrint = new StringBuilder();
        for (Human person : treeElements) {
            humansForPrint.append("\n").append(person);
            if (person.getMother() != null) {
                humansForPrint.append(", мать: ").append(person.getMother().getFullName());
            } else humansForPrint.append(", мать: ").append("Не указано");
            if (person.getFather() != null) {
                humansForPrint.append(", отец: ").append(person.getFather().getFullName());
            } else humansForPrint.append(", отец: ").append("Не указано");
            if (person.getChildren().size() !=0){
                humansForPrint.append(", дети: ");
                for (Human child : person.getChildren()) {
                    humansForPrint.append(child.getFullName()).append(", ");
                }
                humansForPrint.deleteCharAt(humansForPrint.length() - 2);
            } else humansForPrint.append(", дети: Не указано");
        }
        return "Семейное дерево " + name +
                " cостоит из " + volume + " " + countPostfix(volume) + ":" +
                humansForPrint;
    }

    public List<Human> getTreeElements() {
        return treeElements;
    }

    public String getName() {
        return name;
    }

    public void findByName(String name){
        for (Human human : this.treeElements) {
            if (human.getFullName().equalsIgnoreCase(name)) {
                System.out.println(human);
            }
        }
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void save() throws IOException {
        if (writable != null) {
            writable.writeToFile(this);
        }
    }

    public void read() throws IOException {
        if (writable != null) {
            writable.readFromFile(this);
        }
    }

    public static String countPostfix(int num)
    {
        String result = null;
        if(num == 11) result = "человек";
        else if(("" + num).endsWith("1")) result = "человека";
        else if(num > 11 && num < 15) result = "человек";
        else if(num % 10 > 1 && num % 10 < 5) result = "человек";
        else result = "человек";

        return result;
    }
}