package Tree.homeWork.src.Presenter;

import Tree.homeWork.src.model.Service;
import Tree.homeWork.src.ui.View;

public class Presenter {
//    private View view;
//    private Service service;
//
//    public Presenter(View view, Service service) {
//        this.view = view;
//        this.service = service;
//        view.setPresenter(this);
//    }
//    public void addHuman(String firstName, String lastName){
//        service.addHuman(firstName, lastName);
//    }
//    public void getHumanList(){
//        view.print(service.getHumanList());
//
//    }
    //-------------------------------------------------------------------
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void addHuman(String name){
        service.addHuman(name);
    }
    public void getHumanList(){
        view.print(service.getHumanList());

    }
}
