package presenter;

import model.ServiceTree;
import model.TreeFamily.TreeFamily;
import ui.View;

public class Presenter {
    //создаем методы под каждое действие - добавить человека, добавить родственные связи
    private View view;
    private ServiceTree service;

    public Presenter(View view, ServiceTree service) {
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

    public void addHuman(String family, String name) {

        service.addHuman(family, name);
       // view.print();
    }

    public TreeFamily getTree(){
        return service.getTree();
    }

//    public boolean searchHuman() {
//        return service.searchHuman();
//    }

    //передаем в модель данные от презентера
}
