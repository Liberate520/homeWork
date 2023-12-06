package presenter;

import service.Service;
import viewer.View;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }

}
