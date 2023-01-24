package Controller;

import Model.Service;
import Model.TempStorage;
import Model.tree.*;
import View.View;

import java.io.IOException;

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

    public void SaveButtonOnClick() throws IOException {
        service.SaveButtonOnClick();
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

    public TempStorage PrintContainerButtonClick() {
        return service.PrintContainerButtonOnClick();
    }

    public void CreateHumanTreeButtonOnClick(String name) {
        service.CreateHumanTreeButtonOnClick(name);
    }

    public void CreateCatTreeButtonOnClick(String name) {
        service.CreateCatTreeButtonOnClick(name);
    }

    public void AddHumanButtonOnClick(FamilyTree<Human> tree, Human human) {
        service.AddHumanButtonOnClick(tree, human);
    }

    public void AddCatButtonOnClick(FamilyTree<Cat> tree, Cat cat) {
        service.AddCatButtonOnClick(tree, cat);
    }

    public Container<Human> GetHumanContainer() {
        return service.GetHumanContainer();
    }

    public Container<Cat> GetCatContainer() {
        return service.GetCatContainer();
    }

    public Container<FamilyTree<Cat>> GetCatTreeContainer() {
        return service.GetCatTreeContainer();
    }

    public Container<FamilyTree<Human>> GetHumanTreeContainer() {
        return service.GetHumanTreeContainer();
    }
}
