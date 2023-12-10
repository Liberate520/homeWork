import model.HR.Human;
import model.HR.HumanBuilder;
import model.familyTree.FamilyTree;
import model.familyTree.commonParam;

@SuppressWarnings("ALL")
public class Service <E extends commonParam<E>> {
    private FamilyTree<E> humanList;
    private HumanBuilder builder;

    public Service (){
        humanList = new humanList();
        builder = new HumanBuilder();

    }
    public  void addHuman (String name, int birthDate) {
        Human human = builder.build(name, birthDate);
        humanList.addHuman(human);

    }
    public void getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("список семьи: \n");
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append(" \n");
        }
    }
}
