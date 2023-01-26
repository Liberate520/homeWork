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

    public void saveButtonOnClick() throws IOException {
        service.saveButtonOnClick();
    }

    public void exitButtonOnClick(){
        service.exitButtonOnClick();
    }


    public String createHumanButtonOnClick(String name, Gender gender, Integer age) {
        return service.createHumanButtonOnClick(name, gender, age);
    }

    public String createCatButtonOnClick(String name, Gender gender, Integer age){
        return service.createCatButtonOnClick(name, gender, age);
    }

    public TempStorage printContainerButtonClick() {
        return service.printContainerButtonOnClick();
    }

    public String createHumanTreeButtonOnClick(String name) {
        return service.createHumanTreeButtonOnClick(name);
    }

    public String createCatTreeButtonOnClick(String name) {
        return service.createCatTreeButtonOnClick(name);
    }

    public void addHumanButtonOnClick(FamilyTree<Human> tree, Human human) {
        service.addHumanButtonOnClick(tree, human);
    }

    public void addCatButtonOnClick(FamilyTree<Cat> tree, Cat cat) {
        service.addCatButtonOnClick(tree, cat);
    }

    public Container<Human> getHumanContainer() {
        return service.getHumanContainer();
    }

    public Container<Cat> getCatContainer() {
        return service.getCatContainer();
    }

    public Container<FamilyTree<Cat>> getCatTreeContainer() {
        return service.getCatTreeContainer();
    }

    public Container<FamilyTree<Human>> getHumanTreeContainer() {
        return service.getHumanTreeContainer();
    }
}
