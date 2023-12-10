package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class AddKid extends Commands{

    public AddKid(View view){
        super("Добавить родителю ребёнка (Родитель, ребёнок)", view);
    }
    public void execute() {
        getView().addKid();
    }
}
