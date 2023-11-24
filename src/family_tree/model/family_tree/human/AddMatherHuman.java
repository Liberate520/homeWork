package family_tree.model.family_tree.human;

public class AddMatherHuman {
    private Human thishuman;
    private Human relativehuman;

    AddMatherHuman(Human thishuman, Human relativehuman){
        this.thishuman = thishuman;
        this.relativehuman = relativehuman;
        this.thishuman.AddMother(relativehuman);
    }

}
