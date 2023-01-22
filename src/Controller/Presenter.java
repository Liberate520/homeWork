package Controller;

import Model.Service;
import Model.tree.Gender;
import View.View;

public class Presenter {
    View view;
    Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public void CreateButtonOnClick(String name){
        service.CreateButtonOnClick(name);
    }

    public void CreateCatButtonOnClick(String name, String gender, String age){
        Gender catGender = null;
        Integer catAge = null;
        if (gender.equalsIgnoreCase("м")){
            catGender = Gender.Male;
        } else if (gender.equalsIgnoreCase("ж")) {
            catGender = Gender.Female;
        } else {
            view.GetInfoFromUser("Введите пол (М / Ж)");
        }

        try {
            catAge = Integer.parseInt(age);
        } catch (Exception e){
            e.getLocalizedMessage();
            view.GetInfoFromUser("Введите возраст");
        }

        service.CreateCatButtonOnClick(name, catGender, catAge);
    }

    public void SaveButtonOnClick(String name){
        service.CreateButtonOnClick(name);
    }

    public void ExitButtonOnClick(){
        service.ExitButtonOnClick();
    }

    public void CreateHumanButtonOnClick(String name, String gender, String age) {
        Gender humanGender = null;
        Integer humanAge = null;
        if (gender.equalsIgnoreCase("м")){
            humanGender = Gender.Male;
        } else if (gender.equalsIgnoreCase("ж")) {
            humanGender = Gender.Female;
        } else {
            view.GetInfoFromUser("Введите пол (М / Ж)");
        }

        try {
            humanAge = Integer.parseInt(age);
        } catch (Exception e){
            e.getLocalizedMessage();
            view.GetInfoFromUser("Введите возраст");
        }

        service.CreateHumanButtonOnClick(name, humanGender, humanAge);
    }

    public void PrintContainerButtonClick() {
        service.PrintContainerButtonOnClick();
    }
}
