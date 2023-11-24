package family_tree.model.family_tree.human;

public class AddFatherHuman {
    private Human thishuman;
    private Human relativehuman;

    AddFatherHuman(Human thishuman, Human relativehuman){
        this.thishuman = thishuman;
        this.relativehuman = relativehuman;
        this.thishuman.AddFather(relativehuman);
    }

}
