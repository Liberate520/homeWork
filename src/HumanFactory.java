package src;

import src.ui.ConsoleForms;

import java.util.HashMap;

public class HumanFactory {

    private ConsoleForms forms;
    private HashMap<String, String> personData;

    public Human creteHuman(){
        forms = new ConsoleForms();
        personData = new HashMap<>(forms.humanForm());

        return new Human(
                personData.get("gender"),
                personData.get("dateOfBorn"),
                personData.get("dateOfDeath"),
                personData.get("placeOfBirth"),
                personData.get("firstName"),
                personData.get("patronymic"),
                personData.get("lastName")
                );
    }


}
