package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class GetSisBroth extends Commands {
    public GetSisBroth(View view) {
        super("Показать сестёр и братьев персонажа ", view);
    }

    public void execute() {
        getView().getSisBroth();
    }
}
