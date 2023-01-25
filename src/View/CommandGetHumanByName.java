package Seminars_OOP.HW_6.src.View;

import Seminars_OOP.HW_6.src.View.Options;
import Seminars_OOP.HW_6.src.View.View;

import java.util.Scanner;

public class CommandGetHumanByName implements Options {
    View view;

    public CommandGetHumanByName(View view){
        this.view = view;
    }

    @Override
    public void execute() {

        view.GetHumanByName();
    }

//    }
    @Override
    public String description() {

        return "Найдем человека по имени";
    }
}


