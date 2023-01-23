package Seminars_OOP.HW_5.src.View;

import Seminars_OOP.HW_5.src.Model.Human;

import java.util.List;

public class CommandGetAllHuman implements Options {

    View view;

    public CommandGetAllHuman(View view) {

        this.view = view;
    }
    @Override
    public void execute() {
        view.GetAllHuman();


    }
    @Override
    public String description() {
        return "Выведем на печать весь список";
    }
}


