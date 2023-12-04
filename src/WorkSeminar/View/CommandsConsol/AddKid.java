package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class AddKid extends Commands{

    public AddKid(View view){
        super("Добавить родителю ребёнка ", view);
    }
    public void execute() {
        getView().addKid();
    }
}
