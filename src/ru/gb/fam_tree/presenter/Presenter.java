package ru.gb.fam_tree.presenter;

import ru.gb.fam_tree.model.family_tree.FamilyTree;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Human;
import ru.gb.fam_tree.model.family_tree.service.Service;
import ru.gb.fam_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(Human human){
        service.addHuman(human);
    }

    public void getHumansInfo(){
        service.getHumansInfo();
    }

    public void sortByName(){
        service.sortByName();
        getHumansInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getHumansInfo();
    }

    public void LoadFromFile(String path){
        service.LoadFormFile(path);
        getHumansInfo();
    }

    public void SaveToFile(String path){
        service.SaveToFile(path);
    }

}
