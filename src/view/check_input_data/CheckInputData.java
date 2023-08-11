package view.check_input_data;

import view.MainMenu;

public class CheckInputData implements ICheckInputData{

    public boolean checkCommand(int numCommand, MainMenu menu) {
        if(numCommand > 0 && numCommand <= menu.getSize()) {
            return true;
        }
        else {
            return false;
        }
    }


}
