package presenter;

import model.Service;
import model.TreeFamily.TreeFamily;
import model.human.Human;
import ui.View;

public class Presenter {
    //создаем методы под каждое действие - добавить человека, добавить родственные связи
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        //сообщаем view  с каким презентером она будет работать
    }
//    public void addName(String name) {
//        String answerName = service.getName(name);
//        view.print(answerName);
//
//    }
//
//    public void addFamily(String family) {
//        String answerFamily = service1.getName(family);
//        view.print(answerFamily);
//    }

    public void addHuman(Human human) {

        service.addHuman(human);
       // view.print();
    }

    public TreeFamily getTree(){

        return service.getTree();
    }

    //передаем в модель данные от презентера
}
