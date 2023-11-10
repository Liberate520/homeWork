import builder.HumanBuilder;
import human.Gender;
import human.Human;
import tree.FamilyTree;

public class Service {
    public final char[] getHumansListInfo = null;
    private FamilyTree <Human> tree;
    private HumanBuilder builder;

    public FamilyTree<Human> getFamilyTree() {
        return this.tree;
    }

    public Service() {
        tree = new FamilyTree<>(0);
        builder = new HumanBuilder();
    }

    public Service(FamilyTree <Human> tree) {
        this.tree = tree;
        builder = new HumanBuilder();
    }

    public void addHuman(String name, String surname, Gender gender) {
        Human human = builder.build(name, surname, gender);
        tree.addHuman(human);
    }
    public String getHumansListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи: \n");

        for(Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortBySurname() {
        tree.sortBySurname();
    }

    @Override
    public String toString() {
        return getHumansListInfo();
    }
}
