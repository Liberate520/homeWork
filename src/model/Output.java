package model;

import view.ConsoleView;

public class Output {

    public void outputToConsole(String Str){
        ConsoleView.print(Str);
    }

    public void consolePrintAllHumans(HumanList list){
        String result = "";
        result = list.humanListToString();
        ConsoleView.print(result);
    }
}

