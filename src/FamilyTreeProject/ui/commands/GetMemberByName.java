package ui.commands;

import ui.View;

public class GetMemberByName implements Command{
    private View view;

    public GetMemberByName(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Найти пользователей по имени";
    }

    @Override
    public void execute() {
        view.getMembersByName();
    }
}
