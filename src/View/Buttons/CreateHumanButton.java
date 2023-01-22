package View.Buttons;
import View.*;

public class CreateHumanButton extends MenuButton{
    String buttonName = "Создать человека";
    View view;

    public CreateHumanButton(View view) {
        this.view = view;
    }

    public void onClick(){
        view.CallCreateHumanButton();
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
