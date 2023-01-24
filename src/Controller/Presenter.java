package Controller;

import Model.Service;
import Model.tree.Gender;
import View.View;

public class Presenter {
    View view;
    Service service;

    public void setView(View view) {
        this.view = view;
    }

    public Presenter(Service service) {
        this.service = service;
    }

    public void CreateButtonOnClick(String name){
        service.CreateButtonOnClick(name);
    }

    public void SaveButtonOnClick(String name){
        service.CreateButtonOnClick(name);
    }

    public void ExitButtonOnClick(){
        service.ExitButtonOnClick();
    }


    public void CreateHumanButtonOnClick(String name, Gender gender, Integer age) {
        service.CreateHumanButtonOnClick(name, gender, age);
    }

    public void CreateCatButtonOnClick(String name, Gender gender, Integer age){
        service.CreateCatButtonOnClick(name, gender, age);
    }

    public void PrintContainerButtonClick() {
        service.PrintContainerButtonOnClick();
    }

    public void CreateTreeButtonOnClick(String name) {
        service.CreateTreeButtonOnClick(name);
    }
}
