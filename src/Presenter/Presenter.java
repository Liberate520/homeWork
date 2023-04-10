package Presenter;

import UI.View;
import familyApi.FamilyService;


public class Presenter {
    private View view;
    private FamilyService service;

    public Presenter(View view, FamilyService service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void choseNumber(int number){
        String res;
        switch (number){
            case 1:
                res = service.getInfo();
                view.print(res);

            case 2:
                String name = view.getName();
                res = service.getInfoByName(name);
                view.print(res);

            case 3:
                break;

        }

    }
}
